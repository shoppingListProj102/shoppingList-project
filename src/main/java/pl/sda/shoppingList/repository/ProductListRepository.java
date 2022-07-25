package pl.sda.shoppingList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.shoppingList.model.ProductList;

public interface ProductListRepository extends JpaRepository<ProductList, Integer> {
}
