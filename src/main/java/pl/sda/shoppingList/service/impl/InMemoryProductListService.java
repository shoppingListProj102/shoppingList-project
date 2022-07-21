//package pl.sda.shoppingList.service.impl;
//
//import org.springframework.stereotype.Service;
//import pl.sda.shoppingList.model.Product;
//import pl.sda.shoppingList.model.ProductList;
////import pl.sda.shoppingList.repository.ProductListRepository;
//import pl.sda.shoppingList.service.ProductListService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class InMemoryProductListService implements ProductListService {
//
//    private List<ProductList> productLists = new ArrayList<>();
//    private List<Product> products;
//
//
//    public InMemoryProductListService() {
//        products = new ArrayList<>();
//        products.add(new Product( 1,"maslo","sztuka",2.0,false));
//        products.add(new Product( 2,"chleb","sztuka",1.0,true));
//        productLists.add(new ProductList(1,"Lidl",products));
//    }
//
//    @Override
//    public void add(ProductList productList) {
////        productListRepository.save(productList);
//        productLists.add(productList);
//    }
//    @Override
//    public void update(ProductList productList) {
////        productListRepository.save(productList);
//        productLists.set(productList.getId(), productList);
//    }
//
//    @Override
//    public void remove(Integer id) {
////        productListRepository.deleteById(id);
//        productLists.remove(id);
//    }
//
//    @Override
//    public List<ProductList> getAllLists() {
////        return productListRepository.findAll();
//        return productLists;
//    }
//
//    @Override
//    public ProductList getProductListById(Integer id) {
//        return productLists.get(id);
//    }
//}
