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
    public void testLetterCombination2(){
        List<String> results = letterCombinationHandler.execute("2");
        Assert.notEmpty(results,"返回错误");
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result + " ");
        }
        Assert.isTrue("a b c".equals(stringBuilder.substring(0,stringBuilder.length() - 1)),"算法出错");
    }
    @Test
    public void testLetterCombinationWhenInputNull(){
        List<String> results = letterCombinationHandler.execute("");
        Assert.isTrue(CollectionUtils.isEmpty(results),"算法出错");
    }
    @Test
    public void testLetterCombination0(){
        List<String> results = letterCombinationHandler.execute("0");
        Assert.isTrue(CollectionUtils.isEmpty(results),"算法出错");
    }

    @Test
    public void testLetterCombination1(){
        List<String> results = letterCombinationHandler.execute("1");
        Assert.isTrue(CollectionUtils.isEmpty(results),"算法出错");

    }
    @Test
    public void testLetterCombination20(){
        List<String> results = letterCombinationHandler.execute("20");
        Assert.notEmpty(results,"返回错误");
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result + " ");
        }
        Assert.isTrue("a b c".equals(stringBuilder.substring(0,stringBuilder.length() - 1)),"算法出错");
    }
    @Test
    public void testLetterCombination02(){
        List<String> results = letterCombinationHandler.execute("02");
        Assert.notEmpty(results,"返回错误");
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result + " ");
        }
        Assert.isTrue("a b c".equals(stringBuilder.substring(0,stringBuilder.length() - 1)),"算法出错");
    }
    @Test
    public void testLetterCombination31(){
        List<String> results = letterCombinationHandler.execute("31");
        Assert.notEmpty(results,"返回错误");
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result + " ");
        }
        Assert.isTrue("d e f".equals(stringBuilder.substring(0,stringBuilder.length() - 1)),"算法出错");
    }
    @Test
    public void testLetterCombination13(){
        List<String> results = letterCombinationHandler.execute("13");
        Assert.notEmpty(results,"返回错误");
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result + " ");
        }
        Assert.isTrue("d e f".equals(stringBuilder.substring(0,stringBuilder.length() - 1)),"算法出错");
    }

    @Test
    public void testLetterCombination55(){
        List<String> results = letterCombinationHandler.execute("55");
        Assert.notEmpty(results,"返回错误");
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result + " ");
        }
        Assert.isTrue("jj jk jl kj kk kl lj lk ll".equals(stringBuilder.substring(0,stringBuilder.length() - 1)),"算法出错");
    }

    @Test
    public void testLetterCombination99(){
        List<String> results = letterCombinationHandler.execute("99");
        Assert.notEmpty(results,"返回错误");
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result + " ");
        }
        Assert.isTrue("ww wx wy wz xw xx xy xz yw yx yy yz zw zx zy zz".equals(stringBuilder.substring(0,stringBuilder.length() - 1)),"算法出错");
    }
}
