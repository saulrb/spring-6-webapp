package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  @Override
  public void run(String... args) throws Exception {
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
    System.out.println("In Bootstraping");
    System.out.println("Author Count:" + authorRepository.count());
    System.out.println("Book Count:" + bookRepository.count());
  }
}
