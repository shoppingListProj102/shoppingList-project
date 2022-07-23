package pl.sda.shoppingList.service;

import pl.sda.shoppingList.dto.ShopingListDto;
import pl.sda.shoppingList.model.ShopingList;

import java.util.List;

public interface ShopingListService {


    List<ShopingList> getAll();

    void add(ShopingList shopingList);

    ShopingList getById (Integer id);

    void update(ShopingList shopingList);

    void delete(Integer id);





    Integer addShopingList(ShopingListDto shopingListDto);





}
