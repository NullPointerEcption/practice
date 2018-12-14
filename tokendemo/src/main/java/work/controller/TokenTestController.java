package work.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.base.anno.AvoidFormReSubmission;

import java.util.UUID;

/**
 * @description: 防止表单重复提交的演示Token
 * @author: WangYuFei
 * @create: 2018-12-14 17:58
 **/
@RestController
@RequestMapping("token")
public class TokenTestController {
    /**
     * 获得token
     *
     * @return 获取token
     */
    @GetMapping
    @AvoidFormReSubmission(needSaveToken = true)
    public String getToken() {
        return UUID.randomUUID().toString();
    }

    /**
     * 添加订单
     *
     * @return SUCCESS
     */
    @PostMapping("add1")
    @AvoidFormReSubmission(needRemoveToken = true)
    public String addOrder() {
        //dao处理 添加订单
        return "SUCCESS";
    }

    /**
     * 添加订单2
     *
     * @return SUCCESS
     */
    @PostMapping("add2")
    @AvoidFormReSubmission(needRemoveToken = true)
    public String addOrder2() {
        //dao处理 添加订单
        return "SUCCESS";
    }

}
