package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductManager {
    private Product[] items = new Product[0];

    public ProductManager() {
    }

    public void add(Product item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] getAll() {
        int numberOfItemsToGet = items.length;
        Product[] result = new Product[numberOfItemsToGet];
        System.arraycopy(items, 0, result, 0, items.length);
        return result;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : getAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }

        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (smartphone.getManufacturer().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
