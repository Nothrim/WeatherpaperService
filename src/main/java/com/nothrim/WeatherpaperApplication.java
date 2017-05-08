package com.nothrim;

import com.nothrim.imgur.ImgurAPI;
import com.nothrim.json.imgur.Image;
import oracle.jdbc.pool.OracleDataSource;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.sql.SQLException;
import java.util.List;

@Configuration
@ComponentScan
@EnableScheduling
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class WeatherpaperApplication extends WebMvcConfigurerAdapter {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(WeatherpaperApplication.class);
    public static List<Image> images;
    @Autowired
    private ImgurAPI imgurAPI;

    public static void main(String[] args) {
        SpringApplication.run(WeatherpaperApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
//            Weather quote = restTemplate.getForObject(
//                    "http://api.wunderground.com/api/e5e6da42a0805669/hourly/q/CA/San_Francisco.json", Weather.class);
            //      imgurAPI.gallerySearchSimple("title:rainy", "top", "all", "1").getItems().forEach(e->log.info(e.toString()));
//            images = imgurAPI.gallerySearch(null, "rain,rainy,raining,downpour,cloudy", null, null, "png+jpg",
//                    "15000", "top", "all", "2").getItems();
        };
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    javax.sql.DataSource dataSource() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser("weatherpaper");
        dataSource.setPassword("ic");
        dataSource.setURL("jdbc:oracle:thin:@localhost:1521:XE");
        dataSource.setImplicitCachingEnabled(true);
        dataSource.setFastConnectionFailoverEnabled(true);
        return dataSource;
    }

    @Bean
    AuthenticationTrustResolver authenticationTrustResolver() {
        return new AuthenticationTrustResolverImpl();
    }

}
