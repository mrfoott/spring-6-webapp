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

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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
        author2.setFirstName("Dun");
        author2.setLastName("no");

        Book book2 = new Book();
        book2.setTitle("Introduce to DepOps");
        book2.setIsbn("001122");

        Author author2Saved = authorRepository.save(author2);
        Book book2Saved = bookRepository.save(book2);

        author1Saved.getBooks().add(book1Saved);
        author2Saved.getBooks().add(book2Saved);
        book1Saved.getAuthors().add(author1Saved);
        book2Saved.getAuthors().add(author2Saved);


        Publisher publisher = new Publisher();
        publisher.setPublisherName("First publisher");
        publisher.setCity("Ho Chi Minh");
        Publisher savedPublisher = publisherRepository.save(publisher);

        book1Saved.setPublisher(savedPublisher);
        book2Saved.setPublisher(savedPublisher);

        authorRepository.save(author1Saved);
        authorRepository.save(author2Saved);
        bookRepository.save(book1Saved);
        bookRepository.save(book2Saved);

        System.out.println("Bootstrap");
        System.out.println("Total authors: " + authorRepository.count());
        System.out.println("Total books: " + bookRepository.count());



        System.out.println("Total publisher: " + publisherRepository.count());
    }
}
