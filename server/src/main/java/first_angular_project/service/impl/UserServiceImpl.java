package first_angular_project.service.impl;

import first_angular_project.persistence.crud.CrudRepositoryHelper;
import first_angular_project.persistence.entity.User;
import first_angular_project.persistence.repository.UserRepository;
import first_angular_project.service.UserService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final CrudRepositoryHelper<User, UserRepository> repositoryHelper;
    private final UserRepository userRepository;

    public UserServiceImpl(CrudRepositoryHelper<User, UserRepository> repositoryHelper,
                           UserRepository userRepository) {
        this.repositoryHelper = repositoryHelper;
        this.userRepository = userRepository;
    }

    @Override
    public void create(User entity) {
        repositoryHelper.create(userRepository, entity);
    }

    @Override
    public void update(User entity) {
        repositoryHelper.update(userRepository, entity);
    }

    @Override
    public void delete(Long id) {
        repositoryHelper.delete(userRepository, id);
    }

    @Override
    public Optional<User> findById(Long id) {
        return repositoryHelper.findById(userRepository, id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}