package first_angular_project.view.controller.dto.response;

import first_angular_project.persistence.entity.User;
import lombok.Getter;

import java.util.Date;

public class UserResponseDto {
    @Getter
    private long id;
    @Getter
    private String firstname;
    @Getter
    private String lastname;
    @Getter
    private Date birthday;
    @Getter
    private String city;
    @Getter
    private String phone;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.birthday = user.getBirthday();
        this.city = user.getCity();
        this.phone = user.getPhone();
    }
}