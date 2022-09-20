package first_angular_project.view.controller.controller;

import first_angular_project.view.controller.dto.request.UserRequestDto;
import first_angular_project.persistence.entity.User;
import first_angular_project.persistence.repository.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String findAll(Model model, WebRequest request) {
        List<User> users = userRepository.findAll(request);
        model.addAttribute("list", users);
        return "pages/user/users_all";
    }

    @GetMapping("/new")
    public String redirectToNewUserPage(Model model) {
        model.addAttribute("user", new UserRequestDto());
        return "pages/user/user_new";
    }

    @PostMapping("/new")
    public String createNewUser(@ModelAttribute("user") UserRequestDto userRequestDto) {
        userRepository.create(userRequestDto);
        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        User user = userRepository.findById(id);
        model.addAttribute("user", user);
        return "pages/user/user_update";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") UserRequestDto userRequestDto, BindingResult bindingResult) {
        userRepository.update(userRequestDto, id);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userRepository.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        User user = userRepository.findById(id);
        model.addAttribute("user", user);
        return "pages/user/user_details";
    }
}