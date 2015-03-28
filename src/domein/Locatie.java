package domein;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Locaties")
public class Locatie implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locatieId;
    
    private String locatieNaam;
    
    @ManyToOne
    private Land land;

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }
    
//    @OneToOne
//    private Klimatogram klimatogram;
    
    protected Locatie(){}
    
    public Locatie(String locatieNaam){
        setLocatieNaam(locatieNaam);
    }

    public int getLocatieId() {
        return locatieId;
    }

    public void setLocatieId(int locatieId) {
        this.locatieId = locatieId;
    }

    public String getLocatieNaam() {
        return locatieNaam;
    }

    public void setLocatieNaam(String locatieNaam) {
        this.locatieNaam = locatieNaam;
    }

//    public Klimatogram getKlimatogram() {
//        return klimatogram;
//    }
//
//    public void setKlimatogram(Klimatogram klimatogram) {
//        this.klimatogram = klimatogram;
//    }
}