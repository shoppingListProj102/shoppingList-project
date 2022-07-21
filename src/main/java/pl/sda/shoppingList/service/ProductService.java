package pl.sda.shoppingList.service;

import pl.sda.shoppingList.model.Product;

import java.util.List;

public interface ProductService {


    List<Product> getAll();

    void add(Product product);

    Product getById (Integer id);

    void update(Product product);

    void delete(Integer id);


}
