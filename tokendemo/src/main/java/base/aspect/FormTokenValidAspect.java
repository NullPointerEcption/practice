package base.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author:wangyufei
 * @CreateTime: 2018/9/14
 * @Description: 进行form-token拦截检查，防止表单重复提交
 */
@Component
@Aspect
public class FormTokenValidAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(FormTokenValidAspect.class);

    /**
     * form-token校验
     *
     * @param joinPoint ProceedingJoinPoint
     */
    @Before("execution(* controller.TokenTestController.*(..)) && && @annotation(base.anno.AvoidFormReSubmission)")
    public void before(JoinPoint joinPoint) {
        checkToken();
    }

    /**
     * 请求开始 校验form-token是否存在
     */
    private synchronized void checkToken() {

    }
}
