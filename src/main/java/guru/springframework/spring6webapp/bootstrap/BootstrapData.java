package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  private final PublisherRepository publisherRepository;

  public BootstrapData(
      AuthorRepository authorRepository,
      BookRepository bookRepository,
      PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    Publisher packt = new Publisher();
    packt.setPublisherName("Packt Publishers");
    packt.setAddress("8564 Marilad place ");
    packt.setCity("Columbus");
    packt.setState("OH");
    packt.setZip("44567");
    Publisher packtSave = publisherRepository.save(packt);

    Author eric = new Author();
    eric.setFirstname("Eric");
    eric.setLastname("Evans");
    Book ddd = new Book();
    ddd.setTitle("Domain Driven Design");
    ddd.setIsbn("1223344");

    Author ericSave = authorRepository.save(eric);
    Book dddSave = bookRepository.save(ddd);

    Author rod = new Author();
    rod.setFirstname("Rod");
    rod.setLastname("Johnson");
    Book noEJB = new Book();
    noEJB.setTitle("Domain Driven Design");
    noEJB.setIsbn("1223344");

    Author rodSave = authorRepository.save(rod);
    Book noEJBSave = bookRepository.save(noEJB);
    ericSave.getBooks().add(dddSave);
    rodSave.getBooks().add(noEJBSave);
    authorRepository.save(ericSave);
    authorRepository.save(rodSave);
    packtSave.getAuthors().add(rodSave);
    packtSave.getAuthors().add(ericSave);
    publisherRepository.save(packtSave);
    System.out.println("In BootStraping...");
    System.out.println("Publishers Count:" + publisherRepository.count());
    System.out.println("Author Count:" + authorRepository.count());
    System.out.println("Book Count:" + bookRepository.count());
  }
}
