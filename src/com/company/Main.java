package com.company;

import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.PreciousRepo;
import com.company.repositories.SemiPreciousRepo;
import com.company.repositories.interfaces.IPreciousRepo;
import com.company.repositories.interfaces.ISemiPreciousRepo;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IPreciousRepo preciousRepo = new PreciousRepo(db);
        ISemiPreciousRepo semiPreciousRepo = new SemiPreciousRepo(db);
        MyApplication app = new MyApplication(preciousRepo, semiPreciousRepo);
        app.start();
    }
}
