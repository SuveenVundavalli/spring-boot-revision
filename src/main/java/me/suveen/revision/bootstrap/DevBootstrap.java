package me.suveen.revision.bootstrap;

import me.suveen.revision.model.Author;
import me.suveen.revision.model.Book;
import me.suveen.revision.model.Publisher;
import me.suveen.revision.repositories.AuthorRepository;
import me.suveen.revision.repositories.BookRepository;
import me.suveen.revision.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;
  private PublisherRepository publisherRepository;

  public DevBootstrap(
      AuthorRepository authorRepository,
      BookRepository bookRepository,
      PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    initData();
  }

  private void initData() {

    Publisher harperCollins = new Publisher("Harper Collins", "Harper Corp, Central Street, SA");
    publisherRepository.save(harperCollins);

    Publisher worx = new Publisher("Worx", "Worx Corp, Walk Street, NA");
    publisherRepository.save(worx);

    // Eric
    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Development", "1234", harperCollins);

    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    authorRepository.save(eric);
    bookRepository.save(ddd);

    // Rod
    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "23444", worx);

    rod.getBooks().add(noEJB);
    noEJB.getAuthors().add(rod);

    authorRepository.save(rod);
    bookRepository.save(noEJB);
  }
}
