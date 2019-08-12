package com.ripjava.demo.dao;

import com.ripjava.demo.model.Pet;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.Optional;

import static com.ripjava.demo.dao.PetRepository.PetSpecification.planIdEquals;

@Repository
public interface PetRepository extends JpaRepositoryImplementation<Pet, Long> {

    default Pet findPetName(String planId){
        return findOne(Specifications.where(planIdEquals(planId))).get();
    }
    interface  PetSpecification{
        static Specification<Pet> planIdEquals(String planId){
            return StringUtils.isEmpty(planId) ? null :
                    (root, query, builder) -> builder.equal(root.get("planId"), planId);
        }
    }
}
