package test;

import main.java.DBUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Maria
 * @program jdbc-demo
 * @date 2019/10/26 9:13
 */
public class DBUtilTest {

    @Test
    public void testConnection(){
        Assert.assertNotNull(DBUtil.getConnection());
    }

    @Test
    public  void test(){
        Assert.assertNotNull(new Object());
    }
}
