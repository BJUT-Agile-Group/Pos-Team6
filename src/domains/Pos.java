package domains;

import java.util.ArrayList;

/**
 * Created by Sylvia on 2014/12/30.
 */
public class Pos {
    public String getShoppingList(ShoppingChart shoppingChart) {
        ArrayList<Item> items = shoppingChart.getItems();
        double total=0.0;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("***商店购物清单***\n");

        for(int i=0;i<items.size();i++)
        {
            Item item = items.get(i);
            int amountOfItem = item.getQuantity();
            double priceOfItem = item.getPrice();
            double discountOfItem=item.getDiscount();
            String nameOfItem = item.getName();
            String unitOfItem = item.getUnit();
            double subTotal = priceOfItem * amountOfItem*discountOfItem;
            total += subTotal;
            stringBuilder
                    .append("名称：").append(nameOfItem).append("，")
                    .append("数量：").append(amountOfItem).append(unitOfItem).append("，")
                    .append("单价：").append(String.format("%.2f", priceOfItem)).append("(元)").append("，")
                    .append("小计：").append(String.format("%.2f", subTotal)).append("(元)").append("\n");
        }
        stringBuilder
                .append("----------------------\n")
                .append("总计：").append(String.format("%.2f", total)).append("(元)").append("\n")
                .append("**********************\n");

        return stringBuilder.toString();
    }
}
