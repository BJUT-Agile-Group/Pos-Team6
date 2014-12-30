package test.domains; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import domains.Item;
import domains.Pos;
import domains.ShoppingChart;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Pos Tester.
 *
 * @author <Authors name>
 * @since <pre>&#x2ae;&#xfffd;&#xfffd;&#xfffd;&#xfffd; 30, 2014</pre>
 * @version 1.0
 */
public class PosTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getShoppingList(ShoppingChart shoppingChart) 
* 
*/ 
@Test
public void testGetShoppingList() throws Exception { 
//TODO: Test goes here...
    ShoppingChart shoppingChart = new ShoppingChart();
    shoppingChart.add(new Item("ITEM000000", "可口可乐", "瓶", 3.00));
    shoppingChart.add(new Item("ITEM000000", "可口可乐", "瓶", 3.00));
    shoppingChart.add(new Item("ITEM000000", "可口可乐", "瓶", 3.00));
    shoppingChart.add(new Item("ITEM000000", "可口可乐", "瓶", 3.00));
    shoppingChart.add(new Item("ITEM000000", "可口可乐", "瓶", 3.00));
    shoppingChart.add(new Item("ITEM000001", "雪碧", "瓶", 3.00));
    shoppingChart.add(new Item("ITEM000001", "雪碧", "瓶", 3.00));
    shoppingChart.add(new Item("ITEM000004", "电池", "个", 2.00));
    // when
    Pos pos = new Pos();
    String actualShoppingList = pos.getShoppingList(shoppingChart);

    // then
    String expectedShoppingList =
            "***商店购物清单***\n"
                    + "名称：可口可乐，数量：5瓶，单价：3.00(元)，小计：15.00(元)\n"
                    +"名称：雪碧，数量：2瓶，单价：3.00(元)，小计：6.00(元)\n"
                    +"名称：电池，数量：1个，单价：2.00(元)，小计：2.00(元)\n"
                    + "----------------------\n"
                    + "总计：23.00(元)\n"
                    + "**********************\n";
    assertThat(actualShoppingList, is(expectedShoppingList));
} 


} 
