package hibtest.repository;

import hibtest.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdCatRepository extends JpaRepository <ProductCategory, Integer> {
}
