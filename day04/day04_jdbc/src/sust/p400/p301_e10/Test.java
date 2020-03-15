package sust.p400.p301_e10;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Pattern;
class Book  {
    private  String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 &&
                title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    private  double price;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
       Map<String,Integer> map = new HashMap<String, Integer>();
       map.put("y",1);
       map.put("e",2);
       map.put("s",3);
       map.put("w",5);

       Set<Map.Entry<String,Integer>> set1= map.entrySet();
       Iterator iter = set1.iterator();
       while(iter.hasNext()) {
           System.out.println(iter.next());
       }



        List<Book>all =new  ArrayList<Book>();
        all.add(new Book("java",33.3));
        all.add(new Book("java1",33.4));
        all.add(new Book("java2",33.5));
        all.add(new Book("java3",33.4));
        all.remove(new Book("java",33.3));
        ListIterator<Book>iter1 = all.listIterator();
        while (iter.hasNext()) {
            System.out.println(iter1.next());
        }
        System.out.println(all);
        System.out.println(all.contains(new Book("java2",33.5)));

        Set<String> set = new TreeSet<String>();
        set.add("A");
        set.add("b");



        Scanner input =  new Scanner(new FileInputStream(new File("E:"+File.separator+"my.txt")));
        Scanner input1 = new Scanner(System.in);
        input1.useDelimiter("\n");
        if(input1.hasNext()) {
            System.out.println(input1.next());
        }
        input.useDelimiter("\n");
        while(input.hasNext()) {
            System.out.println(input.next());
        }


        input.close();


        System.out.println(input.hasNext());
        System.out.println(input.nextInt());
        Class <?> cls = Class.forName("sust.p400.p301_e10.Book");
        Constructor <?>con = cls.getConstructor(int.class,int.class);
        Object obj = con.newInstance(1,2);
        System.out.println(obj);
        Method setmth = cls.getMethod("fun",String.class);
        Method getmth = cls.getMethod("fun", String.class);
        setmth.invoke(obj,"haha");
        System.out.println(getmth.invoke(obj));
      //  Object obj = cls.newInstance();


        long cur0 =System.currentTimeMillis();
        StringBuffer buf = new StringBuffer("nihao");
        buf.append("hah");
      //  System.out.println(buf.reverse());
        System.out.println(buf.delete(1,3));

        Runtime run = Runtime.getRuntime();
        System.out.println(run.maxMemory());
        System.out.println(run.totalMemory());
        System.out.println(run.freeMemory());

        Process pro = run.exec("mspaint.exe");
       pro.destroy();
        BigInteger big1 = new BigInteger("231321434");
        BigInteger big2 = new BigInteger("3213");
        System.out.println(big1.add(big2));
        System.out.println(big1.subtract(big2));
        System.out.println(big1.multiply(big2));
        System.out.println(big1.divide(big2));

        BigInteger result[] = big1.divideAndRemainder(big2);
        System.out.println("商" +result[0]+"余数"+result[1]);

        System.out.println(new BigDecimal(34).divide(new BigDecimal(1),1,BigDecimal.ROUND_HALF_UP).doubleValue());

        long cur =System.currentTimeMillis();
        Date date = new Date(cur-cur0);

        Calendar cal = Calendar.getInstance();
        StringBuffer buf1 = new StringBuffer();
        buf1.append(cal.get(Calendar.YEAR)).append("年");
        System.out.println(buf1);
        Pattern pt = Pattern.compile(new String("\\d+"));
        String result1 []= pt.split(new String("aa2cc44bb2c"));
        for (String str:result1) {
            System.out.println(str);
        }
        System.out.println(Arrays.toString(result1));

        System.out.println(date);
    }
}