package test.domains; 

import domains.Item;
import domains.ReadList;
import junit.framework.Test;
import junit.framework.TestSuite; 
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/** 
* ReadList Tester. 
* 
* @author <Enssie>
* @since <pre>01/04/2015</pre> 
* @version 1.0 
*/ 
public class ReadListTest extends TestCase {
   private File file1;
   private File file2;
   @Before
   public void setUp() throws Exception {
      file1 = new File("./sampleFileInput.json");
      file2 = new File("./sampleListInput.json");
   }

   @After
   public void tearDown() throws Exception {
      if(file1.exists()){
         file1.delete();
      }
      if(file2.exists()){
         file2.delete();
      }
   }
   public void ReadTest() throws Exception{
      PrintWriter printWriter1 = new PrintWriter(file1);
      PrintWriter printWriter2 = new PrintWriter(file2);
      String sampleFileInput = new StringBuilder()
              .append("{\n")
              .append("'ITEM000004':\n")
              .append("{\n")
              .append("\"name\": '洗发液',\n")
              .append("\"unit\": '瓶',\n")
              .append("\"price\": 40.00,\n")
              .append("\"discount\": 0.8\n")
              .append("}\n")
              .append("}")
              .toString();
      printWriter1.write(sampleFileInput);
      printWriter1.close();

      String sampleListInput = new StringBuilder()
              .append("[\n")
              .append("'ITEM000004',\n")
              .append("]")
              .toString();
      printWriter2.write(sampleListInput);
      printWriter2.close();

       ReadList readList = new ReadList(file1,file2);
       ArrayList<Item> items = readList.parser().getItems();
       assertThat(items.size(), is(1));
       Item item = items.get(0);
       assertThat(item.getName(), is("洗发液"));
       assertThat(item.getBarCode(), is("ITEM000004"));
       assertThat(item.getUnit(), is("瓶"));
       assertThat(item.getPrice(), is(40.00));
       assertThat(item.getDiscount(), is(0.8));
   }
/** 
* 
* Method: parser() 
* 
*/ 
   public void testParser() throws Exception {
//TODO: Test goes here... 
   }


/** 
* 
* Method: BuildShoppingChart(Map<String,Item> maps) 
* 
*/ 
public void testBuildShoppingChart() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = ReadList.getClass().getMethod("BuildShoppingChart", Map<String,Item>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: getListOfGoods() 
* 
*/ 
public void testGetListOfGoods() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = ReadList.getClass().getMethod("getListOfGoods"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 


public static Test suite() { 
return new TestSuite(ReadListTest.class); 
} 
} 
