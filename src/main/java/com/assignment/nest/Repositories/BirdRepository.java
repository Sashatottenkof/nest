package com.assignment.nest.Repositories;


import com.assignment.nest.models.Bird;
import com.assignment.nest.models.Nest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BirdRepository extends CrudRepository<Bird, Integer> {
    public Iterable<Bird> findByNest(Nest nest);
}
