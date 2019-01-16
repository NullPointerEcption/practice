package com.web.practice.param;

import lombok.Data;

/**
 * 泛型类参数
 * @param <T>
 */
@Data
public class QueryParam<T> {

    private String username;

    private T entity;

}
