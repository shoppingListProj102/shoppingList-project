package pl.sda.shoppingList.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.shoppingList.model.Product;
import pl.sda.shoppingList.model.ShopingList;
import pl.sda.shoppingList.repository.ProductRepository;
import pl.sda.shoppingList.service.ProductService;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }


    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

}
