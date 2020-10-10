package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author: zhoust
 * @Description:
 * @Date: 2020/10/9
 */
@SpringBootTest
public class LetterCombinationHandlerTest {

    @Autowired
    private Handler letterCombinationHandler;

    @Test
    public void testLetterCombination23(){
        List<String> results = letterCombinationHandler.execute("23");
        Assert.notEmpty(results,"返回错误");
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result + " ");
        }
        Assert.isTrue("ad ae af bd be bf cd ce cf".equals(stringBuilder.substring(0,stringBuilder.length() - 1)),"算法出错");
    }
    @Test
    public void testLetterCombination9(){
        List<String> results = letterCombinationHandler.execute("9");
        Assert.notEmpty(results,"返回错误");
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result + " ");
        }
        Assert.isTrue("w x y z".equals(stringBuilder.substring(0,stringBuilder.length() - 1)),"算法出错");
    }
    @Test
    public void testLetterCombinationWhenInputNull(){
        List<String> results = letterCombinationHandler.execute("");
        Assert.isTrue(CollectionUtils.isEmpty(results),"算法出错");
    }
}
