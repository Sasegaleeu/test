package com.example.demo4.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TableMapper {
    void dropProducts();
    void createProducts();
    void dropProductsStocks();
    void createProductsStocks();
}
