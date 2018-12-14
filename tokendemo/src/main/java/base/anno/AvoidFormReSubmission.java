package base.anno;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2018-12-14 18:12
 **/
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
