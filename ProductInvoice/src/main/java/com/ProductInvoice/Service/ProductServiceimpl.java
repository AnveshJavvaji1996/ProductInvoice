package com.ProductInvoice.Service;

import com.ProductInvoice.ProductRepo.ProductRepository;
import com.ProductInvoice.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceimpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Override
    public String upsert(Product product) {
        productRepository.save(product);
        return "Product invoice details are saved successfully";
    }

    @Override
    public Product getById(Integer pid) {
        Optional<Product> findById = productRepository.findById(pid);
        if (findById.isPresent()) {
            return findById.get();
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();

    }

    @Override
    public String deleteById(Integer pid) {
        if (productRepository.existsById(pid)) {
            productRepository.deleteById(pid);
            return "Product invoice deleted successfully";
        }
        return "No record found";
    }
}