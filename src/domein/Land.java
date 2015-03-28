package domein;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Landen")
public class Land implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int landId;
    
    private String landNaam;
    
    @ManyToOne
    private Werelddeel werelddeel;

    public Werelddeel getWerelddeel() {
        return werelddeel;
    }

    public void setWerelddeel(Werelddeel werelddeel) {
        this.werelddeel = werelddeel;
    }
    
    
//    @ManyToOne
//    private Collection<Locatie> locaties;
    
    protected Land(){}
    
    public Land(String landNaam){
        setLandNaam(landNaam);
    }

    public int getLandId() {
        return landId;
    }

    public void setLandId(int landId) {
        this.landId = landId;
    }

    public String getLandNaam() {
        return landNaam;
    }

    public void setLandNaam(String landNaam) {
        this.landNaam = landNaam;
    }

//    public Collection<Locatie> getLocaties() {
//        return locaties;
//    }
//
//    public void setLocaties(Collection<Locatie> locaties) {
//        this.locaties = locaties;
//    }    
}