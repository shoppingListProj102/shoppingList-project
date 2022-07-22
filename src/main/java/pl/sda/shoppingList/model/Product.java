package pl.sda.shoppingList.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer quantity;

    private String unit;

    private String description;

    private boolean isBought;


    @ManyToOne
    @JoinColumn
    private ShopingList shopingList;


}
