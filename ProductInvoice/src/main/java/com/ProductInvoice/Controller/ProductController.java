package com.ProductInvoice.Controller;


import com.ProductInvoice.Service.ProductService;
import com.ProductInvoice.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;


    @PostMapping("/product")
    public ResponseEntity<String> saveInvoice(@RequestBody Product product){
        String status = productService.upsert(product);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<String> updateInvoice(@RequestBody Product product){
        String update = productService.upsert(product);
        return new ResponseEntity<>(update,HttpStatus.CREATED);

    }

    @GetMapping("/product/{pid}")
     public ResponseEntity<Product> getInvoice(@PathVariable Integer pid){
         Product productId = productService.getById(pid);
            return new ResponseEntity<>(productId,HttpStatus.OK);
     }



     @GetMapping("/getAllInvoices")
     public ResponseEntity<List> getAllProducts(){
         List<Product> allInvoices = productService.getAllProducts();
         return new ResponseEntity<>(allInvoices,HttpStatus.OK);

     }
     @DeleteMapping("/deleteProduct/{pid}")
     public ResponseEntity<String> deleteInvoice(@PathVariable Integer pid){
         String status = productService.deleteById(pid);
         return new ResponseEntity<>(status,HttpStatus.OK);
     }

}
