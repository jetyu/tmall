package com.how2java.tmall.pojo;

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

    /**
     * @Title: toString
     * @Description: TODO(描述)
     * @Author Jet Yu
     * @Date 2020-04-25
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + "]";
    }

}