package pl.sda.shoppingList.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.shoppingList.dto.ProductDTO;
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

    @GetMapping("/product/add/listid={id}")
    public String addProduct(@PathVariable Integer id, ModelMap modelMap) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setListId(id);
        modelMap.addAttribute("emptyProduct", productDTO);

        return "product-add";
    }

    @PostMapping("/list/product/save")
    public String saveProduct(@ModelAttribute("emptyProduct") ProductDTO productDTO) {
        productService.add(productDTO);
        return "redirect:/list/" + productDTO.getListId();
    }

    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.addAttribute("product", productService.getProductById(id));
        return "product-edit";
    }

    @PostMapping("/product/update")
    public String updateProduct(@ModelAttribute("product") ProductDTO productDTO){
        productService.update(productDTO);
        return "redirect/list/" + productDTO.getListId();
    }

//    @GetMapping("/product/delete/{id}")
//    public String deleteProductById(@PathVariable Integer id){
//        productService.remove(id);
//        return "redirect/list/all" + product.getProductList().getId();
//    }

}
