package next.persistence;

import core.jdbc.ConnectionManager;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class DbConnectTests {

    @Test
    public void dbConnectTest() throws Exception{
        Connection con = ConnectionManager.getConnection();
        Assert.assertNotNull(con);
    }
}
