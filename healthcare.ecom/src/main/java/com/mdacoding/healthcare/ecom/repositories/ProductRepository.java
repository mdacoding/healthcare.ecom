package com.mdacoding.healthcare.ecom.repositories;

import com.mdacoding.healthcare.ecom.model.Category;
import com.mdacoding.healthcare.ecom.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findByCategoryOrderByPriceAsc(Category category);
    List<Product> findByProductNameLikeIgnoreCase(String keyword);
}
