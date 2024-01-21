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
public class Publisher {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String publisherName;

  private String address;

  private String city;

  private String state;

  private String zip;

  @ManyToMany(mappedBy = "publishers")
  private Set<Author> authors = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPublisherName() {
    return publisherName;
  }

  public void setPublisherName(String publisherName) {
    this.publisherName = publisherName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public Set<Author> getAuthors() {
    return authors;
  }

  public void setAuthors(Set<Author> authors) {
    this.authors = authors;
  }

  @Override
  public String toString() {
    return "Publisher{"
        + "id="
        + id
        + ", publisherName='"
        + publisherName
        + '\''
        + ", address='"
        + address
        + '\''
        + ", city='"
        + city
        + '\''
        + ", state='"
        + state
        + '\''
        + ", zip='"
        + zip
        + '\''
        + ", authors="
        + authors
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Publisher publisher)) return false;

    if (!id.equals(publisher.id)) return false;
    if (!publisherName.equals(publisher.publisherName)) return false;
    if (!address.equals(publisher.address)) return false;
    if (!city.equals(publisher.city)) return false;
    if (!state.equals(publisher.state)) return false;
    if (!zip.equals(publisher.zip)) return false;
    return Objects.equals(authors, publisher.authors);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + publisherName.hashCode();
    result = 31 * result + address.hashCode();
    result = 31 * result + city.hashCode();
    result = 31 * result + state.hashCode();
    result = 31 * result + zip.hashCode();
    result = 31 * result + (authors != null ? authors.hashCode() : 0);
    return result;
  }
}
