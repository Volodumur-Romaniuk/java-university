package com.example.pharmacy.service;

import com.example.pharmacy.model.Drug;

import java.util.Comparator;

public class SortByName implements Comparator<Drug> {
    @Override
    public int compare(Drug o1, Drug o2) {
        return o1.getPrice().compareTo((o2.getPrice()));
    }
}
