package com.company.repositories;
import com.company.data.interfaces.IDB;
import com.company.entities.SemiPrecious;
import com.company.repositories.interfaces.ISemiPreciousRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SemiPreciousRepo implements ISemiPreciousRepo {
    private final IDB db;
    public SemiPreciousRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean addSemiPrecious(SemiPrecious semiPrecious) { //method of creating new instance in the table of semi precious stones
        try {
            Connection con = db.getConnection();
            String sql = "insert into semi_precious(weight, name, authenticity) values(?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, semiPrecious.getWeight());
            st.setString(2, semiPrecious.getName());
            st.setBoolean(3, semiPrecious.isAuthenticity());
            boolean executed = st.execute();
            return executed;
        }
        catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public SemiPrecious getSemiPrecious(int id) { //method of accessing exact stone by its id
        try {
            Connection con = db.getConnection();
            String sql = "select * from semi_precious where id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                SemiPrecious semiPrecious = new SemiPrecious(rs.getInt("id"),
                        rs.getInt("weight"),
                        rs.getString("name"),
                        rs.getBoolean("authenticity"));
                con.close();
                return semiPrecious;
            }
        }
        catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SemiPrecious> getAllSemiPrecious() { //method of getting every data of table of semi precious stones
        try {
            Connection con = db.getConnection();
            String sql = "select * from semi_precious";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<SemiPrecious> semiPreciousList = new ArrayList<>();
            while (rs.next()) {
                SemiPrecious semiPrecious = new SemiPrecious(rs.getInt("id"),
                        rs.getInt("weight"),
                        rs.getString("name"),
                        rs.getBoolean("authenticity"));
                semiPreciousList.add(semiPrecious);
                con.close();
            }
            return semiPreciousList;
        }
        catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    @Override
    public double calculateWeight(int id) {
        try {
            Connection con = db.getConnection();
            String sql = "select weight from semi_precious where id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int weight = rs.getInt("weight");
                con.close();
                return weight * 5; // calculate by 5 because 1 carat == 0.2 grams
            }
        }
        catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        return 0;
    }

    @Override
    public double calculateCost(int id) {
        try {
            Connection con = db.getConnection();
            String sql = "select weight, authenticity from semi_precious where id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int weight = rs.getInt("weight");
                boolean authenticity = rs.getBoolean("authenticity");
                double carat = weight * 5; // calculate by 5 because 1 carat == 0.2 grams
                double cost = carat * 5000; //random number of cost for semi precious stone per carat
                if (authenticity == true) { //cost raises significantly if stone is authentic
                    cost*=3;
                }
                con.close();
                return cost;
            }
        }
        catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        return 0;
    }
}
