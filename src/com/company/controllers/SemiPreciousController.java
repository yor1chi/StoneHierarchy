package com.company.controllers;

import com.company.entities.SemiPrecious;
import com.company.repositories.interfaces.ISemiPreciousRepo;

import java.util.List;

public class SemiPreciousController {
    private final ISemiPreciousRepo repo;
    public SemiPreciousController(ISemiPreciousRepo repo) {
        this.repo = repo;
    }
    public String addSemiPrecious(int weight, String name, boolean authenticity) {
        SemiPrecious semiPrecious = new SemiPrecious(weight, name, authenticity);
        boolean added = repo.addSemiPrecious(semiPrecious);
        return (added ? "Semi-precious stone was successfully added!" : "Addition was failed!");
    }
    public String getSemiPrecious(int id) {
        SemiPrecious semiPrecious = repo.getSemiPrecious(id);
        return (semiPrecious == null ? "Semi-precious stone wasn't found" : semiPrecious.toString());
    }
    public String getAllSemiPrecious() {
        List<SemiPrecious> semiPreciousList = repo.getAllSemiPrecious();
        return semiPreciousList.toString();
    }
    public String calculateCost(int id) {
        double weight = repo.calculateWeight(id);
        double cost = repo.calculateCost(id);
        return "Cost of this semi precious stone is " + cost + " for " + weight + " carat.";
    }
}