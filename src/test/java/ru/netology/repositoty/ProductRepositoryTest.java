package ru.netology.repositoty;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product book1 = new Book(1, "Алиса в стране чудес", 1000, "Л.Кэрролл");
    private Product book2 = new Book(2, "Приключения Буратино", 1000, "А.Н.Толстой");
    private Product book3 = new Book(3, "Алиса в Зазеркалье", 1000, "Л.Кэрролл");
    private Product smartphone1 = new Smartphone(4, "Galaxy", 10000, "Samsung");
    private Product smartphone2 = new Smartphone(5, "Redmi", 11000, "Xiaomi");
    private Product smartphone3 = new Smartphone(6, "Galaxy II", 10000, "Samsung");

    @BeforeEach
    public void addProducts() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    public void mustDeleteAnExistingElement() {
        Product[] expected = new Product[]{book1, book2, smartphone1, smartphone2, smartphone3};
        Product[] actual = repository.removeById(3);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowAnExceptionWhenTryingToDeleteNonExistentElement() {
        assertThrows(NotFoundException.class, () -> repository.removeById(7));
    }
}

