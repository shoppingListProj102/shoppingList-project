package pl.sda.shoppingList.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.shoppingList.dto.ProductDto;
import pl.sda.shoppingList.model.Product;
import pl.sda.shoppingList.repository.ProductRepository;
import pl.sda.shoppingList.repository.ShopingListRepository;
import pl.sda.shoppingList.service.ProductService;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    private final ShopingListRepository shopingListRepository;

    public ProductServiceImpl(ProductRepository productRepository, ShopingListRepository shopingListRepository) {
        this.productRepository = productRepository;
        this.shopingListRepository = shopingListRepository;
    }


    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void add(ProductDto productDto) {
        Product product = new Product();
        product.setShopingList(shopingListRepository.findById(productDto.getListId()).orElse(null));
        product.setName(productDto.getName());
        product.setQuantity(productDto.getQuantity());
        product.setDescription(productDto.getDescription());
        product.setUnit(productDto.getUnit());
        productRepository.save(product);
    }

    @Override
    public Product getById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void update(ProductDto productDto) {
        Product product =productRepository.findById(productDto.getId()).orElse(null);
        product.setName(productDto.getName());
        product.setQuantity(productDto.getQuantity());
        product.setDescription(productDto.getDescription());
        product.setUnit(productDto.getUnit());
        productRepository.save(product);
    }


    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }


    @Override
    public void changeStatus(Integer id) {
        Product product = productRepository.findById(id).orElse(null);
        product.setBought(!product.isBought());
        productRepository.save(product);
    }
}
