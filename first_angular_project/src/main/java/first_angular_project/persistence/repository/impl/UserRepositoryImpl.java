package first_angular_project.persistence.repository.impl;

import first_angular_project.view.controller.dto.request.UserRequestDto;
import first_angular_project.persistence.entity.User;
import first_angular_project.persistence.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepositoryImpl implements UserRepository {
    private long countID = 1;
    private List<User> users = new ArrayList<>();

    @Override
    public void create(UserRequestDto userRequestDto) {
        User user = new User();
        user.setId(countID);
        setterFieldUser(user, userRequestDto);
        users.add(user);

        countID++;
    }

    @Override
    public void update(UserRequestDto userRequestDto, long id) {
        User user = users.stream().filter(u -> u.getId() == id).findFirst().get();
        setterFieldUser(user, userRequestDto);
    }

    @Override
    public void delete(long id) {
        users.remove(users.stream().filter(u -> u.getId() == id).findFirst().get());
    }

    @Override
    public User findById(long id) {
        return users.stream().filter(u -> u.getId() == id).findFirst().get();
    }

    @Override
    public List<User> findAll(WebRequest request) {
        return users;
    }

    private void setterFieldUser(User user, UserRequestDto userRequestDto) {
        user.setFirstname(userRequestDto.getFirstname());
        user.setLastname(userRequestDto.getLastname());
        user.setBirthday(userRequestDto.getParserDateBirthday());
        user.setCity(user.getCity());
        user.setPhone(user.getPhone());
    }
}