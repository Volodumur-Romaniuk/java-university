package solution;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//pharmacy
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Drug drug1 = new Drug("Vaccine","Pfizer",9.99);
        Drug drug2 = new Drug("Vaccine","Pfizer",8.99);

        Seller sel1 = new Seller.SellerBuilder().position(Position.DURECTOR).birthday(LocalDate.now()).build();
        System.out.println(sel1.toString());
        List<Drug> drugs = new ArrayList<>(){{
            add(drug1);
            add(drug2);
        }};

        Order order1 = new Order.OrderBuilder().drugs(drugs).seller(sel1).build();
        System.out.println(order1.toString());
        List <Object> orderList = new ArrayList<>(){{
           add(order1);
        }};

//        XMLOrderSerialize objXml = new XMLOrderSerialize();
//        objXml.writeObject("order.xml", order1);
//        objXml.writeListObject("orders.xml", orderList);
//        System.out.println("read data with orders.xml "+"\n" +objXml.readListObject("orders.xml"));
        JSONOrderSerialize objJson = new JSONOrderSerialize();
        objJson.writeListObject("orders.json", orderList);
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("read data with order.json " + objJson.readObject("order.json"));
        System.out.println("\n");
        System.out.println("\n");
         System.out.println("read data with orders.json " + objJson.readListObject("orders.json"));

       TXTOrderSerialize objTxt = new TXTOrderSerialize();
       objTxt.writeObject("order.txt",order1);
        objTxt.writeListObject("orders.txt",orderList);
    }
}