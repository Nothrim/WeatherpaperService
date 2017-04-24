package com.nothrim;

import com.nothrim.json.Weather;
import oracle.jdbc.pool.OracleDataSource;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLException;

@Configuration
@ComponentScan
@EnableScheduling
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class WeatherpaperApplication {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(WeatherpaperApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(WeatherpaperApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Weather quote = restTemplate.getForObject(
                    "http://api.wunderground.com/api/e5e6da42a0805669/hourly/q/CA/San_Francisco.json", Weather.class);
            log.info(quote.toString());
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
}
