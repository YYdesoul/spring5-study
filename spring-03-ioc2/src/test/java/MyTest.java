import com.soul.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void testNoneConstructor() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User) context.getBean("user");
        System.out.println(user.toString());
    }

    @Test
    public void testConstructor() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

//        User user2 = (User) context.getBean("user2");
//        System.out.println(user2.toString());

        User user3 = (User) context.getBean("user3");
        System.out.println(user3.toString());
    }

    @Test
    public void testAlias() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User userThree = (User) context.getBean("userThree");
        System.out.println(userThree.toString());
    }


}
