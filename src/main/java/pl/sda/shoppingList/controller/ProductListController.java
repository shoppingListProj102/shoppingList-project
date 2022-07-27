package pl.sda.shoppingList.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.shoppingList.dto.ProductListDTO;
import pl.sda.shoppingList.model.ProductList;
import pl.sda.shoppingList.service.ProductListService;
import pl.sda.shoppingList.service.impl.ProductListServiceImpl;


@Slf4j
@Controller
public class ProductListController {

    private final ProductListService productListService;

    public ProductListController(ProductListServiceImpl productListService) {
        this.productListService = productListService;
    }

    @GetMapping("/list/{id}")
    public String showProductsList(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.addAttribute("productList", productListService.getProductListById(id));
        return "list-show";
    }

    @GetMapping("/list/add")
    public String addList(ModelMap modelMap) {
        modelMap.addAttribute("emptyList", new ProductListDTO());
        return "list-add";
    }

    @PostMapping("/list/add")
    public String saveNewList(@ModelAttribute("emptyList") ProductListDTO productListDTO) {
        productListService.add(productListDTO);
        log.info("Adds new list: " + productListDTO.getName());
        return "redirect:/list/all";
    }

    @GetMapping("/list/edit/{id}")
    public String editList(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.addAttribute("list", productListService.getProductListById(id));
        return "list-edit";
    }

    @PostMapping("/list/edit/{id}")
    public String updateList(@ModelAttribute("list") ProductListDTO productListDTO) {
        productListService.update(productListDTO);
        log.info("Edit list: " + productListDTO.getName());
        return "redirect:/list/all";
    }

    @GetMapping("/list/delete/{id}")
    public String deleteListById(@PathVariable Integer id) {
        productListService.remove(id);
        log.info("Deleted list by id: " + id);
        return "redirect:/list/all";
    }

    @GetMapping("/list/all")
    public String showAllLists(ModelMap modelMap) {
        modelMap.addAttribute("lists", productListService.getAllLists());
        return "list-all";
    }

}
