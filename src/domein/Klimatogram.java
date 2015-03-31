
package domein;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Klimatogrammen")
public class Klimatogram{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int klimatogramId;
    
//    @ManyToOne
//    private Collection<Waarneming> waarnemingen;
    
    private String stationNaam;
        
    private double breedteGraad,lengteGraad;
    private Parameter Nj,Tj;
    private Date startJaar,eindJaar;
   
}
