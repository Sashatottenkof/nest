package com.assignment.nest.Services;

import com.assignment.nest.Exceptions.SetOfExceptions;
import com.assignment.nest.Repositories.BirdRepository;
import com.assignment.nest.Repositories.NestRepository;
import com.assignment.nest.models.Bird;
import com.assignment.nest.models.Nest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NestService {

    @Autowired
    NestRepository nestRepository;
    @Autowired
    BirdRepository birdRepository;


    public void saveNewNest(Nest nest) {
        nestRepository.save(nest);
    }


    public void deleteNest(Integer id) {
        nestRepository.deleteById(id);
    }


    public Nest getNest(Integer id) {
        return nestRepository.findById(id)
                .orElseThrow(() -> new SetOfExceptions.NotFoundException("Такого гнезда не существует"));
    }


    public Iterable<Nest> getAllNests() {
        return nestRepository.findAll();
    }

    public Nest updateNest(Nest newNest, Integer id) {
        return nestRepository.findById(id)
                .map(nest -> {
                    nest.setName(newNest.getName());
                    nest.setAddress(newNest.getAddress());
                    return nestRepository.save(nest);
                })
                .orElseThrow(() -> new SetOfExceptions.NotFoundException("Такого гнезда не существует"));
    }


    public Iterable<Bird> getAllBirds(Integer nestId) {


        return nestRepository.findById(nestId).map(nest -> birdRepository.findByNest(nest))
                .orElseThrow(() -> new SetOfExceptions.NotFoundException("Такого гнезда не существует"));

    }
}
