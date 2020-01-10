package hibernatetest.repository;

import hibernatetest.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdCatRepository extends JpaRepository <ProductCategory, Integer> {
}
