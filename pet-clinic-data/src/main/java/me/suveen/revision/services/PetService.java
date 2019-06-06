package me.suveen.revision.services;

import me.suveen.revision.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet findByLastName(String lastName);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
