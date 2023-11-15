package guru.springframework.spring6webapp;

import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class Spring6WebappApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring6WebappApplication.class, args);
    }

    @Entity
    public static class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String title, isbn;

        @ManyToMany
        @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
        private Set<Author> authors;
        public Set<Author> getAuthors() {
            return authors;
        }

        public void setAuthors(Set<Author> authors) {
            this.authors = authors;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }
    }

    @Entity
    public static class Author {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String firstName, lastName;

        @ManyToMany (mappedBy = "authors")
        private Set<Book> books;

        public Set<Book> getBooks() {
            return books;
        }

        public void setBooks(Set<Book> books) {
            this.books = books;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
}
