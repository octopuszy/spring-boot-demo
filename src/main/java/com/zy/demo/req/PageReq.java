package com.zy.demo.req;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
public class PageReq {
    private int page = 1;

    @NotNull(message = "【页数】不能为空")
    @Max(value = 100, message = "【每页条数】不能超过100")
    private int size;
}
