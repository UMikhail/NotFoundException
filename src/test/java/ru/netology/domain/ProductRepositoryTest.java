package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

public class ProductRepositoryTest {

    Book book1 = new Book(1, "Война и мир", 1000, "Л.Н.Толстой");
    Book book2 = new Book(2, "Мастер и Маргарита", 500, "М.А.Булгаков");

    Smartphone smartphone1 = new Smartphone(11, "Xiaomi", 10000, "Xiaomi Corporation");
    Smartphone smartphone2 = new Smartphone(22, "Vivo", 15000, "Vivo Communication Technology Co. Ltd.");


    @Test
    public void testRemoveBiId() {
        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.removeBiId(2);

        Product[] expected = {book1, smartphone1};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveBiIdNFE() {
        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeBiId(100);
        });
    }

    @Test
    public void testAdd() {
        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }
}
