package controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @description: 防止表单重复提交的演示Token
 * @author: WangYuFei
 * @create: 2018-12-14 17:58
 **/
@RestController
public class TokenTestController {
    /**
     * 获得token
     *
     * @return 获取token
     */
    public String getToken() {
        return UUID.randomUUID().toString();
    }

    /**
     * 添加订单
     *
     * @return SUCCESS
     */
    public String addOrder() {
        //dao处理 添加订单
        return "SUCCESS";
    }

    /**
     * 添加订单2
     *
     * @return SUCCESS
     */
    public String addOrder2() {
        //dao处理 添加订单
        return "SUCCESS";
    }

}
