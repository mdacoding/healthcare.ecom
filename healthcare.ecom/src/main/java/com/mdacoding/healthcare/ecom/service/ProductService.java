package com.mdacoding.healthcare.ecom.service;

import com.mdacoding.healthcare.ecom.model.Product;
import com.mdacoding.healthcare.ecom.payload.ProductDTO;
import com.mdacoding.healthcare.ecom.payload.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, Product product);
    ProductResponse getAllProducts();
    ProductResponse searchByCategory(Long categoryId);
    ProductResponse searchProductByKeyword(String keyword);
    ProductDTO updateProduct(Long productId, @Valid ProductDTO productDTO);
    ProductDTO deleteProduct(Long productId);
    ProductDTO updateProductImage(Long productId, MultipartFile image);
}
