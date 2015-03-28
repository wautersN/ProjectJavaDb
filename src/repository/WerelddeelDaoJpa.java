package repository;


import domein.Werelddeel;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;

public class WerelddeelDaoJpa extends GenericDaoJpa<Werelddeel> implements WerelddeelDao  {
    public WerelddeelDaoJpa() {
        super(Werelddeel.class);
    }

    @Override
    public Werelddeel getWerelddeelByName(String name) throws EntityNotFoundException {
        try {
            return em.createNamedQuery("Werelddeel.findByName", Werelddeel.class)
                 .setParameter("WerelddeelNaam", name)
                .getSingleResult();
        } catch (NoResultException ex) {
            throw new EntityNotFoundException();
        } 

    }
}
