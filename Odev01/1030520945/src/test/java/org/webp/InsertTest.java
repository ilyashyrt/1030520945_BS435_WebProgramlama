package org.webp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InsertTest {

    private EntityManagerFactory factory;
    private EntityManager em;

    @BeforeEach
    public void init() {
        //her bir test calismadan once BeforeEach calistirilir
        factory = Persistence.createEntityManagerFactory("Hibernate");
        em = factory.createEntityManager();
    }

    @AfterEach
    public void tearDown() {
        //her bir test calistiktan sonra BeforeEach calistirilir

        em.close();
        factory.close();
    }

    private boolean persistInATransaction(Object obj) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            em.persist(obj);
            tx.commit();
        } catch (Exception e) {
            System.out.println("FAILED TRANSACTION: " + e.toString());
            tx.rollback();
            return false;
        }

        return true;
    }


    @Test
    public void insertBook() {

        Book book = new Book();
        book.setBookId(1L);
        book.setPrice(100);
        book.setName("Kürk Mantolu Madonna");
        book.setCategory("Aşk");
        book.setWriterID(2L);

        boolean persisted = persistInATransaction(book);
        assertTrue(persisted);
    }

    @Test
    public void insertWriter() {

        Writer writer = new Writer();
        writer.setId(2L);
        writer.setName("İlyas");
        writer.setPhoneNumber("05555555555");
        writer.setPublisherId(2L);

        boolean persisted = persistInATransaction(writer);
        assertTrue(persisted);
    }

    @Test
    public void insertPublisher() {

        Publisher publisher = new Publisher();
        publisher.setPublisherId(2L);
        publisher.setName("Kültür Yayınları");
        publisher.setAddress("Çicek Sokak");
        publisher.setPhoneNumber("05555555555");

        boolean persisted = persistInATransaction(publisher);
        assertTrue(persisted);
    }

}
