package pl.sda.shoppingList.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.shoppingList.model.Product;
import pl.sda.shoppingList.model.ProductList;
import pl.sda.shoppingList.service.ProductService;

@Slf4j
@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/add")
    public String addProduct(ModelMap modelMap) {
        modelMap.addAttribute("emptyProduct", new Product());
        return "product-add";
    }

    @PostMapping("product/save")
    public String saveProduct(@ModelAttribute("emptyProduct") Product product) {
        productService.add(product);
        return "redirect/list/" + product.getProductList().getId();
    }

    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.addAttribute("product", productService.getProductById(id));
        return "product-edit";
    }

    @PostMapping("/product/update")
    public String updateProduct(@ModelAttribute("product") Product product){
        productService.update(product);
        return "redirect/list/" + product.getProductList().getId();
    }

//    @GetMapping("/product/delete/{id}")
//    public String deleteProductById(@PathVariable Integer id){
//        productService.remove(id);
//        return "redirect/list/all" + product.getProductList().getId();
//    }

}
