package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.repositories.AuthorRepository;
import guru.springframework.spring6webapp.domain.repositories.BookRepository;
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
        Author author1 = new Author();

        author1.setFirstName("Mr");
        author1.setLastName("Foot");

        Book book1 = new Book();
        book1.setTitle("Introduce to Spring Boot");
        book1.setIsbn("123456");

        Author author1Saved = authorRepository.save(author1);
        Book book1Saved = bookRepository.save(book1);

        Author author2 = new Author();

        author1.setFirstName("Dun");
        author1.setLastName("no");

        Book book2 = new Book();
        book1.setTitle("Introduce to DepOps");
        book1.setIsbn("001122");

        Author author2Saved = authorRepository.save(author2);
        Book book2Saved = bookRepository.save(book2);

        author1Saved.getBooks().add(book1);
        author2Saved.getBooks().add(book2);

        authorRepository.save(author1Saved);
        authorRepository.save(author2Saved);

        System.out.println("Bootstrap");
        System.out.println("Total authors: " + authorRepository.count());
        System.out.println("Total books: " + bookRepository.count());
    }
}
