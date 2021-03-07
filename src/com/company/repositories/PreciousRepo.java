package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Precious;
import com.company.repositories.interfaces.IPreciousRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreciousRepo implements IPreciousRepo {
    private final IDB db;
    public PreciousRepo(IDB db) {
        this.db = db;
    }
    @Override
    public boolean addPrecious(Precious precious) { //method of adding new data to DB
        try {
            Connection con = db.getConnection();
            String sql = "insert into precious(weight, name, authenticity) values(?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, precious.getWeight());
            st.setString(2, precious.getName());
            st.setBoolean(3, precious.isAuthenticity());
            boolean executed = st.execute();
            return executed;
        }
        catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Precious getPrecious(int id) { //method of getting exact data by its id
        try {
            Connection con = db.getConnection();
            String sql = "select * from precious where id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Precious precious = new Precious(rs.getInt("id"),
                        rs.getInt("weight"),
                        rs.getString("name"),
                        rs.getBoolean("authenticity"));
                con.close();
                return precious;
            }
        }
        catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Precious> getAllPrecious() { //method to get all data from table of precious stones
        try {
            Connection con = db.getConnection();
            String sql = "select* from precious";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Precious> preciousList = new ArrayList<>();
            while (rs.next()) {
                Precious precious = new Precious(rs.getInt("id"),
                        rs.getInt("weight"),
                        rs.getString("name"),
                        rs.getBoolean("authenticity"));
                preciousList.add(precious);
                con.close();
            }
            return preciousList;
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
            String sql = "select weight from precious where id = ?";
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
            String sql = "select weight, authenticity from precious where id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int weight = rs.getInt("weight");
                boolean authenticity = rs.getBoolean("authenticity");
                double carat = weight * 5; // calculate by 5 because 1 carat == 0.2 grams
                double cost = carat * 10000; //random number of cost for every carat
                if (authenticity == true) { //cost increases dramatically if stone is authentic
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
