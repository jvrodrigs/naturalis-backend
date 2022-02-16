package app.naturalis.backend.config;

import app.naturalis.backend.event.InterceptorGenereateLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorRegister implements WebMvcConfigurer {

    @Autowired
    private InterceptorGenereateLogger interceptorGenereateLogger;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorGenereateLogger);
    }
}
