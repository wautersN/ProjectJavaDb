package ui;

import domein.DomeinController;
import java.util.Scanner;
import persistentie.GenericDaoJpa;

public class ConsoleUi {
    private final DomeinController domeinController;
    private final Scanner in = new Scanner(System.in);
    public ConsoleUi(DomeinController dc) {
       domeinController = dc;
    }

    public void run() {
        doStandardJob();
        domeinController.close();
    }

    private void doStandardJob() {
        System.out.println("Actief");
       
        System.out.println("gelukt");
       
    }
    
}
