package pl.sda.shoppingList.dto;

import lombok.Getter;
import lombok.Setter;
import pl.sda.shoppingList.model.Product;

@Getter
@Setter
public class ProductDTO {

    private Integer id;
    private Integer listId;
    private String name;
    private String unit;
    private double quantity;



}
