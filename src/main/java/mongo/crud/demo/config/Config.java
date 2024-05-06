package mongo.crud.demo.config;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.mongodb.MongoClient;

import mongo.crud.demo.utils.bootstarpApp;

@EnableWebMvc
@Configuration
@ComponentScan({ "mongo.crud.demo" })
public class Config implements WebMvcConfigurer{

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Bean
	public InternalResourceViewResolver configureViewResolvers() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public MongoDbFactory mongoDbFactory() {
		return new SimpleMongoDbFactory(new MongoClient("localhost", 27017), "dell_poc");
	}

	@Bean
	@Qualifier("firstBean")
	public MongoTemplate mongoTemplate() {
		System.out.println("mongoTemplate Execut");
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		bootstarpApp.seedCollection(mongoTemplate);
		return mongoTemplate;
	}
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new MappingJackson2HttpMessageConverter());
	}
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	System.out.println("ResourceHandler Calls");
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/WEB-INF/resources/");
    	System.out.println(registry.toString());
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder(16);
    }
}
