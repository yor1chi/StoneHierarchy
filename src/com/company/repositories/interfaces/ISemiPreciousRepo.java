package com.company.repositories.interfaces;
import com.company.entities.SemiPrecious;

import java.util.List;

public interface ISemiPreciousRepo {
        boolean addSemiPrecious(SemiPrecious semiPrecious);
        SemiPrecious getSemiPrecious(int id);
        List<SemiPrecious> getAllSemiPrecious();
        double calculateWeight(int id);
        double calculateCost(int id);
}
