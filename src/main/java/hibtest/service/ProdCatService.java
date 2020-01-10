package hibtest.service;

import hibtest.model.ProductCategory;
import hibtest.repository.ProdCatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProdCatService {
    @Autowired
    ProdCatRepository prodCatRepository;

    public ProductCategory addProdCat(ProductCategory productCategory){
        return prodCatRepository.save(productCategory);
    }

    public ProductCategory getProdCat(int id){
        return prodCatRepository.getOne(id);
    }

    public void deleteProdCat(ProductCategory productCategory){
        prodCatRepository.delete(productCategory);
    }
}
