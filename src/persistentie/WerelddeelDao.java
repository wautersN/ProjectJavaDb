package persistentie;

import domein.Werelddeel;
import javax.persistence.EntityNotFoundException;

public interface WerelddeelDao extends GenericDao<Werelddeel>  {
        public Werelddeel getWerelddeelByName(String name) throws EntityNotFoundException;   
}