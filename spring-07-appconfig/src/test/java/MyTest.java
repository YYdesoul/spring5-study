import com.soul.config.SoulConfig;
import com.soul.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    @Test
    public void testSoulConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SoulConfig.class);
        User user = context.getBean("getUser", User.class);
        System.out.println(user.name);
    }
}
