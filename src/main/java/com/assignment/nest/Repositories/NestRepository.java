package com.assignment.nest.Repositories;

import com.assignment.nest.models.Nest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestRepository extends CrudRepository<Nest, Integer> {
}
