package cn.edu.csu.dyp.Config;

import com.captcha.botdetect.web.servlet.SimpleCaptchaServlet;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
public class CaptchaConfig {
    @Bean
    ServletRegistrationBean captchaServletRegistration () {
        ServletRegistrationBean srb = new ServletRegistrationBean();
        srb.setServlet(new SimpleCaptchaServlet());
        srb.addUrlMappings("/captcha-endpoint");//不以-endpoint结尾会有问题
        return srb;
    }

    @Bean
    public ServletContextInitializer initializer() {
        return new ServletContextInitializer() {
            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                servletContext.setInitParameter(
                        "BDC_configFileLocation", "/resources/botdetect.xml");
            }
        };
    }
}
