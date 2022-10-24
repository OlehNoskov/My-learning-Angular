package first_angular_project.facade.impl;

import first_angular_project.facade.UserFacade;
import first_angular_project.persistence.entity.User;
import first_angular_project.service.UserService;
import first_angular_project.view.dto.request.UserRequestDto;
import first_angular_project.view.dto.response.UserResponseDto;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserFacadeImpl implements UserFacade {
    private final UserService userService;

    public UserFacadeImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void create(UserRequestDto userRequestDto) {
        User user = new User();
        setAllFieldsUser(userRequestDto, user);
        userService.create(user);
    }

    @Override
    public void update(UserRequestDto userRequestDto, long id) {
        User user = userService.findById(id).get();
        setAllFieldsUser(userRequestDto, user);
        userService.update(user);
    }

    @Override
    public void delete(long id) {
        userService.delete(id);
    }

    @Override
    public UserResponseDto findById(long id) {
        return new UserResponseDto(userService.findById(id).get());
    }

    @Override
    public List<UserResponseDto> findAllEntity() {
        return null;
    }

    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    public List<User> searchAllUsersFromDateToDate(Date from, Date to) {
        return userService.findAll().stream()
                .filter(u -> u.getBirthDay().after(from) && u.getBirthDay().before(to))
                .collect(Collectors.toList());
    }

    private void setAllFieldsUser(UserRequestDto userRequestDto, User user) {
        if (isEmailValid(userRequestDto.getEmail())) {
            user.setEmail(userRequestDto.getEmail());
        }
        user.setFirstname(userRequestDto.getFirstname());
        user.setLastname(userRequestDto.getLastname());

        if (isInputDateValid(userRequestDto.getParserDateBirthday()) && isUserAgeValid(userRequestDto.getParserDateBirthday())) {
            user.setBirthDay(userRequestDto.getParserDateBirthday());
        }
        user.setCity(userRequestDto.getCity());
        user.setPhone(userRequestDto.getPhone());
    }

    private boolean isEmailValid(String email) {
        String regexEmail = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isInputDateValid(Date userBirthday) {
        return userBirthday.before(new Date(System.currentTimeMillis()));
    }

    private boolean isUserAgeValid(Date userBirthday) {
        int minAge = 0;
        try (InputStream input = new FileInputStream("validation.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            minAge = Integer.parseInt((String) properties.get("min.age"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Period.between(convertToLocalDateViaInstant(userBirthday), convertToLocalDateViaInstant(new Date(System.currentTimeMillis()))).getYears() >= minAge;
    }

    private LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UserRequestDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserRequestDto userRequestDto = (UserRequestDto) target;
        if (!isInputDateValid(userRequestDto.getParserDateBirthday()) || !isUserAgeValid(userRequestDto.getParserDateBirthday())) {
            errors.rejectValue("birthday", "date.input.error");
        }
    }

    @Override
    public void validateDates(Object target, Errors errors) {
        UserRequestDto userRequestDto = (UserRequestDto) target;
        if (!userRequestDto.isDateFromBeforeDateTo()) {
            errors.rejectValue("dates", "date.input.error");
        }
    }
}