package com.wefine.spring.service;

import com.wefine.spring.model.Product;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Override
    @Cacheable("products")
    public Product getByName(String name) {
        slowLookupOperation();
        return new Product(name, 100);
    }

    @CacheEvict(value = "products", allEntries = true)
    public void refreshAllProducts() {
        //This method will remove all 'products' from cache, say as a result of flush API.
    }

    private void slowLookupOperation() {
        try {
            long time = 5000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
