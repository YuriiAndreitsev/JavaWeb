package hibernatetest.service;

import hibernatetest.model.ProductCategory;
import hibernatetest.repository.ProdCatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


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
