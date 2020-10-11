package com.example.demo.service;

import com.example.demo.enums.CombinationTypeEnum;

import java.util.List;

/**
 * @author: zhoust
 * @Description:
 * @Date: 2020/10/9
 */
public interface CombinationHandler<T, R> {
    CombinationTypeEnum assignType();

    List<R> execute(T inputs);
}
