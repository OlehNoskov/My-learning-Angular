package first_angular_project.persistence.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
public class User {
    @Id
    private long id;
    private String firstname;
    private String lastname;
    private Date birthday;
    private String city;
    private String phone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(firstname, user.firstname) && Objects.equals(lastname, user.lastname) && Objects.equals(birthday, user.birthday) && Objects.equals(city, user.city) && Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, birthday, city, phone);
    }
}