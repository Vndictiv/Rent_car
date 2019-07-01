package pl.borowik.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringRunner;
import pl.borowik.model.Role;
import pl.borowik.model.User;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    private User user;
    private UserService userService;

    @Before
    public void setUp() {
//        Set<Role> role = null;
//        Role objectRole = new Role();
//        role.add(objectRole);

        user = new User("FirstName", "LastName", "email@gmail.com"
                , "password", "status", null);
        user.setId(1);


    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenUserDoesNotExist() {

        userService.findById(3487);
    }




}
