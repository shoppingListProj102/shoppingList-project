package pl.sda.shoppingList.service.impl;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.sda.shoppingList.model.Product;
import pl.sda.shoppingList.model.ProductList;
import pl.sda.shoppingList.repository.ProductListRepository;
import pl.sda.shoppingList.service.ProductListService;

import java.util.List;

@Service
public class ProductListServiceImpl implements ProductListService {

    private final ProductListRepository productListRepository;

    public ProductListServiceImpl(ProductListRepository productListRepository) {
        this.productListRepository = productListRepository;
    }

    @Override
    public void add(ProductList productList) {
        productListRepository.save(productList);
    }
    @Override
    public void update(ProductList productList) {
        productListRepository.save(productList);
    }

    @Override
    public void remove(Integer id) {
        productListRepository.deleteById(id);
    }

    @Override
    public List<ProductList> getAllLists() {
       return productListRepository.findAll();
    }

    @Override
    public ProductList getProductListById(Integer id) {
        return productListRepository.findById(id).orElse(null);
    }


}
