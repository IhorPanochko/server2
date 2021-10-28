package com.example.server2.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.ElementCollection;
import java.util.List;

@Document(collection = "groups")
public class Groups {
    @Id
    private String id;

    private String name;

    @ElementCollection
    private List<UserGroupDto> userGroupDtos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserGroupDto> getUserGroupDtos() {
        return userGroupDtos;
    }

    public void setUserGroupDtos(List<UserGroupDto> userGroupDtos) {
        this.userGroupDtos = userGroupDtos;
    }
}
