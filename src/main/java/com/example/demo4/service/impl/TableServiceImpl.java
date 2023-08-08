package com.example.demo4.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo4.mapper.TableMapper;
import com.example.demo4.service.TableService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TableServiceImpl implements TableService {

    private final TableMapper tableMapper;

    @Override
    @Transactional
    public void resetDatabase() {
        tableMapper.dropProductsStocks();
        tableMapper.dropProducts();
        tableMapper.createProducts();
        tableMapper.createProductsStocks();
    }
}
