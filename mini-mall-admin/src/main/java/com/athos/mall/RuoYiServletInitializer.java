package com.athos.mall;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.Hashtable;

/**
 * web容器中进行部署
 *
 * @author ruoyi
 */
public class RuoYiServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        Hashtable t = new Hashtable();
        return application.sources(Application.class);
    }
}
