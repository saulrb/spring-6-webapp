package guru.springframework.spring6webapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String firstname;
  private String lastname;

  @ManyToMany(mappedBy = "authors")
  private Set<Book> books = new HashSet<>();

  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  @Override
  public String toString() {
    return "Author{"
        + "id="
        + id
        + ", firstname='"
        + firstname
        + '\''
        + ", lastname='"
        + lastname
        + '\''
        + ", books="
        + books
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Author author)) return false;

    if (!Objects.equals(id, author.id)) return false;
    if (!Objects.equals(firstname, author.firstname)) return false;
    if (!Objects.equals(lastname, author.lastname)) return false;
    return Objects.equals(books, author.books);
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (books != null ? books.hashCode() : 0);
    return result;
  }
}
