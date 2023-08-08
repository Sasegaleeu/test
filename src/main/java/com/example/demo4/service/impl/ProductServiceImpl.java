package com.example.demo4.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo4.domain.Products;
import com.example.demo4.mapper.ProductMapper;
import com.example.demo4.service.ProductService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Override
    public void loadProductsFromFile() throws IOException{
        Gson gson = new Gson();
        InputStream inputStream = getClass().getResourceAsStream("/static/Products.json");
        if (inputStream == null) {
            throw new FileNotFoundException("File not found: Products.json");
        }
        InputStreamReader reader = new InputStreamReader(inputStream);
        List<Products> products = gson.fromJson(reader, new TypeToken<List<Products>>() {
        }.getType());
        for (Products product : products) {
            productMapper.insertProducts(product);
        }
    }
}
