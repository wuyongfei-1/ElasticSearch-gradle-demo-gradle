package com.example.ElasticSearchgradledemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.ElasticSearchgradledemo.entity.City;
import com.example.ElasticSearchgradledemo.service.CityESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * this class by created wuyongfei on 2018/6/5 13:50
 **/
@RestController
public class CityController {

    @Autowired
    private CityESService cityESService;

    /**
     * create index to Elastic Search
     * @param indexName
     * @return
     */
    @PostMapping("/index/save")
    public String saveIndex(String indexName) {
        try {
            cityESService.buildIndex(indexName);
            return "{\"success\":1}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"success\":0}";
        }
    }

    /**
     *
     * @return
     */
    @PostMapping("/type/save")
    public String saveType() {
        JSONObject jsonObject = new JSONObject();
        City city = new City();
        city.setId(1L);
        city.setName("shang");
        String citys = jsonObject.toJSONString(city);
        JSONObject jsonObject1 = JSONObject.parseObject(citys);
        try {
            cityESService.addTargetDataALL(jsonObject1, "gtu-test", "gtu", "1");
            return "{\"success\":1}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"success\":0}";
        }
    }
}
