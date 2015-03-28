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

/**
 *
 * @author Asus Wauters Niels
 */
public class DbInitializer {

    public void run() {

        /*##########################################
         Andere manier van initializer staat hier onder 
         --> wordt gebruikt voor zelfgemaakte mapper die erft van GenericDao
         WerelddeelDaoJpa werelddeeldao = new WerelddeelDaoJpa();
         ############################################*/
        //INITIALIZEREN VAN DE DAO'S
        GenericDaoJpa werelddeeldao = new GenericDaoJpa(Werelddeel.class);
        GenericDaoJpa landdao = new GenericDaoJpa(Land.class);

        //WERELDDELEN
        Werelddeel afrika = new Werelddeel("Afrika");
        Werelddeel europa = new Werelddeel("Europa");
        Werelddeel azie = new Werelddeel("Azië");
        Werelddeel noordAmerika = new Werelddeel("Noord-Amerika");
        Werelddeel zuidAmerika = new Werelddeel("Zuid-Amerika");
        Werelddeel oceanie = new Werelddeel("Oceanië");
        Werelddeel antartica = new Werelddeel("Antartica");

        Collection<Werelddeel> werelddelen = new ArrayList<>(Arrays.asList(
                afrika, europa, azie, noordAmerika, zuidAmerika, oceanie, antartica
        ));

        //LANDEN Europa
        Land belgie = new Land("Belgie");
        Land andorra = new Land("Andorra");
        Land albanie = new Land("Albanie");
        Land oostenrijk = new Land("Oostenrijk");
        Land bulgarije = new Land("Bulgarije");
        Collection<Land> landenEuropa = new ArrayList<>(Arrays.asList(
                belgie, andorra, albanie, oostenrijk, bulgarije
        ));

        //TOEVOEGING VAN COLLECTIONS
        europa.setLanden(landenEuropa);

        //START INITIALIZE
        werelddeeldao.startTransaction();

        for (Werelddeel werelddeel : werelddelen) {
            werelddeeldao.insert(werelddeel);
        }

        for (Land land : landenEuropa) {
            landdao.insert(land);
        }

//      
        werelddeeldao.commitTransaction();

    }
}
