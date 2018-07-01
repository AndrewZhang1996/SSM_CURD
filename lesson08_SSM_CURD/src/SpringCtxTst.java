import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringCtxTst {


    @Value("${mysql.url}")
    private String uname;

    private String pwd;

    @Test
    public void test(){
    	ComboPooledDataSource a;
        System.out.println("username:"+uname);
        System.out.println("password:"+pwd);
    }
}