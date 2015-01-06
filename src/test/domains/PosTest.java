package test.domains; 

import domains.Item;
import domains.Pos;
import domains.ShoppingChart;
import junit.framework.Test;
import junit.framework.TestSuite; 
import junit.framework.TestCase;

import java.text.DateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/** 
* Pos Tester. 
* 
* @author <Authors name> 
* @since <pre>01/04/2015</pre> 
* @version 1.0 
*/ 
public class PosTest extends TestCase {
    @org.junit.Test
    public void testAddPromotedItems() throws Exception {
//TODO: Test goes here...
        ShoppingChart shoppingChart = new ShoppingChart();
        shoppingChart.add(new Item("ITEM000000", "可口可乐", "瓶", 3.00,true),3);
//        shoppingChart.add(new Item("ITEM000000", "可口可乐", "瓶", 3.00));
//        shoppingChart.add(new Item("ITEM000000", "可口可乐", "瓶", 3.00));
//        shoppingChart.add(new Item("ITEM000000", "可口可乐", "瓶", 3.00));
//        shoppingChart.add(new Item("ITEM000000", "可口可乐", "瓶", 3.00));
//        shoppingChart.add(new Item("ITEM000001", "雪碧", "瓶", 3.00));
//        shoppingChart.add(new Item("ITEM000001", "雪碧", "瓶", 3.00));
//        shoppingChart.add(new Item("ITEM000004", "电池", "个", 2.00,0.8));
        // when
        Pos pos = new Pos();
        String actualShoppingList = pos.getShoppingList(shoppingChart);

        Date d=new Date();
        DateFormat d5 = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
        String time = d5.format(d);
        // then
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "打印时间："+ time
                        + "\n----------------------\n"
                        + "名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：6.00(元)\n"
//                        +"名称：雪碧，数量：2瓶，单价：3.00(元)，小计：6.00(元)\n"
//                        +"名称：电池，数量：1个，单价：2.00(元)，小计：1.60(元)\n"
                        + "----------------------\n"
                        + "挥泪赠送商品：\n"
                        + "名称：可口可乐，数量：1瓶\n"
                        + "----------------------\n"
                        + "总计：6.00(元)\n"
                        + "节省：3.00(元)\n"
                        + "**********************\n";
        assertThat(actualShoppingList, is(expectedShoppingList));
    }
    public void testDelItem() throws Exception {
        ShoppingChart shoppingChart = new ShoppingChart();

        Item cola = new Item("ITEM000000", "可口可乐", "瓶", 3.00);
        shoppingChart.add(cola,3);
        shoppingChart.remove(cola);

        Pos pos = new Pos();
        String actualShoppingList = pos.getShoppingList(shoppingChart);

        Date d=new Date();
        DateFormat d5 = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
        String time = d5.format(d);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "打印时间："+ time
                        + "\n----------------------\n"
                        + "名称：可口可乐，数量：2瓶，单价：3.00(元)，小计：6.00(元)\n"
                        + "----------------------\n"
                        + "总计：6.00(元)\n"
                        + "**********************\n";
        assertThat(actualShoppingList, is(expectedShoppingList));
    }

    public void testAddItemOverStock() throws Exception{
        ShoppingChart shoppingChart = new ShoppingChart();
        Item sprite = new Item("ITEM000001", "雪碧", "瓶", 3.00);
        int actual = shoppingChart.add(sprite,3);
        int expected = 1;
        assertThat(actual, is(expected));
    }
} 
