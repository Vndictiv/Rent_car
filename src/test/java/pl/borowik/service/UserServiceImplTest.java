package pl.borowik.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringRunner;
import pl.borowik.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    private User user;
    private UserService userService;

    @Before
    public void setUp(){
        User user = new User();
    }


}
