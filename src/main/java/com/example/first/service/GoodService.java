package com.example.first.service;

import com.example.first.entity.Good;
import com.example.first.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService {
    private GoodRepository goodRepository;

    @Autowired
    public GoodService(GoodRepository goodRepository) {
        this.goodRepository = goodRepository;
    }
    public List<String> findAllNames (){
        return goodRepository.findAllNames();
    }
}
