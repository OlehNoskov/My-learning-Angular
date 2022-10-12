package first_angular_project.service;

import first_angular_project.persistence.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseService <ENTITY extends BaseEntity>{
    void create(ENTITY entity);
    void update(ENTITY entity);
    void delete(Long id);
    Optional<ENTITY> findById(Long id);
    List<ENTITY> findAll();
}