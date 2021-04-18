package com.assignment.nest.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "BIRD")
public class Bird {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "Нужно указать имя")
    @Size(max = 30, message = "Слишком длинное имя")
    private String name;

    @NotBlank(message = "Нужно указать цвет")
    @Size(max = 30, message = "Слишком длинный цвет")
    private String colour;


    private boolean canFly;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "NEST_ID", nullable = false)
    private  Nest nest;

    public Bird() {
    }

    public Bird(  String name,String colour, boolean canFly, Nest nest) {
        this.name = name;
        this.colour = colour;
        this.canFly = canFly;
        this.nest = nest;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public Nest getNest() {
        return nest;
    }

    public void setNest(Nest nest) {
        this.nest = nest;
    }
}
