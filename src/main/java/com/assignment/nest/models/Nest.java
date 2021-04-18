package com.assignment.nest.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "NEST")
public class Nest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "Нужно указать имя")
    @Size(max = 30, message = "Слишком длинное имя")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Нужно указать адресс")
    @Size(max = 30, message = "Слишком длинный адрес")
    private String address;

    public Nest() {
    }

    public Nest( String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
