package com.wyclass;

import com.wyclass.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import java.time.ZoneId;

@Configuration
@ComponentScan
public class AppConfig {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.login("bob@example.com", "password");
    }

    @Bean
    @Profile("!test")
    ZoneId createZoneId() {
        return ZoneId.systemDefault();
    }

    @Bean
    @Profile("test")
    ZoneId createZoneIdForTest() {
        return ZoneId.of("America/New_York");
    }
}
