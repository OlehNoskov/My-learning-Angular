package first_angular_project.persistence.repository;

import first_angular_project.persistence.entity.BaseEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractRepository <E extends BaseEntity> extends JpaRepository<E, Long>, JpaSpecificationExecutor<E> {
}