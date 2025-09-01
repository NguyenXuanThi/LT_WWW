package fit.se;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserService {
    public User getUser() {
        return new User("Minh", 21, "123456789");
    }
}
