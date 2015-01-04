import domains.Connect;
import domains.Item;

import java.text.SimpleDateFormat;
import java.sql.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by Enssie on 2015/1/4 0004.
 */
public class ConnTest {
    public void testCompareDate() throws Exception {
        Connect con = new Connect();
        String dateString = "2012-12-06 ";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        Date d1 = (Date) sdf.parse(dateString);
        dateString = "2012-12-08";
        Date d2 = (Date) sdf.parse(dateString);
        int actual = con.compare_date(d1,d2);
        int expected = -1;
        assertThat(actual,is(expected));
    }

    public void testCheckDiscount() throws Exception{
        Connect con = new Connect();
        String dateString = "2012-05-06 ";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        Date date = (Date) sdf.parse(dateString);

        Item item = new Item("ITEM000000", "牙膏", "支", 3.00);
        boolean actual = con.checkDiscount(item,date);

        assertThat(actual,is(false));
    }
}
