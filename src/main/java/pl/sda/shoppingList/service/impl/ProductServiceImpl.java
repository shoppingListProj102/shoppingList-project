package pl.sda.shoppingList.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.shoppingList.model.Product;
import pl.sda.shoppingList.model.ProductList;
import pl.sda.shoppingList.repository.ProductListRepository;
import pl.sda.shoppingList.repository.ProductRepository;
import pl.sda.shoppingList.service.ProductService;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public void changeStatus(Integer id) {
        Product product = productRepository.findById(id).orElse(null);
        product.setBought(!product.isBought());
        productRepository.save(product);
    }

    @Override
    public Product getProductById(Integer id) {
       return productRepository.findById(id).orElse(null);
    }
}
