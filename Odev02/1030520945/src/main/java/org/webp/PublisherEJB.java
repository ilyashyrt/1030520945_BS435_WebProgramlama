package org.webp;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PublisherEJB {

    @PersistenceContext
    private EntityManager em;

    public void createPublisher(Publisher publisher) {
        em.persist(publisher);
    }

    public Publisher findPublisherById(Long publisherId) {
        return em.find(Publisher.class, publisherId);
    }

    public void updatePublisher(Publisher publisher) {
        em.merge(publisher);
    }

    public void deletePublisher(Long publisherId) {
        Publisher publisher = em.find(Publisher.class, publisherId);
        em.remove(publisher);
    }
}
