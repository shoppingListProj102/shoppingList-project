package pl.sda.shoppingList.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.shoppingList.dto.ProductDto;
import pl.sda.shoppingList.model.Product;
import pl.sda.shoppingList.service.ProductService;

@Slf4j
@Controller
public class ProductController {


    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products/list")
    public String showProducts(ModelMap modelMap){
        modelMap.addAttribute("products", productService.getAll());

        return "product-list";
    }



    @GetMapping("/products/create/listid={id}")
    public String showProductAddForm(@PathVariable Integer id, ModelMap modelMap){
        ProductDto productDto = new ProductDto();
        productDto.setListId(id);
        modelMap.addAttribute("emptyProduct", productDto);
        return "product-create";
    }

    @PostMapping("/products/save")
    public String addNewProduct(@ModelAttribute("emptyProduct") ProductDto productDto){
        log.info("Adds new product " + productDto.getName());


        productService.add(productDto);
        return "redirect:/shopinglists/list/" + productDto.getListId();
    }


    @GetMapping("/products/edit/{id}")
    public String showProductEditForm(@PathVariable Integer id, ModelMap modelMap){
        modelMap.addAttribute("editProduct", productService.getById(id));
        return "product-edit";
    }


    @PostMapping("/products/postedit")
    public String editProduct(@ModelAttribute("editProduct") ProductDto productDto){
        log.info("Edit product: " + productDto.getName());


        productService.update(productDto);
        return "redirect:/shopinglists/list";
    }


    @GetMapping("/products/list/{id}")
    public String showProductForId(@PathVariable Integer id, ModelMap modelMap){
        modelMap.addAttribute("product", productService.getById(id));

        log.info("Find product by id: " + id);
        return "product-details";
    }


    @GetMapping("/products/delete/{id}")
    public String deleteProductForId(@PathVariable Integer id){
        log.info("Deleted product for id: " + id);
        productService.delete(id);
        return "redirect:/shopinglists/list";
    }

}
