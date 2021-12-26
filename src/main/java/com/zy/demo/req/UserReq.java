package com.zy.demo.req;

import com.zy.demo.req.scenes.Save;
import com.zy.demo.req.scenes.Update;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserReq {

    @NotNull(message = "【用户名】不能为空")
    private String loginName;

    @NotNull(groups = {Save.class}, message = "【昵称】不能为空")
    private String name;

    @Size(min=6, message = "【密码】至少6位")
    @NotNull(message = "【密码】不能为空")
    private String password;

}
