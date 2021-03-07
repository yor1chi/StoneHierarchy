package com.company.controllers;

import com.company.entities.Precious;
import com.company.repositories.interfaces.IPreciousRepo;

import java.util.List;

public class PreciousController {
    private final IPreciousRepo repo;
    public PreciousController(IPreciousRepo repo) {
        this.repo = repo;
    }
    public String addPrecious (int weight, String name, boolean authenticity) {
        Precious precious = new Precious(weight, name, authenticity);
        boolean added = repo.addPrecious(precious);
        return (added ? "Precious stone was successfully added" : "Addition of stone is failed");
    }
    public String getPrecious(int id) {
        Precious precious = repo.getPrecious(id);
        return (precious == null ? "Precious stone wasn't found!" : precious.toString());
    }
    public String getAllPrecious() {
        List<Precious> preciousList = repo.getAllPrecious();
        return preciousList.toString();
    }
    public String calculateCost(int id) {
        double weight = repo.calculateWeight(id);
        double cost = repo.calculateCost(id);
        return "Cost of this precious stone is " + cost + " for " + weight + " carat.";
    }
}
