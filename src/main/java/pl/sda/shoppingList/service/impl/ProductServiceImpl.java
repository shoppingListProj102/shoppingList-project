package pl.sda.shoppingList.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.shoppingList.dto.ProductDTO;
import pl.sda.shoppingList.model.Product;
import pl.sda.shoppingList.repository.ProductListRepository;
import pl.sda.shoppingList.repository.ProductRepository;
import pl.sda.shoppingList.service.ProductService;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductListRepository productListRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductListRepository productListRepository) {
        this.productRepository = productRepository;
        this.productListRepository = productListRepository;
    }

    @Override
    public void add(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductList(productListRepository.findById(productDTO.getListId()).orElse(null));
        product.setProductName(productDTO.getName());
        product.setQuantity(productDTO.getQuantity());
        product.setUnit(productDTO.getUnit());
        productRepository.save(product);
    }

    @Override
    public void update(ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.getId()).orElse(null);
        product.setProductName(productDTO.getName());
        product.setQuantity(productDTO.getQuantity());
        product.setUnit(productDTO.getUnit());
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
