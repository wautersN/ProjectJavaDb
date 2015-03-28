/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.DomeinController;

/**
 *
 * @author Asus Wauters Niels
 */
public class StartUp {
       public static void main(String [] arg) {
        new StartUp().run();
    }

    private void run() {
        new ConsoleUi(new DomeinController()).run();
        //new ConsoleUi(new DomeinController(false)).run(); //zonder DB populate
    }
}
