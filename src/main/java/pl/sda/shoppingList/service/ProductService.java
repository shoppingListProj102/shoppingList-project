package pl.sda.shoppingList.service;

import pl.sda.shoppingList.dto.ProductDto;
import pl.sda.shoppingList.model.Product;
import pl.sda.shoppingList.model.ShopingList;

import java.util.List;

public interface ProductService {


    List<Product> getAll();

    void add(ProductDto productDto);

    Product getById (Integer id);

    void update(ProductDto productDto);

    void delete(Integer id);

    void changeStatus(Integer id);


}
