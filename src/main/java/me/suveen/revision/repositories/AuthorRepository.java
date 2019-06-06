package me.suveen.revision.repositories;

import me.suveen.revision.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
