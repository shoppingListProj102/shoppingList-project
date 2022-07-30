package pl.sda.shoppingList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.shoppingList.service.ProductListService;

@Controller
public class IndexController {

    private final ProductListService productListService;


    public IndexController(ProductListService productListService) {
        this.productListService = productListService;
    }


    @GetMapping("/")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("lists", productListService.getAllLists());
        return "index";
    }


}