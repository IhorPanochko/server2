package com.example.server2.dto;

public class LocationDto {

    private String id;

    private String city;

    private Long zip;

    public LocationDto() {
    }

    public LocationDto(String id, String city, Long zip) {
        this.id = id;
        this.city = city;
        this.zip = zip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getZip() {
        return zip;
    }

    public void setZip(Long zip) {
        this.zip = zip;
    }
}
