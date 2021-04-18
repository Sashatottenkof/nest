package com.assignment.nest.controllers;

import com.assignment.nest.Services.BirdService;
import com.assignment.nest.models.Bird;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("bird")
public class BirdController {

    @Autowired
    BirdService birdService;

    /**
     * сохранить новую птицу
     *
     * @param bird
     */
    @PostMapping("/add/{nestId}")
    public void addBird(@RequestBody @Valid Bird bird,@PathVariable Integer nestId){
        birdService.saveNewBird(bird,nestId);
    }

    /**
     * возвращает всех доступных птиц
     *
     * @param
     * @return
     */
    @GetMapping("/all")
    public Iterable<Bird> getAllBirds(){
        return birdService.getAllBirds();
    }

    /**
     * возвращает конкретную птицу
     *
     * @param birdId
     * @return
     */
    @GetMapping("/{birdId}")
    public Bird getNest(@PathVariable Integer birdId){
        return  birdService.getBird(birdId);
    }

    /**
     * редактировать птицу
     * @param birdId
     * @return
     */
    @PutMapping("/{birdId}")
    public Bird updateBird(@RequestBody @Valid Bird bird, @PathVariable Integer birdId) {

        return birdService.updateBird(bird, birdId);
    }

    /**
     * удалить птицу
     * @param birdId
     */
    @DeleteMapping("/{birdId}")
    public void deleteNest(@PathVariable Integer birdId){
        birdService.deleteBird(birdId);
    }
}
