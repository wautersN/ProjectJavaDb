/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package populateDb;

import domein.Land;
import domein.Locatie;
import domein.Werelddeel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        GenericDaoJpa locatiedao = new GenericDaoJpa(Locatie.class);

        //WERELDDELEN
        Werelddeel afrika = new Werelddeel("Afrika");
        Werelddeel europa = new Werelddeel("Europa");
        Werelddeel azie = new Werelddeel("Azië");
        Werelddeel noordAmerika = new Werelddeel("Noord-Amerika");
        Werelddeel zuidAmerika = new Werelddeel("Zuid-Amerika");
        Werelddeel oceanie = new Werelddeel("Oceanië");
        Werelddeel antartica = new Werelddeel("Antartica");

        Set<Werelddeel> werelddelen = new HashSet<>(Arrays.asList(
                afrika, europa, azie, noordAmerika, zuidAmerika, oceanie, antartica
        ));

        //LANDEN Europa
        Land belgie = new Land("Belgie");
        Land andorra = new Land("Andorra");
        Land albanie = new Land("Albanie");
        Land oostenrijk = new Land("Oostenrijk");
        Land bulgarije = new Land("Bulgarije");
        
        Set<Land> landenEuropa;
        landenEuropa = new HashSet<Land>((Arrays.asList(
                belgie, andorra, albanie, oostenrijk, bulgarije) ));
    
        //LOCATIE
        Locatie ukkel = new Locatie("Ukkel");
     
        

        //TOEVOEGING VAN COLLECTIONS
        for(Land land:landenEuropa){
            land.setWerelddeel(europa);
        }
        
        /*tijdelijk moet lijst worden*/
           ukkel.setLand(belgie);


        //START INITIALIZE
        werelddeeldao.startTransaction();

      

        for (Land land : landenEuropa) {
            landdao.insert(land);
        }
        
          for (Werelddeel werelddeel : werelddelen) {
            werelddeeldao.insert(werelddeel);
        }
          
          locatiedao.insert(ukkel);

//      
        werelddeeldao.commitTransaction();

    }
}
