package com.atguigu.juc.jucstudy02.enums;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import lombok.Getter;

public enum CountryEnum {

    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"赵"),FOUR(4,"燕"),FIVE(5,"韩"),SIX(6,"魏");


    @Getter private Integer retCode;
    @Getter private String retMessage;

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static CountryEnum forEach_CountryEnum(int index)
    {
        CountryEnum[] myArray = CountryEnum.values();
        for (CountryEnum countryEnum : myArray)
        {
            if(index == countryEnum.getRetCode())
            {
                return countryEnum;
            }
        }
        return null;
    }
}
