package first_angular_project.facade;

import first_angular_project.persistence.entity.User;
import first_angular_project.view.dto.request.UserRequestDto;
import first_angular_project.view.dto.response.UserResponseDto;

import org.springframework.validation.Errors;

import java.util.Date;
import java.util.List;

public interface UserFacade extends BaseFacade<UserRequestDto, UserResponseDto> {
    List<User> searchAllUsersFromDateToDate(Date from, Date to);
    List<User> findAll();
    void validateDates(Object target, Errors errors);
}