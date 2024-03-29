package pl.sda.shoppingList.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.shoppingList.dto.ProductDTO;
import pl.sda.shoppingList.service.ProductService;

@Slf4j
@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list/{id}/product")
    public String addProduct(@PathVariable Integer id, ModelMap modelMap) {
        ProductDTO productDTO = new ProductDTO();
        modelMap.addAttribute("listId", id);
        modelMap.addAttribute("emptyProduct", productDTO);
        return "product-add";
    }

    @PostMapping("/list/{id}/product")
    public String saveProduct(@PathVariable Integer id, @ModelAttribute("emptyProduct") ProductDTO productDTO) {
        productService.addProduct(productDTO, id);
        log.info("Adds new product " + productDTO.getProductName() + " to the list of id: " + id);
        return "redirect:/list/" + id;
    }

    @GetMapping("/list/{listId}/product/{id}/edit")
    public String editProduct(@PathVariable Integer listId, @PathVariable Integer id, ModelMap modelMap) {
        modelMap.addAttribute("product", productService.getProductById(id));
        modelMap.addAttribute("listId", listId);
        return "product-edit";
    }

    @PostMapping("/list/{listId}/product/{id}/edit")
    public String updateProduct(@PathVariable Integer listId, @PathVariable Integer id, @ModelAttribute("product") ProductDTO productDTO) {
        productService.updateProduct(productDTO);
        log.info("Edit product " + productDTO.getProductName() + " to the list of id: " + id);
        return "redirect:/list/" + listId;
    }

    @GetMapping("/list/{listId}/product/{id}/incart")
    public String changeProductStatus(@PathVariable Integer listId, @PathVariable Integer id) {
        productService.changeProductBoughtStatus(id);
        log.info("Changed status product: " + productService.getProductById(id).getProductName() + " of id " + id);
        return "redirect:/list/" + listId;
    }

    @GetMapping("/list/{listId}/product/{id}/delete")
    public String deleteProduct(@PathVariable Integer listId, @PathVariable Integer id) {
        log.info("Deleted product: " + productService.getProductById(id).getProductName() + " of id: " + id);
        productService.removeProduct(id);
        return "redirect:/list/" + listId;

    }
}
