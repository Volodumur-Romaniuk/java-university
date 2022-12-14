package com.example.pharmacy;


import com.example.pharmacy.CRUD.CRUDDrugs;
import com.example.pharmacy.model.Drug;
import com.example.pharmacy.model.Order;
import com.example.pharmacy.model.Position;
import com.example.pharmacy.model.Seller;
import com.example.pharmacy.serialize.TXTOrderSerialize;
import com.example.pharmacy.serialize.XMLOrderSerialize;
import com.example.pharmacy.service.DrugsServices;
import com.example.pharmacy.service.SortByName;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Drug drug1 = new Drug("Vaccine","Pfizer",9.99);
        Drug drug2 = new Drug("AAAAAa","Pfizer",8.99);

        Seller sel1 = new Seller.SellerBuilder().position(Position.DURECTOR).salary(2).birthday(LocalDate.now()).build();
        System.out.println(sel1.toString());
        var drugs = new ArrayList<Drug>();
        drugs.add(drug1);
        drugs.add(drug2);

        System.out.println(drugs);
        Collections.sort(drugs);

        System.out.println(drugs);

        SortByName sortByName = new SortByName();
        Collections.sort(drugs,sortByName);
        System.out.println("Sort By Name :"+drugs);
        for (Drug d: drugs){
            System.out.println(d.toString());
        }
        Order order1 = new Order.OrderBuilder().drugs(drugs).seller(sel1).build();
        System.out.println(order1.toString());
        List<Order> orderList = new ArrayList<>(){{
            add(order1);
            add(order1);
        }};

        XMLOrderSerialize objXml = new XMLOrderSerialize();
//        objXml.writeObject("order.xml", order1);
//        objXml.writeListObject("orders.xml", orderList);
//        System.out.println("read data with orders.xml "+"\n" +objXml.readListObject("orders.xml"));
//        JSONOrderSerialize objJson = new JSONOrderSerialize();
//        objJson.writeListObject("orders.json", orderList);
//        System.out.println("\n");
//        System.out.println("\n");
//        System.out.println("read data with order.json " + objJson.readObject("order.json"));
//        System.out.println("\n");
//        System.out.println("\n");
//        System.out.println("read data with orders.json " + objJson.readListObject("orders.json"));

        TXTOrderSerialize objTxt = new TXTOrderSerialize();
        objTxt.writeObject("order.txt",order1);
        objTxt.writeListObject("orders.txt",orderList);
        DrugsServices filterName = new DrugsServices();
        var res = filterName.findByName(drugs,"a");
        System.out.println(res);
        var crudDrugs = new CRUDDrugs();
        Drug drug = new Drug("Ibuprofen","Farmak",5.0);
        crudDrugs.insertDrug(drug) ;
        System.out.println("getAll" + crudDrugs.getAll());
    }
}

