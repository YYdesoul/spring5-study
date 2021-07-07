import com.soul.service.Userservice;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void testAOP() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Userservice userService = context.getBean("userService", Userservice.class);
        userService.add();
    }

    @Test
    public void testAOP2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        Userservice userService = context.getBean("userService", Userservice.class);
        userService.add();
    }

    @Test
    public void testAOPAnnotation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanAnnotation.xml");
        Userservice userService = context.getBean("userService", Userservice.class);
        userService.add();
    }


}
