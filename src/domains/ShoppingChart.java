package domains;

import java.util.ArrayList;

/**
 * Created by Sylvia on 2014/12/30.
 */
public class ShoppingChart {
    private ArrayList<Item> items = new ArrayList<Item>();

    public void add(Item item) {
        boolean isExist=false;
        for(int i=0;i<items.size();i++){
            if(item.getName()==items.get(i).getName()) {
                items.get(i).addQuantity();
                isExist=true;
            }
        }
        if(isExist==false){
            this.items.add(item);
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
