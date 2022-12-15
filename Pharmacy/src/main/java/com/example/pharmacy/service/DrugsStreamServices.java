package com.example.pharmacy.service;

import com.example.pharmacy.model.Drug;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DrugsStreamServices {
    public List<Drug> findByName(List<Drug> drugList, String name){
        var result =  drugList.stream().filter(x -> x.getName().contains(name)).toList();
        return result;
    }
    public List<Drug> sortByAscend(List<Drug> drugList){
        var result =  drugList.stream().sorted().collect(Collectors.toList());
        return result;
    }
    public List<Drug> sortByDescend(List<Drug> drugList){
        var result =  drugList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        return result;
    }



}
