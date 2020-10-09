package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    public void testLetterCombination(){
        List<String> results = letterCombinationHandler.execute("234");
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result + " ");
        }
        System.out.println(stringBuilder.substring(0,stringBuilder.length() - 1));
    }
}
