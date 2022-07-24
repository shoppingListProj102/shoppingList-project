package pl.sda.shoppingList.dto;

import lombok.Getter;
import lombok.Setter;
import pl.sda.shoppingList.model.Product;

import java.io.Serializable;


@Getter
@Setter
public class ProductDto {

    private Integer id;

    private int listId;

    private String name;

    private Integer quantity;

    private String unit;

    private String description;


//    public ProductDto() {
//    }
//
//    public ProductDto(int listId, String name) {
//        this.listId = listId;
//        this.name = name;
//    }
//
//    public Product toProduct(){
//        return toProduct(new Product());
//    }
//
//    public Product toProduct(Product product){
//        product.setName(this.name);
//        product.setDescription(this.description);
//        return product;
//    }

}
