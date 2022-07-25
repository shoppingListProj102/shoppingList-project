package pl.sda.shoppingList.service;

import pl.sda.shoppingList.dto.ProductDTO;
import pl.sda.shoppingList.model.Product;

public interface ProductService {

    void addProduct(ProductDTO productDTO, Integer id);
    void updateProduct(ProductDTO productDTO);
    void removeProduct(Integer id);
    void changeProductBoughtStatus(Integer id);
    Product getProductById(Integer id);

}
