package first_angular_project.view.controller;

import first_angular_project.facade.UserFacade;

import first_angular_project.persistence.entity.User;
import first_angular_project.view.dto.request.UserRequestDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PutMapping("/new")
    public ResponseEntity<Boolean> createUser(@RequestBody UserRequestDto userRequestDto) {
        userFacade.create(userRequestDto);
        return ResponseEntity.ok(true);
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userFacade.findAll());
    }
}