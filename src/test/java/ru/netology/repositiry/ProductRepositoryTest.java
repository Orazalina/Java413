package ru.netology.repositiry;

import org.junit.jupiter.api.Test;
import ru.netology.damain.Book;
import ru.netology.damain.NotFoundException;
import ru.netology.damain.Product;
import ru.netology.damain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book book1 = new Book(1, "B1", 1000, "B2", 100, 2000);
    private Book book2 = new Book(2, "B3", 2000, "B2", 200, 2010);
    private TShirt tShirt1 = new TShirt(3, "T1", 500, "Red", "XS");
    private TShirt tShirt2 = new TShirt(4, "T2", 800, "Red", "M");

    public void setUp() {
        repository.save(book1);
        repository.save(book2);
        repository.save(tShirt1);
        repository.save(tShirt2);
    }

    @Test
    void removeById() {
        setUp();
        Product[] expected = new Product[]{book1, book2, tShirt2};
        repository.removeById(3);
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    void removeNonExistedId() {
        assertThrows(NotFoundException.class, () -> repository.removeById(7));
    }

}