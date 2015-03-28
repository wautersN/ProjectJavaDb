/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package populateDb;

import domein.Land;
import domein.Werelddeel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import repository.GenericDaoJpa;
import repository.WerelddeelDaoJpa;

/**
 *
 * @author Asus Wauters Niels
 */
public class DbInitializer {

    public void run() {

        //        WerelddeelDaoJpa werelddeeldao = new WerelddeelDaoJpa();
        //INITIALIZEREN VAN DE DAO'S
        GenericDaoJpa werelddeeldao = new GenericDaoJpa(Werelddeel.class);
        GenericDaoJpa landdao = new GenericDaoJpa(Land.class);

        //WERELDDELEN
        Werelddeel afrika = new Werelddeel("Afrika");
        Werelddeel europa = new Werelddeel("Europa");

        //LANDEN
        Land belgie = new Land("Belgie");

        //COLLECTIONS
        Collection<Werelddeel> werelddelen = new ArrayList<>(Arrays.asList(afrika,europa));
        Collection<Land> landenEuropa = new ArrayList<>(Arrays.asList(belgie));

        //TOEVOEGING VAN COLLECTIONS
        europa.setLanden(landenEuropa);

        //START INITIALIZE
        werelddeeldao.startTransaction();


        for(Werelddeel werelddeel:werelddelen){
            werelddeeldao.insert(werelddeel);
        }

        for (Land land : landenEuropa) {
            landdao.insert(land);
        }

//      
        werelddeeldao.commitTransaction();

    }
}
