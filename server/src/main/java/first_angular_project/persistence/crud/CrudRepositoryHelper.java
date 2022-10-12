package first_angular_project.persistence.crud;

import first_angular_project.persistence.entity.BaseEntity;
import first_angular_project.persistence.repository.AbstractRepository;

import java.util.List;
import java.util.Optional;

public interface CrudRepositoryHelper <E extends BaseEntity, R extends AbstractRepository<E>>{
    void create(R repository, E entity);
    void update(R repository, E entity);
    void delete(R repository, Long id);
    Optional<E> findById(R repository, Long id);
    List<E> findAll(R repository);
}