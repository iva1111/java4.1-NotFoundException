package ru.netology.repository;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;

public class ProductRepository {
    private Product[] items = new Product[0];
    private ProductRepository repository;

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Product[] removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("id удаление несуществующего объекта: " + id);
        }
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
        return tmp;
    }

}
