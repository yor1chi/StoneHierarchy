package com.company.repositories.interfaces;

import com.company.entities.Precious;

import java.util.List;

public interface IPreciousRepo {
    boolean addPrecious(Precious precious);
    Precious getPrecious(int id);
    List<Precious> getAllPrecious();
    double calculateWeight(int id);
    double calculateCost(int id);
}
