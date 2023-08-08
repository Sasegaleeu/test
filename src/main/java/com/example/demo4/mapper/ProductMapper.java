package com.example.demo4.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo4.domain.Products;

@Mapper
public interface ProductMapper {
    void insertProducts(Products product);
}
