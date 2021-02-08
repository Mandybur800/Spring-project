package org.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.test.config.AppConfig;
import org.test.model.User;
import org.test.service.UserService;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        User bob = new User("Bob", "Bobbion", "bobobob@bob.cob");
        User alice = new User("Alice", "Alisson", "alice@ali.ce");
        userService.add(bob);
        userService.add(alice);
        userService.listUsers().forEach(System.out::println);
    }
}
