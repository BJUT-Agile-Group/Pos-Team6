import domains.Item;
import domains.Pos;
import domains.ShoppingChart;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Enssie on 2015/01/01.
 */
public class PosTest {
    @Test
    public void testAddCorrectItems() throws Exception {
//TODO: Test goes here...
        ShoppingChart shoppingChart = new ShoppingChart();
        shoppingChart.add(new Item("ITEM000000", "可口可乐", "瓶", 3.00));
        shoppingChart.add(new Item("ITEM000000", "可口可乐", "瓶", 3.00));
        shoppingChart.add(new Item("ITEM000000", "可口可乐", "瓶", 3.00));
        shoppingChart.add(new Item("ITEM000000", "可口可乐", "瓶", 3.00));
        shoppingChart.add(new Item("ITEM000000", "可口可乐", "瓶", 3.00));
        shoppingChart.add(new Item("ITEM000001", "雪碧", "瓶", 3.00));
        shoppingChart.add(new Item("ITEM000001", "雪碧", "瓶", 3.00));
        shoppingChart.add(new Item("ITEM000004", "电池", "个", 2.00,0.8));
        // when
        Pos pos = new Pos();
        String actualShoppingList = pos.getShoppingList(shoppingChart);

        // then
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称：可口可乐，数量：5瓶，单价：3.00(元)，小计：15.00(元)\n"
                        +"名称：雪碧，数量：2瓶，单价：3.00(元)，小计：6.00(元)\n"
                        +"名称：电池，数量：1个，单价：2.00(元)，小计：1.60(元)\n"
                        + "----------------------\n"
                        + "总计：22.60(元)\n"
                        +"节省：0.40(元)\n"
                        + "**********************\n";
        assertThat(actualShoppingList, is(expectedShoppingList));
    }
    public void testDelItem() throws Exception {
        shoppingChart.add(new Item("ITEM000000", "可口可乐", "瓶", 3.00,3));
        shoppingChart.delete("ITEM000000");

        Pos pos = new Pos();
        String actualShoppingList = pos.getShoppingList(shoppingChart);

        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称：可口可乐，数量：2瓶，单价：3.00(元)，小计：6.00(元)\n"
                        + "----------------------\n"
                        + "总计：6.00(元)\n"
                        + "节省：0.00(元)\n"
                        + "**********************\n";
        assertThat(actualShoppingList, is(expectedShoppingList));
    }

    public void testAddItemOverStock() throws Exception{
        String actual = shoppingChart.add("ITEM000001", "ITEM000001", "ITEM000001");

        String expected =
                "商品不足!";
        assertThat(actual, is(expected));
    }
}