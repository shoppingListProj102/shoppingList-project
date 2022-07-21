package pl.sda.shoppingList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.shoppingList.model.ShopingList;

public interface ShopingListRepository extends JpaRepository<ShopingList, Integer> {


}
