package work.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import work.base.interceptor.SessionTokenHandlerInterceptor;

@SpringBootConfiguration
public class MyAdapter implements WebMvcConfigurer{

    @Autowired
    private SessionTokenHandlerInterceptor sessionTokenHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        registry.addInterceptor(sessionTokenHandlerInterceptor)
                .addPathPatterns("/**");
    }
}