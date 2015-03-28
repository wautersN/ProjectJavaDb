/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package populateDb;

import domein.Werelddeel;
import repository.WerelddeelDaoJpa;

/**
 *
 * @author Asus Wauters Niels
 */
public class DbInitializer {
     public void run() {
       WerelddeelDaoJpa werelddeeldao = new WerelddeelDaoJpa();
        werelddeeldao.startTransaction();
        werelddeeldao.insert(new Werelddeel("Afrika"));
          werelddeeldao.insert(new Werelddeel("Europa"));
              werelddeeldao.insert(new Werelddeel("Azie"));
//        GenericDaoJpa winkeldao = new GenericDaoJpa(Winkel.class);
//        winkeldao.insert(new Winkel("Putteke"));
//        winkeldao.insert(new Winkel("Op den hoek"));
        werelddeeldao.commitTransaction();
    }
}
