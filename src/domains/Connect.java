package domains;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhiwei on 2015/1/2.
 */
public class Connect {
    Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;

    //数据库连接
    public void connect(){
        try {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lab", "root", "lzw0201");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //断开数据库连接
    public void  disconnect(){
        try {
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //日期比较
    public int compare_date(Date dt1, Date dt2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 在dt2前");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1在dt2后");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    //查询库存商品
    public List checkStock(){
        List<Item> stock = new ArrayList<Item>();
        String select_all="select * from Item";
        try {
            stmt=con.createStatement();
            rs=stmt.executeQuery(select_all);
            while(rs.next()){
                String barCode = rs.getString("barcode");
                String name =rs.getString("name");
                String unit =rs.getString("unit");;
                double price = rs.getDouble("price");
                int quantity=rs.getInt("quantity");
                double discount=rs.getDouble("discount");
                Item item=new Item(barCode,name,unit,price,quantity,discount);
                stock.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return stock;
    }

    //判断商品编号是否存在
    public boolean checkCode(String barCode) {
        boolean a=false;
        String select_code = "select * from item where barcode=" + barCode + "";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(select_code);
            if (rs.getString("barcode") == barCode)
                a=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //根据商品名称判断该商品的其他信息是否与输入的匹配
    public boolean matchByName(Item item){
        boolean a=true;
        int i=0;
        String barCode;
        String unit;
        double price;
        int quantity;
        double discount;
        Date start;
        Date end;
        int judge;
        String select_match="select * from item where name="+item.getName()+"";
        try {
            stmt=con.createStatement();
            rs=stmt.executeQuery(select_match);
            while(rs.next()){
                barCode = rs.getString("barcode");
                unit = rs.getString("unit");
                price = rs.getDouble("price");
                quantity = rs.getInt("quantity");
                discount = rs.getDouble("discount");
                start = rs.getDate("start");
                end = rs.getDate("end");
                judge = rs.getInt("judge");
                if(item.getBarCode() !=barCode||item.getUnit()!=unit||item.getPrice()!=price||item.getQuantity()!=quantity
                        ||item.getDiscount()!=discount||item.getStart()!=start||item.getEnd()!=end
                        ||item.getJudge()!=judge)
                    a=false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //根据商品编号判断该商品的其他信息是否与输入的匹配
    public boolean matchByBarcode(Item item){
        boolean a=true;
        int i=0;
        String name;
        String unit;
        double price;
        int quantity;
        double discount;
        Date start;
        Date end;
        int judge;
        String select_match="select * from item where barcode="+item.getBarCode()+"";
        try {
            stmt=con.createStatement();
            rs=stmt.executeQuery(select_match);
            while(rs.next()){
                name = rs.getString("name");
                unit = rs.getString("unit");
                price = rs.getDouble("price");
                quantity = rs.getInt("quantity");
                discount = rs.getDouble("discount");
                start = rs.getDate("start");
                end = rs.getDate("end");
                judge = rs.getInt("judge");
                if(item.getName()!=name||item.getUnit()!=unit||item.getPrice()!=price||item.getQuantity()!=quantity
                        ||item.getDiscount()!=discount||item.getStart()!=start||item.getEnd()!=end
                        ||item.getJudge()!=judge)
                    a=false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //判断输入的日期是否在打折期限内
    public boolean checkDiscount(Item item,Date date){
        boolean a=false;
        Date start;
        Date end;
        String select_check_discount="select start,end from item where name="+item.getName()+"";
        try {
            stmt=con.createStatement();
            rs=stmt.executeQuery(select_check_discount);
            while(rs.next()){
                start=rs.getDate("start");
                end=rs.getDate("end");
                if((compare_date(start,date)==-1||compare_date(start,date)==0)
                        &&(compare_date(end,date)==1||compare_date(start,date)==0)){
                    a=true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }
}
