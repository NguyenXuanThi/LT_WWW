package iuh.fit.se.beans.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class userService {
@Bean
    public Group groupService(){
    return new Group("Admin Group");
}

@Bean
    public User userService(){
    return new User("user1","123465", groupService());
}
}
