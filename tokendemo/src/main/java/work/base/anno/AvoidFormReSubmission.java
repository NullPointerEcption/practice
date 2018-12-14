package work.base.anno;

import java.lang.annotation.*;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2018-12-14 18:12
 **/
@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AvoidFormReSubmission {
    /**
     *
     * @return
     */
    boolean needSaveToken() default false;

    /**
     *
     * @return
     */
    boolean needRemoveToken() default false;
}
