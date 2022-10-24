//package first_angular_project.persistence.crud.impl;
//
//import first_angular_project.persistence.crud.CrudRepositoryHelper;
//import first_angular_project.persistence.entity.BaseEntity;
//import first_angular_project.persistence.repository.AbstractRepository;
//
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CrudRepositoryHelperImpl<
//        E extends BaseEntity,
//        R extends AbstractRepository<E>>
//        implements CrudRepositoryHelper<E, R> {
//
//    @Override
//    public void create(R repository, E entity) {
//        repository.save(entity);
//    }
//
//    @Override
//    public void update(R repository, E entity) {
//        checkExist(repository, entity.getId());
//        repository.save(entity);
//    }
//
//    @Override
//    public void delete(R repository, Long id) {
//        checkExist(repository, id);
//        repository.deleteById(id);
//    }
//
//    @Override
//    public Optional<E> findById(R repository, Long id) {
//        return repository.findById(id);
//    }
//
//    @Override
//    public List<E> findAll(R repository) {
//        return repository.findAll();
//    }
//
//
//    private void checkExist(R repository, Long id) {
//        if (!repository.existsById(id)) {
//            throw new RuntimeException("entity not found");
//        }
//    }
//}