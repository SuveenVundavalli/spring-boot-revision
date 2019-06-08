package me.suveen.revision.services;

import me.suveen.revision.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

  Owner findByLastName(String lastName);
}
