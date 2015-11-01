package com.pickle.main;

/**
 * Created by Yanuar Wicaksana on 11/1/15.
 */
import com.pickle.filter.CORSFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.velocity.VelocityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.servlet.Filter;

@Configuration
@ImportResource({
        "file:${ROOT_APP}/configuration/applicationContext.xml"
})
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class,
        VelocityAutoConfiguration.class})
public class Application {

    @Bean
    public Filter cORSFilter() {
        return new CORSFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(new Object[]{Application.class}, args);
    }

}
