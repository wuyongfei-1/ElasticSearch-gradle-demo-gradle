package com.example.ElasticSearchgradledemo.entity;

import java.io.Serializable;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 **/
public class City implements Serializable {

    public static final String INDEX_NAME = "city";

    public static final String TYPE = "tstype";

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
