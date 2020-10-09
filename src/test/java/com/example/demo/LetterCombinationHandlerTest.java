package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author: zhoust
 * @Description:
 * @Date: 2020/10/9
 * ******************************************************************************
 * Copyright (C)  CSG Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为鼎信信息科技有限责任公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * *****************************************************************************
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
