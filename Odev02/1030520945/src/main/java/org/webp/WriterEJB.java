package org.webp;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class WriterEJB {

    @PersistenceContext
    private EntityManager em;

    public void createWriter(Writer writer) {
        em.persist(writer);
    }

    public Writer findWriterById(Long writerId) {
        return em.find(Writer.class, writerId);
    }

    public void updateWriter(Writer writer) {
        em.merge(writer);
    }

    public void deleteWriter(Long writerId) {
        Writer writer = em.find(Writer.class, writerId);
        em.remove(writer);
    }
}
