package com.ideas2it.ems.project.dao;

import com.ideas2it.ems.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * ProjectRepository is a DAO interface that extends the CrudRepository.
 * It provides CRUD operations and additional queries for Project entities.
 * </p>
 */
@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {
}
