package domains;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Sylvia on 2015/1/3.
 */
public class ReadList {
    private File index;
    private File list;
    private final ObjectMapper objectMapper;

    public ReadList(File index,File list) {
        this.index = index;
        this.list=list;
        objectMapper = new ObjectMapper(new JsonFactory());
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    }

    public ShoppingChart parser() throws IOException {
        String textInput = FileUtils.readFileToString(index);
        //ArrayList<Item> indexOfGoods=new ArrayList<Item>();
        Map<String, Map<String,Object>> maps = objectMapper.readValue(textInput, Map.class);
        Map<String,Item> indexOfGoods=new HashMap<String, Item>();
        Set<String> key = maps.keySet();
        Iterator<String> iter = key.iterator();

        try{
            while (iter.hasNext()) {
                String field = iter.next();
                String name = maps.get(field).get("name").toString();
                String unit = maps.get(field).get("unit").toString();
                double price = Double.parseDouble(maps.get(field).get("price").toString());
                if(maps.get(field).containsKey("discount")){
                    indexOfGoods.put(field,new Item(field,name,unit,price,Double.parseDouble(maps.get(field).get("discount").toString())));
                }
                else if(maps.get(field).containsKey("promotion")){
                    indexOfGoods.put(field,new Item(field,name,unit,price,Boolean.parseBoolean(maps.get(field).get("promotion").toString())));
                }
                else {
                    indexOfGoods.put(field,new Item(field,name,unit,price));
                }
            }
        }catch (Exception exception) {
            exception.printStackTrace();
        }
        //ShoppingChart shoppingChart = new ShoppingChart();

        return BuildShoppingChart(indexOfGoods);
    }

    private ShoppingChart BuildShoppingChart(Map<String,Item> maps) throws IOException {
        ShoppingChart shoppingChart = new ShoppingChart();
        ArrayList<String> list1=this.getListOfGoods();

        for(int i=0;i<list1.size();i++){
            shoppingChart.add(maps.get(list1.get(i)));
        }

        return shoppingChart;
    }

    private ArrayList<String> getListOfGoods() throws IOException{
        String textInput = FileUtils.readFileToString(list);
        //ArrayList<Item> indexOfGoods=new ArrayList<Item>();
        ArrayList<String> listOfGoods = objectMapper.readValue(textInput, ArrayList.class);

        return listOfGoods;
    }
}
