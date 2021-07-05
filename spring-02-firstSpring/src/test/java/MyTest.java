import com.soul.Hello;
import com.soul.dao.UserDao;
import com.soul.service.UserService;
import com.soul.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void testHello() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());

    }

    @Test
    public void testUserBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("users.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.getUser();
    }
}
