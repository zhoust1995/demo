package com.example.demo.enums;

/**
 * @author: zhoust
 * @Description:
 * @Date: 2020/10/11
 */
public enum CombinationTypeEnum {
    SINGLE("支持0到9"),
    MULTI("支持0到99");

    private final String desc;

    CombinationTypeEnum(String desc) {
        this.desc = desc;
    }
}
