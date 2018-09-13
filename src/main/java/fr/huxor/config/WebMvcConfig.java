package fr.huxor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	/**
	 * Access Bootstrap static resource
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/jquery/**") 
                .addResourceLocations("classpath:/META-INF/resources/webjars/jquery/3.0.0/");

        registry.addResourceHandler("/popper/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/popper.js/1.14.1/umd/");
  
        registry.addResourceHandler("/bootstrap/**") 
                .addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/4.1.2/");
	}
	
	
	
	
}
