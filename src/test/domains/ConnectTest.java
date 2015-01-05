package test.domains; 

import domains.Connect;
import domains.Item;
import junit.framework.Test;
import junit.framework.TestSuite; 
import junit.framework.TestCase;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/** 
* Connect Tester. 
* 
* @author <Authors name> 
* @since <pre>01/05/2015</pre> 
* @version 1.0 
*/ 
public class ConnectTest extends TestCase {
    public void testCompareDate() throws Exception {
        Connect con = new Connect();
        long date = 20140105;
        Date d1 = new Date(date);
        date = 20140106;
        Date d2 = new Date(date);
        int actual = con.compare_date(d1,d2);
        int expected = -1;
        assertThat(actual,is(expected));
    }

    public void testCheckDiscount() throws Exception{
        Connect con = new Connect();
        long d = 20140506;
        Date date = new Date(d);

        Item item = new Item("ITEM000003", "牙膏", "支", 10.00);
        boolean actual = con.checkDiscount(item,date);

        assertThat(actual,is(false));
    }

    public void testCheckQuantity() throws Exception{
        String barCode = "ITEM000000";
        Connect con = new Connect();
        int actual = con.checkQuantity(barCode);
        int expected = 30;
        assertThat(actual,is(expected));
    }

    public void testCheckCode() throws Exception{
        String barCode = "ITEM000000";
        Connect con = new Connect();
        boolean actual = con.checkCode(barCode);
        boolean expected = true;
        assertThat(actual,is(expected));
    }
} 
