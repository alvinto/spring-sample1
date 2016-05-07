import com.ws.entity.User;
import com.ws.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by alvin on 2016/5/7.
 */
@RunWith(SpringJUnit4ClassRunner.class) //基于JUNIT4的spring测试框架
@ContextConfiguration(locations = {"/applicationContext.xml"}) //启动spring容器
public class TestUserService {
    @Autowired
    private UserService userService;

//    @Test
    public void hasMatchUser(){
        boolean b = userService.hasMatchUser("admin","123456");
        System.out.println(b);
    }

    @Test
    public void findUserByName(){
        User user = userService.findUserByName("admin");
        System.out.println(user);
    }

}
