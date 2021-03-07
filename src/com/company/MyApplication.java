package com.company;

import com.company.controllers.PreciousController;
import com.company.controllers.SemiPreciousController;
import com.company.repositories.interfaces.IPreciousRepo;
import com.company.repositories.interfaces.ISemiPreciousRepo;

import java.util.Scanner;

public class MyApplication {
    private final PreciousController preciousController;
    private final Scanner scanner;
    private final SemiPreciousController semiPreciousController;
    public MyApplication(IPreciousRepo preciousRepo, ISemiPreciousRepo semiPreciousRepo) {
        preciousController = new PreciousController(preciousRepo);
        semiPreciousController = new SemiPreciousController(semiPreciousRepo);
        scanner = new Scanner(System.in);
    }
    public void start() {
        while(true) {
            System.out.println();
            System.out.println("Ore no app ni youkoso!");
            System.out.println("Select option:");
            System.out.println("1. Open menu of precious stones.");
            System.out.println("2. Open menu of semi-precious stones.");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter the option 0-2: ");
                int answer = scanner.nextInt();
                while(true) {
                    if (answer == 1) {
                        System.out.println();
                        System.out.println("Precious Stones Menu");
                        System.out.println("Select option:");
                        System.out.println("1. Get precious stone by its ID");
                        System.out.println("2. Get all precious stones in the database");
                        System.out.println("3. Add new precious stone to a database");
                        System.out.println("0. Return to the main menu");
                        try {
                            System.out.print("Enter the option 0-3: ");
                            int answer2 = scanner.nextInt();
                            if (answer2 == 1) {
                                getPreciousMenu();

                            }
                            else if (answer2 == 2) {
                                getAllPreciousMenu();
                            }
                            else if (answer2 == 3) {
                                addPreciousMenu();
                            }
                            else {
                                break;
                            }
                        }
                        catch (Exception e) {
                            System.out.println(e.getMessage());
                            scanner.next();
                        }
                    }
                    else if (answer == 2) {
                        System.out.println();
                        System.out.println("Semi-precious Stones Menu");
                        System.out.print("Select option: ");
                        System.out.println("1. Get semi-precious stone by its ID");
                        System.out.println("2. Get all semi-precious stones in the database");
                        System.out.println("3. Add new semi-precious stone to a database");
                        System.out.println("0. Return to the main menu");
                        try {
                            System.out.println("Enter the option 0-3");
                            int answer2 = scanner.nextInt();
                            if (answer2 == 1) {
                                getSemiPreciousMenu();
                            }
                            else if (answer2 == 2) {
                                getAllSemiPreciousMenu();
                            }
                            else if (answer2 == 3) {
                                addSemiPreciousMenu();
                            }
                            else {
                                break;
                            }
                        }
                        catch (Exception e) {
                            System.out.println(e.getMessage());
                            scanner.next();
                        }
                    }
                    else {
                        break;
                    }
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next();
            }
            System.out.println("***********************");
        }
    }
    public void addPreciousMenu() {
        System.out.print("Enter the name of your precious stone: ");
        String name = scanner.next();
        System.out.print("Enter the weight of precious stone: ");
        int weight = scanner.nextInt();
        System.out.print("Is your stone authentic? Enter either 'true' or 'false': ");
        boolean authenticity = scanner.nextBoolean();
        String answer = preciousController.addPrecious(weight, name, authenticity);
        System.out.println(answer);
    }
    public void getPreciousMenu() {
        System.out.print("Enter the ID of precious stone that you want: ");
        int id = scanner.nextInt();
        String answer = preciousController.getPrecious(id);
        System.out.println(answer);
        System.out.println("Want to add it to your necklace?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Select option: ");
        int option = scanner.nextInt();
        if (option == 1) {
            preciousController.calculateCost(id);
        }
    }
    public void getAllPreciousMenu() {
        String answer = preciousController.getAllPrecious();
        System.out.println(answer);
    }
    public void addSemiPreciousMenu() {
        System.out.print("Enter the name of your semi-precious stone: ");
        String name = scanner.nextLine();
        System.out.print("Enter the weight of precious stone: ");
        int weight = scanner.nextInt();
        System.out.print("Is your stone authentic? Enter either 'true' or 'false': ");
        boolean authenticity = scanner.nextBoolean();
        String answer = semiPreciousController.addSemiPrecious(weight, name, authenticity);
        System.out.println(answer);
    }
    public void getSemiPreciousMenu() {
        System.out.print("Enter the ID of precious stone that you want: ");
        int id = scanner.nextInt();
        String answer = semiPreciousController.getSemiPrecious(id);
        System.out.println(answer);
        System.out.println("Want to add it to your necklace?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Select option: ");
        int option = scanner.nextInt();
        if (option == 1) {
            semiPreciousController.calculateCost(id);
        }
    }
    public void getAllSemiPreciousMenu() {
        String answer = semiPreciousController.getAllSemiPrecious();
        System.out.println(answer);
    }
}
