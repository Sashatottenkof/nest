package com.assignment.nest.Services;

import com.assignment.nest.Exceptions.SetOfExceptions;
import com.assignment.nest.Repositories.BirdRepository;
import com.assignment.nest.Repositories.NestRepository;
import com.assignment.nest.models.Bird;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BirdService {

    @Autowired
    BirdRepository birdRepository;
    @Autowired
    NestRepository nestRepository;



    public void saveNewBird(Bird bird, Integer nestId) {
        nestRepository.findById(nestId).
                map(nest -> {
                    bird.setNest(nest);
                    return birdRepository.save(bird);
                }).orElseThrow(() ->new SetOfExceptions.NotFoundException("Такого гнезда не существует"));

    }


    public Bird getBird(Integer id) {
        return birdRepository.findById(id).
                orElseThrow(() ->new SetOfExceptions.NotFoundException("Такой птицы не существует"));
    }


    public Iterable<Bird> getAllBirds() {
        return birdRepository.findAll();
    }


    public Bird updateBird(Bird newBird, Integer id) {
        return birdRepository.findById(id).
                map(bird -> {
                    bird.setName(newBird.getName());
                    bird.setColour(newBird.getColour());
                    bird.setCanFly(newBird.isCanFly());
                    return birdRepository.save(bird);
                })
                .orElseThrow(() ->new SetOfExceptions.NotFoundException("Такой птицы не существует"));
    }

    public void deleteBird(Integer id) {
        birdRepository.deleteById(id);
    }


}
