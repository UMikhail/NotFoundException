package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(1, "Война и мир", 1000, "Л.Н.Толстой");
    Book book2 = new Book(2, "Мастер и Маргарита", 500, "М.А.Булгаков");

    Smartphone smartphone1 = new Smartphone(11, "Xiaomi", 10000, "Xiaomi Corporation");
    Smartphone smartphone2 = new Smartphone(22, "Vivo", 15000, "Vivo Communication Technology Co. Ltd.");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    public void testAddProduct() {
        Product[] expected = {smartphone2, smartphone1, book2, book1, book1};
        Product[] actual = manager.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchNameProduct() {

        Product[] expected = {book1, book1};
        Product[] actual = manager.searchBy("Война и мир");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchNameProductTwo() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Неизвестный");

        Assertions.assertArrayEquals(expected, actual);
    }

    //проверка соответствия товара поиску
    @Test
    public void testMatchingSearch() {

        boolean expected = true;
        boolean actual = manager.matches(book2, "Мастер и Маргарита");

        Assertions.assertEquals(expected, actual);

    }
}