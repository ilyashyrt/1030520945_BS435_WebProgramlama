package org.webp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Table(name = "Writer")
@Entity
public class Writer {

    @Id
    @NotNull
    private Long writerId;

    @Column(name = "writer_name")
    private String writerName;


    @Column(name = "writer_phone_number")
    private String phoneNumber;

    @Column(name = "publisher_id")
    private Long publisherId;

    public Writer(){}

    public Long getId() {
        return writerId;
    }

    public void setId(Long writerId) {
        this.writerId = writerId;
    }

    public String getName() {
        return writerName;
    }

    public void setName(String writerName) {
        this.writerName = writerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }
}

