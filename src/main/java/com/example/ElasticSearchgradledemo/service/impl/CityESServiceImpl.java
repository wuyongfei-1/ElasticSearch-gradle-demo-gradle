package com.example.ElasticSearchgradledemo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.ElasticSearchgradledemo.dao.ESRepository;
import com.example.ElasticSearchgradledemo.service.CityESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 **/
@Service
public class CityESServiceImpl implements CityESService {
    @Autowired
    private ESRepository eSRepository;

    @Override
    public boolean buildIndex(String index) {
        return eSRepository.buildIndex(index);
    }

    @Override
    public boolean delIndex(String index) {
        return eSRepository.deleteIndex(index);
    }

    @Override
    public Map<String, Object> searchDataByParam(String index, String type, String id) {
        // TODO Auto-generated method stub
        return eSRepository.searchDataByParam(index, type, id);
    }

    @Override
    public void updateDataById(JSONObject data, String index, String type, String id) {
        // TODO Auto-generated method stub
        eSRepository.updateDataById(data, index, type, id);
    }

    @Override
    public String addTargetDataALL(JSONObject data, String index, String type, String id) {
        // TODO Auto-generated method stub
        return eSRepository.addTargetDataALL(data, index, type, id);
    }

    @Override
    public void delDataById(String index, String type, String id) {
        // TODO Auto-generated method stub
        eSRepository.delDataById(index, type, id);
    }

    @Override
    public boolean isIndexExist(String index) {
        // TODO Auto-generated method stub
        return eSRepository.isIndexExist(index);
    }
}
