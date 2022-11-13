package org.webp;

import javax.persistence.*;

@Table(name = "Publisher")
@Entity
public class Publisher {
    @Id
    @Column(name = "publisher_ıd", nullable = false)
    private Long publisherId;

    @Column(name = "publisher_name")
    private String name;

    @Column(name = "publisher_phone_number")
    private String phoneNumber;

    @Column(name = "publisher_address")
    private String address;

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
