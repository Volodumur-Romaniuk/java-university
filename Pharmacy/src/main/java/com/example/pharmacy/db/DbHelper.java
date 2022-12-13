package com.example.pharmacy.db;

import java.sql.Connection;
import java.sql.SQLException;

public class DbHelper {
    private final static String CREATE_DRUGS_TABLE = "name varchar(40) not null, manufacter varchar(40), price double";
    private final static String CREATE_ORDER_TABLE = "idSeller string";

    private static void createTable(String tableName, String createTableDetails){
        try (Connection conn = Connector.getConnection();
             var statement = conn.createStatement();) {
            String sql = "CREATE TABLE " + tableName +
                    "(id varchar(50) default(uuid()) PRIMARY KEY, " +
                    createTableDetails + ")";
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void createAllTables(){
        createTable("Drugs", CREATE_DRUGS_TABLE);
        createTable("Order", CREATE_ORDER_TABLE);
    }

    private static void deleteTable(String tableName){
        try (Connection conn = Connector.getConnection();
             var statement = conn.createStatement();) {
            statement.executeUpdate("DROP TABLE " + tableName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void dropAllTables(){
        deleteTable("Persons");
        deleteTable("Clients");
        deleteTable("Coaches");
        deleteTable("TypeOfTrainings");
    }
}
