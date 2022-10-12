package first_angular_project.persistence.repository;

import first_angular_project.persistence.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends AbstractRepository<User> {
}