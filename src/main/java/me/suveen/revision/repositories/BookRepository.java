package me.suveen.revision.repositories;

import me.suveen.revision.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {}
