import com.soul.dao.MySqlDao;
import com.soul.dao.OracleDao;
import com.soul.service.UserService;
import com.soul.service.UserServiceImpl;
import org.junit.Test;

public class MyTest {

    @Test
    public void testUserService() {
        UserService userService = new UserServiceImpl();
        userService.setUserDao(new OracleDao());
        userService.getUser();

        userService.setUserDao(new MySqlDao());
        userService.getUser();
    }

}
