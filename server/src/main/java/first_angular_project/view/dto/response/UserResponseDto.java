package first_angular_project.view.dto.response;

import first_angular_project.persistence.entity.User;
import lombok.Getter;

import java.util.Date;

public class UserResponseDto extends ResponseDto {
    @Getter
    private String email;
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
        setId(user.getId());
        this.email = user.getEmail();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.birthday = user.getBirthDay();
        this.city = user.getCity();
        this.phone = user.getPhone();
    }
}