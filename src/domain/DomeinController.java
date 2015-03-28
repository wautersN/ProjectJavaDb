package domain;

import domein.Werelddeel;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import populateDb.DbInitializer;
import repository.GenericDaoJpa;
import repository.WerelddeelDaoJpa;


public class DomeinController {
    private List<Werelddeel> werelddeelList;
//    private GenericDaoJpa<Winkel> winkelRepo;
    private WerelddeelDaoJpa  bierRepo;
    
    public DomeinController() {
        this(true);
    }
    
    public DomeinController(boolean withInit) {
        if (withInit) {
            new DbInitializer().run();
        }
       // winkelRepo = new GenericDaoJpa<>(Winkel.class);
        bierRepo = new WerelddeelDaoJpa();
    }
//    public void setWinkelRepo(GenericDaoJpa<Winkel> mock){
//        winkelRepo = mock;
//    }
//    public void setBierRepo(BierDaoJpa mock){
//        bierRepo = mock;
//    }
 
//    public List<String> geefWinkelList(){
//        return getWinkelList().stream().map(Winkel::getNaam).collect(Collectors.toList());
//    }
//    
//    private List<Winkel> getWinkelList(){
//        if (winkelList==null){
//            winkelList=winkelRepo.findAll();
//        }
//        return winkelList;
//    }
//    
//    public void voegBierBijWinkel(String bierNaam, String winkelNaam) throws IllegalArgumentException {
//        Optional<Winkel> winkel = getWinkelList().stream()
//                .filter( w -> w.getNaam().equalsIgnoreCase(winkelNaam))
//                .findFirst();
//        if (!winkel.isPresent()) {
//                throw new IllegalArgumentException("winkel " + winkelNaam + " komt niet voor");
//        }
//        Bier bier;
//        try {
//             bier = bierRepo.getBierByName(bierNaam);
//        } catch(EntityNotFoundException ex) {
//            throw new IllegalArgumentException("bier " + bierNaam + " komt niet voor");
//        }
//        GenericDaoJpa.startTransaction();
//        winkel.get().addBier(bier);
//        GenericDaoJpa.commitTransaction();
//    }
//    
//    public List<String> geefBierLijst(Winkel winkel) {
//        Set<Bier> bierSet = winkel.getBierSet();
//        return bierSet.stream().map(Bier::toString).collect(Collectors.toList());
//    }

    public void close() {
        GenericDaoJpa.closePersistency();
    }
    
}
