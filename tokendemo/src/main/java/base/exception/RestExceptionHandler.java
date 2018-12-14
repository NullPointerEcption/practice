package base.exception;

import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Map;

/**
 * <p>
 * Description: 异常统一处理handler
 * </p>
 */
@EnableWebMvc
@ControllerAdvice
public class RestExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(RestExceptionHandler.class);

    /**
     * 500错误
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String,Object> onServerError(RuntimeException ex) {
        LOG.error("服务器内部异常", ex);
        return ImmutableMap.of("error", ex.getMessage());
    }

}
