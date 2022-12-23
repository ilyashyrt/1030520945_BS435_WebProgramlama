package org.webp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class WriterEJBTest {

    private WriterEJB writerEJB = new WriterEJB();

    @Test
    public void testCreateWriter() {
        Writer writer = new Writer();
        writer.setId(1L);
        writer.setName("Writer 1");
        writer.setPhoneNumber("123-456-7890");
        writer.setPublisherId(1L);
        writerEJB.createWriter(writer);
        Writer foundWriter = writerEJB.findWriterById(1L);
        assertEquals(writer, foundWriter);
    }

    @Test
    public void testUpdateWriter() {
        Writer writer = new Writer();
        writer.setId(1L);
        writer.setName("Writer 1");
        writer.setPhoneNumber("123-456-7890");
        writer.setPublisherId(1L);
        writerEJB.createWriter(writer);
        writer.setPhoneNumber("456-789-0123");
        writerEJB.updateWriter(writer);
        Writer foundWriter = writerEJB.findWriterById(1L);
        assertEquals("456-789-0123", foundWriter.getPhoneNumber());
    }

    @Test
    public void testDeleteWriter() {
        Writer writer = new Writer();
        writer.setId(1L);
        writer.setName("Writer 1");
        writer.setPhoneNumber("123-456-7890");
        writer.setPublisherId(1L);
        writerEJB.createWriter(writer);
        writerEJB.deleteWriter(1L);
        Writer foundWriter = writerEJB.findWriterById(1L);
        assertNull(foundWriter);
    }
}
