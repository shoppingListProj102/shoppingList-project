package pl.sda.shoppingList.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.shoppingList.dto.ShopingListDto;
import pl.sda.shoppingList.model.ShopingList;
import pl.sda.shoppingList.repository.ShopingListRepository;
import pl.sda.shoppingList.service.ShopingListService;

import java.util.List;


@Service
public class ShopingServiceImpl implements ShopingListService {


    private final ShopingListRepository shopingListRepository;


    public ShopingServiceImpl(ShopingListRepository shopingListRepository) {
        this.shopingListRepository = shopingListRepository;
    }

    @Override
    public List<ShopingList> getAll() {
        return shopingListRepository.findAll();
    }

    @Override
    public void add(ShopingList shopingList) {
        shopingListRepository.save(shopingList);
    }

    @Override
    public ShopingList getById(Integer id) {
        return shopingListRepository.findById(id).orElse(null);
    }

    @Override
    public void update(ShopingList shopingList) {
        shopingListRepository.save(shopingList);
    }

    @Override
    public void delete(Integer id) {
        shopingListRepository.deleteById(id);
    }





    @Override
    public Integer addShopingList(ShopingListDto shopingListDto) {
        return shopingListRepository.save(shopingListDto.toShopingList()).getId();
    }
}
