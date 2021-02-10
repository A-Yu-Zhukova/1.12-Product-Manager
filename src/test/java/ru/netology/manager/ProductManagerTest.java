package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private ProductManager manager = new ProductManager();

    private Book book1 = new Book(1, "Book1", 10, "Ivan");
    private Book book2 = new Book(2, "Book2", 11, "Ivan");
    private Book book3 = new Book(3, "Product", 12, "Fedor");

    private Smartphone smartphone1 = new Smartphone(1, "smartphone1", 110, "Samsung");
    private Smartphone smartphone2 = new Smartphone(2, "smartphone2", 111, "Samsung");
    private Smartphone smartphone3 = new Smartphone(3, "Product", 112, "Apple");

    @Test
    public void setUpThreeBooks() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{book1, book2, book3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void setUpThreeSmartphones() {
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{smartphone1, smartphone2, smartphone3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void setUpThreeBooksAndSmartphones() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{book1, book2, book3, smartphone1, smartphone2, smartphone3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBookByName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("Book2");
        Product[] expected = new Product[]{book2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBookByAuthor() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("Ivan");
        Product[] expected = new Product[]{book1, book2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSmartphoneByName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("Smartphone2");
        Product[] expected = new Product[]{smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSmartphoneByManufacturer() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{smartphone1, smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBothProductByName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("Product");
        Product[] expected = new Product[]{book3, smartphone3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBadProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("NoProduct");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }
}
