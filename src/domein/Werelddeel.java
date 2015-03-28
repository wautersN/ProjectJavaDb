package domein;



import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Werelddelen")
public class Werelddeel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int werelddeelId;

    private String werelddeelNaam;
    
  //  @ManyToOne
  //  private Collection<Land> landen;
    
    protected Werelddeel(){}
    
    public Werelddeel(String werelddeelNaam){
        setWerelddeelNaam(werelddeelNaam);
    }

    

    public int getWerelddeelId() {
        return werelddeelId;
    }

    public void setWerelddeelId(int werelddeelId) {
        this.werelddeelId = werelddeelId;
    }

    public String getWerelddeelNaam() {
        return werelddeelNaam;
    }

    public void setWerelddeelNaam(String werelddeelNaam) {
        this.werelddeelNaam = werelddeelNaam;
    }

//    public Collection<Land> getLanden() {
//        return landen;
//    }
//
//    public void setLanden(Collection<Land> landen) {
//        this.landen = landen;
//    }  
}
