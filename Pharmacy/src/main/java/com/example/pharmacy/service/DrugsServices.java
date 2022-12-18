package com.example.pharmacy.service;

import com.example.pharmacy.model.Drug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DrugsServices {
    public List<Drug> searchByName(List<Drug> drugs, String name) {
        var resList = new ArrayList<Drug>();
        var searchText = name.trim();
        for (var drug : drugs) {
            if (drug.getName().contains(searchText)) {
                resList.add(drug);
            }
        }
        return resList;
    }

    public List<Drug> sortDrugAscend(List<Drug> drugs) {
        Collections.sort(drugs, new SortByName());
        return drugs;
    }

    public List<Drug> sortDrugDescend(List<Drug> drugs) {
        Collections.sort(drugs, new SortByName());
        Collections.reverse(drugs);
        return drugs;
    }
}
