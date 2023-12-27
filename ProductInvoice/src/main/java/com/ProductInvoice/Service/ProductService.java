package com.ProductInvoice.Service;

import com.ProductInvoice.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface ProductService {
    public String upsert(Product product);
    public Product getById(Integer pid);
    public List<Product> getAllProducts();
    public String deleteById(Integer pid);

}
