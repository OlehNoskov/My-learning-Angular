package first_angular_project.view.controller.dto.request;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class UserRequestDto {
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private String firstname;
    private String lastname;
    private String birthday;
    private String city;
    private String phone;

    public Date getParserDateBirthday() {
        try {
            return format.parse(getBirthday());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}