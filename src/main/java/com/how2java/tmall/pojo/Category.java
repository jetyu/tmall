package com.how2java.tmall.pojo;

/**
 * 
 * @Name: Category
 * @Description: TODO(Category的DAO)
 * @Author Jet Yu
 * @Date 2020-04-13
 */
public class Category {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}