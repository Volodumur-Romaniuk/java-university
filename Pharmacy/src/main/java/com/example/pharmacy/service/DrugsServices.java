package com.example.pharmacy.service;

import com.example.pharmacy.model.Drug;

import java.util.List;

public class DrugsServices {
    public List<Drug> findByName(List<Drug> drugList, String name){
        var result =  drugList.stream().filter(x -> x.getName().contains(name)).toList();
        return result;
    }

}
