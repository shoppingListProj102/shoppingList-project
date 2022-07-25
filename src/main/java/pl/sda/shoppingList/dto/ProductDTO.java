package pl.sda.shoppingList.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private Integer id;
    private String productName;
    private String unit;
    private double quantity;



}
