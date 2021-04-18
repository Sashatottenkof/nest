package com.assignment.nest.controllers;

import com.assignment.nest.Services.NestService;
import com.assignment.nest.models.Bird;
import com.assignment.nest.models.Nest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("nest")
public class NestController {
    @Autowired
    NestService nestService;

    /**
     * добавить новое гнездо
     * @param nest
     */
    @PostMapping("/add")
    public void addNest(@RequestBody @Valid Nest nest ){
        nestService.saveNewNest(nest);
    }

    /**
     * все доступные гнезда
     * @return
     */
    @GetMapping("/all")
    public Iterable<Nest> getAllNests(){
       return nestService.getAllNests();
    }
    /**
     * найти гнездо по id
     * @param nestId
     * @return
     */
    @GetMapping("/{nestId}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Nest getNest(@PathVariable Integer nestId){
        return  nestService.getNest(nestId);
    }

    /**
     * редактировать гнездо
     * @param nest
     * @param nestId
     * @return
     */

    @PutMapping("/{nestId}")
    public Nest updateNest(@RequestBody @Valid Nest nest, @PathVariable Integer nestId) {

        return nestService.updateNest(nest, nestId);
    }

    /**
     * удалить гнездо
     * @param nestId
     */
    @DeleteMapping("/{nestId}")
    public void deleteNest(@PathVariable Integer nestId){
        nestService.deleteNest(nestId);
    }
    /**
     * оказать всех птиц в этом гнезде
     * @param nestId
     */

    @GetMapping("/allBirds/{nestId}")
    public Iterable<Bird> getAllBirdsByNest(@PathVariable Integer nestId){
        return nestService.getAllBirds(nestId);
    }
}
