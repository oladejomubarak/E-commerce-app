package com.example.ecommercesystem.controller;

import com.example.ecommercesystem.dtos.request.*;
import com.example.ecommercesystem.services.VendorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VendorController {
    @Autowired
    private VendorServices vendorServices;

    @PostMapping("/createvendor")
    public ResponseEntity<?> createVendor(@RequestBody CreateVendorRequest createVendorRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(vendorServices.createVendor(createVendorRequest));
    }
    @GetMapping("/vendorlogin")
    public ResponseEntity<?> vendorLogin(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(vendorServices.vendorLogin(loginRequest));
    }
    @PatchMapping("/updatevendor")
    public ResponseEntity<?> updateVendor(@RequestBody UpdateVendorRequest updateVendorRequest){
        return ResponseEntity.ok(vendorServices.updateVendor(updateVendorRequest));
    }
    @DeleteMapping("/deletevendor/{id}")
    public ResponseEntity<?> deleteVendor(@PathVariable String id){
        return ResponseEntity.ok(vendorServices.deleteVendor(id));
    }
    @PostMapping("/product/{vendorId}")
    public ResponseEntity<?> addProduct(@PathVariable String vendorId, @RequestBody AddProductRequest addProductRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(vendorServices.addProduct(vendorId, addProductRequest));
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<?> findProductById(@PathVariable String id){
        return ResponseEntity.ok(vendorServices.findProductById(id));
    }
    @PatchMapping("/updateproduct")
    public ResponseEntity<?> updateProduct(@RequestBody ProductUpdateRequest productUpdateRequest){
        return ResponseEntity.ok(vendorServices.updateProduct(productUpdateRequest));
    }
    @DeleteMapping("/deleteproduct/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productId){
    return ResponseEntity.ok(vendorServices.deleteProduct(productId));
    }
}
