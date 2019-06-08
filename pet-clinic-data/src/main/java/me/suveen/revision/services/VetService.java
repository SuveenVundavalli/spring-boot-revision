package me.suveen.revision.services;

import me.suveen.revision.model.Vet;

public interface VetService extends CrudService<Vet, Long> {
  Vet findByLastName(String lastName);
}
