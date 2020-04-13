package com.how2java.tmall.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Name: TestTmall
 * @Description: TODO(生成category测试数据)
 * @Author Jet Yu
 * @Date 2020-04-13
 */
public class TestTmall {

    public static void main(String args[]) {
        // 准备分类测试数据：
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
            Connection c =
                DriverManager.getConnection("jdbc:mysql://49.235.86.66:3306/tmall_ssm?useUnicode=true&characterEncoding=utf8", "root", "910208");
            Statement s = c.createStatement();) {

            final int count = 10;
            for (int i = 1; i <= count; i++) {
                String sqlFormat = "insert into category values (null, '测试分类%d')";
                String sql = String.format(sqlFormat, i);
                System.out.println(sql);
                s.execute(sql);
            }
            System.out.println("已经成功创建10条分类测试数据");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}