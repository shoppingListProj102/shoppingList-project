package pl.sda.shoppingList.service;

import pl.sda.shoppingList.model.Product;
import pl.sda.shoppingList.model.ProductList;

public interface ProductService {

    void add(Product product);
    void update(Product product);
    void remove(Integer id);
    void changeStatus(Integer id);
    Product getProductById(Integer id);

}
