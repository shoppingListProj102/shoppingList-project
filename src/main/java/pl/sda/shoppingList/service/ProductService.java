package pl.sda.shoppingList.service;

import pl.sda.shoppingList.dto.ProductDTO;
import pl.sda.shoppingList.model.Product;
import pl.sda.shoppingList.model.ProductList;

public interface ProductService {

    void add(ProductDTO productDTO);
    void update(ProductDTO productDTO);
    void remove(Integer id);
    void changeStatus(Integer id);
    Product getProductById(Integer id);

}
