package com.lewis.recruit.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

@Configuration
public class KeyGeneratorConfiguration {
    //所有职位信息
    @Bean("allPositionList")
    public KeyGenerator allPositions() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return "all";
            }
        };
    }

    //公司所有职位信息
    @Bean("byCompanyId")
    public KeyGenerator positionsByCompanyId() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return "company_of_" + params[0];
            }
        };
    }

    //根据关键字搜索职位信息
    @Bean("byKey")
    public KeyGenerator positionsByKey() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return "key_of_" + params[0];
            }
        };
    }
}
