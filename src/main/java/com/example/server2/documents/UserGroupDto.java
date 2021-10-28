package com.example.server2.documents;

import javax.persistence.Embeddable;

@Embeddable
public class UserGroupDto {

    private String id;

    private Long zip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getZip() {
        return zip;
    }

    public void setZip(Long zip) {
        this.zip = zip;
    }
}
