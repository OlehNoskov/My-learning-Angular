package first_angular_project.persistence.repository;

import first_angular_project.view.controller.dto.request.UserRequestDto;
import first_angular_project.persistence.entity.User;

import org.springframework.web.context.request.WebRequest;

import java.util.List;

public interface UserRepository {
    void create(UserRequestDto userRequestDto);

    void update(UserRequestDto userRequestDto, long id);

    void delete(long id);

    User findById(long id);

    List<User> findAll(WebRequest request);
}