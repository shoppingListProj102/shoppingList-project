package pl.sda.shoppingList.service;

import pl.sda.shoppingList.model.Product;
import pl.sda.shoppingList.model.ProductList;

import java.util.List;

public interface ProductListService {

    void add(ProductList productList);
    void update(ProductList productList);
    void remove(Integer id);
    List<ProductList> getAllLists();
    ProductList getProductListById(Integer id);

}
