package com.mdacoding.healthcare.ecom.service;

import com.mdacoding.healthcare.ecom.exceptions.APIException;
import com.mdacoding.healthcare.ecom.exceptions.ResourceNotFoundException;
import com.mdacoding.healthcare.ecom.model.Category;
import com.mdacoding.healthcare.ecom.payload.CategoryDTO;
import com.mdacoding.healthcare.ecom.payload.CategoryResponse;
import com.mdacoding.healthcare.ecom.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private Long nextId = 1L;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;


        @Override
        public CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
            Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
                    ? Sort.by(sortBy).ascending()
                    : Sort.by(sortBy).descending();
            Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);
            Page<Category> pageCategory = categoryRepository.findAll(pageDetails);
            List<Category> categories = pageCategory.getContent();
            if(categories.isEmpty())
                throw new APIException("Category with that name was not found!");
            List<CategoryDTO> categoryDTOS = categories.stream()
                    .map(category -> modelMapper.map(category, CategoryDTO.class))
                    .toList();

            CategoryResponse categoryResponse = new CategoryResponse();
            categoryResponse.setContent(categoryDTOS);
            categoryResponse.setPageNumber(pageCategory.getNumber());
            categoryResponse.setPageSize(pageCategory.getSize());
            categoryResponse.setTotalElements(pageCategory.getTotalElements());
            categoryResponse.setTotalPages(pageCategory.getTotalPages());
            categoryResponse.setLastPage(pageCategory.isLast());
            return categoryResponse;
   }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        Category categoryFromDB = categoryRepository.findByCategoryName(category.getCategoryName());
        if(categoryFromDB != null)
            throw new APIException("Category with that name " + category.getCategoryName() + " already exist!");
        category.setCategoryId(nextId++);
        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category","categoryId",categoryId));

        categoryRepository.delete(category);
        return modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId) {
        Category savedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category","categoryId",categoryId));
        Category category = modelMapper.map(categoryDTO, Category.class);
        category.setCategoryId(categoryId);
        Category updatedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDTO.class);
    }
}
