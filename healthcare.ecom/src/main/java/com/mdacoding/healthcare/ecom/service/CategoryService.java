package com.mdacoding.healthcare.ecom.service;

import com.mdacoding.healthcare.ecom.payload.CategoryDTO;
import com.mdacoding.healthcare.ecom.payload.CategoryResponse;


public interface CategoryService {

    CategoryResponse getAllCategories(Integer pageNumber,Integer pageSize,String sortBy,String sortOrder);
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO deleteCategory(Long categoryId);
    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
