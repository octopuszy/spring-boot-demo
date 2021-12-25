package com.zy.demo.resp;

import lombok.Data;

import java.util.List;

@Data
public class PageResp <T>{
    private int total;

    private List<T> list;
}
