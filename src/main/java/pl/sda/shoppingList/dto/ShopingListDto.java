package pl.sda.shoppingList.dto;

import lombok.Getter;
import lombok.Setter;
import pl.sda.shoppingList.model.ShopingList;

import java.io.Serializable;


@Getter
@Setter
public class ShopingListDto implements Serializable {

    private Integer id;

    private String nameList;


    public ShopingListDto() {
    }

    public ShopingListDto(String nameList) {
        this.nameList = nameList;
    }

    public ShopingList toShopingList(){
        return toShopingList(new ShopingList());
    }

    public ShopingList toShopingList(ShopingList shopingList) {
        shopingList.setNameList(this.nameList);
        return shopingList;
    }



}
