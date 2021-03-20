package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
    List<String> getBrands(String request) {
        List<String> brands = new ArrayList<>();

        switch (request){
            case "baltika" :
                brands.add("graviy");
                brands.add("graviy");
                break;
            case "kozel":
                brands.add("ovca");
                break;
        }

        return brands;
    }
}
