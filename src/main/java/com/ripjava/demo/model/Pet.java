package com.ripjava.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
public class Pet {
    @Id
    private long id;
    private String name;
    private int age;
    private String planId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return id == pet.id &&
                age == pet.age &&
                name.equals(pet.name) &&
                planId.equals(pet.planId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, planId);
    }
}
