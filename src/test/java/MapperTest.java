import com.test.StartApplication;
import com.test.domain.User;
import com.test.mapper.UserMapper;
import com.test.mapper.UserMapper2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartApplication.class)
public class MapperTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserMapper2 userMapper2;

    @Test
    public void test(){
        List<User> users = userMapper.queryUserList();
        System.out.println(users);
    }

    @Test
    public void test1(){
        List<User> users = userMapper2.getUser();
        System.out.println(users);
    }

    @Test
    public void test2(){
        String name = userMapper2.getName("zhangsan");
        System.out.println(name);
    }

    @Test
    public void test3(){
        List<String> names = userMapper2.getNames();
        for (String name: names){
            System.out.println(name);
        }
    }
}
