package pl.sda.shoppingList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.shoppingList.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
