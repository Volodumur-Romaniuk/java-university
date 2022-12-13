package com.example.pharmacy.CRUD;

import com.example.pharmacy.db.Connector;
import jakarta.validation.ValidationException;
import com.example.pharmacy.model.Drug;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CRUDDrugs {
    private static final String DRUG_TABLE = "Drugs";
   private static final String GET_ALL = "SELECT * FROM " + DRUG_TABLE;
        public List<Drug> getAll(){
            var drugList = new ArrayList<Drug>();
            try(Connection connection = Connector.getConnection()){
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(GET_ALL);
                while(rs.next()){
                    var drug = new Drug.DrugBuilder()
                            .id((rs.getString("id")))
                            .name(rs.getString("name"))
                            .manufacturer(rs.getString("manufacter"))
                            .price(Double.parseDouble(rs.getString("price")))
                            .build();
                    drugList.add(drug);
                }
            } catch (SQLException | ValidationException e){
                e.printStackTrace();
            }
            return drugList;
        }
    public Drug insertDrug(Drug drug){
        var id = UUID.randomUUID();
        String ADD_NEW_DRUG = "INSERT INTO Drugs (id, name, manufacter, price) " +"values(?,?,?,?)";

        try(Connection connection = Connector.getConnection();
           var statementDrug = connection.prepareStatement(ADD_NEW_DRUG);) {
            statementDrug.setString(1, id.toString());
            statementDrug.setString(2, drug.getName());
            statementDrug.setString(3, drug.getManufacturer());
            statementDrug.setString(4, drug.getPrice().toString());
            statementDrug.executeUpdate();

        }catch (SQLException throwable){
            throwable.printStackTrace();
            drug = null;
        }
        return drug;
    }

}
