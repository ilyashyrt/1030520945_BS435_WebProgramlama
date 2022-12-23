package org.webp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PublisherEJBTest {

    private PublisherEJB publisherEJB = new PublisherEJB();

    @Test
    public void testCreatePublisher() {
        Publisher publisher = new Publisher();
        publisher.setPublisherId(1L);
        publisher.setName("Publisher 1");
        publisher.setPhoneNumber("123-456-7890");
        publisher.setAddress("123 Main Street");
        publisherEJB.createPublisher(publisher);
        Publisher foundPublisher = publisherEJB.findPublisherById(1L);
        assertEquals(publisher, foundPublisher);
    }

    @Test
    public void testUpdatePublisher() {
        Publisher publisher = new Publisher();
        publisher.setPublisherId(1L);
        publisher.setName("Publisher 1");
        publisher.setPhoneNumber("123-456-7890");
        publisher.setAddress("123 Main Street");
        publisherEJB.createPublisher(publisher);
        publisher.setAddress("456 Main Street");
        publisherEJB.updatePublisher(publisher);
        Publisher foundPublisher = publisherEJB.findPublisherById(1L);
        assertEquals("456 Main Street", foundPublisher.getAddress());
    }

    public void testDeletePublisher() {
        Publisher publisher = new Publisher();
        publisher.setPublisherId(1L);
        publisher.setName("Publisher 1");
        publisher.setPhoneNumber("123-456-7890");
        publisher.setAddress("123 Main Street");
        publisherEJB.createPublisher(publisher);
        publisherEJB.deletePublisher(1L);
        Publisher foundPublisher = publisherEJB.findPublisherById(1L);
        assertNull(foundPublisher);
    }
}
