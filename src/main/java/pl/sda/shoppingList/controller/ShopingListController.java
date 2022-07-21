package pl.sda.shoppingList.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.shoppingList.model.ShopingList;
import pl.sda.shoppingList.service.ShopingListService;

@Slf4j
@Controller
public class ShopingListController {

    @Autowired
    private final ShopingListService shopingListService;

    public ShopingListController(ShopingListService shopingListService) {
        this.shopingListService = shopingListService;
    }


    @GetMapping("/shopinglists/list")
    public String showShopingList(ModelMap modelMap){
        modelMap.addAttribute("slist", shopingListService.getAll());

        return "shopingl-list";
    }


    @GetMapping("/shopinglists/create")
    public String showShopingListAddForm(ModelMap modelMap){
        modelMap.addAttribute("emptyList", new ShopingList());
        return "shopingl-create";
    }

    @PostMapping("/shopinglists/save")
    public String addNewShopingList(@ModelAttribute("emptyList") ShopingList shopingList){
        log.info("Adds new shopinglist " + shopingList);


        shopingListService.add(shopingList);
        return "redirect:/shopinglists/list";
    }

    @GetMapping("/shopinglists/edit/{id}")
    public String showShopingListEditForm(@PathVariable Integer id, ModelMap modelMap){
        modelMap.addAttribute("editList", shopingListService.getById(id));
        return "shopingl-edit";
    }


    @PostMapping("/shopinglists/postedit")
    public String editShopingList(@ModelAttribute("editList") ShopingList shopingList){
        log.info("Edit shopinglist: " + shopingList);


        shopingListService.update(shopingList);
        return "redirect:/shopinglists/list";
    }

    @GetMapping("/shopinglists/list/{id}")
    public String showShopingListForId(@PathVariable Integer id, ModelMap modelMap){
        modelMap.addAttribute("shopinglist", shopingListService.getById(id));

        log.info("Find shopinglist by id: " + id);
        return "shopingl-details";
    }


    @GetMapping("/shopinglists/delete/{id}")
    public String deleteShopingListForId(@PathVariable Integer id){
        log.info("Deleted shopinglist for id: " + id);
        shopingListService.delete(id);
        return "redirect:/shopinglists/list";
    }

}
