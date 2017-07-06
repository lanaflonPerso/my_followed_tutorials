package com.wefine.spring.service;

import com.wefine.spring.model.Product;

public interface ProductService {

    Product getByName(String name);

    void refreshAllProducts();
}
