package org.webp;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BookEJB {

    @PersistenceContext
    private EntityManager em;

    public void createBook(Book book) {
        em.persist(book);
    }

    public Book findBookById(Long bookId) {
        return em.find(Book.class, bookId);
    }

    public void updateBook(Book book) {
        em.merge(book);
    }

    public void deleteBook(Long bookId) {
        Book book = em.find(Book.class, bookId);
        em.remove(book);
    }
}
