package dk.hgigym.model;

import javax.persistence.*;

@Entity
public class UserRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Request request;
    private Boolean isRequester;
    private String wantedRole;


    public UserRequest() {
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Boolean getIsRequester() {
        return isRequester;
    }

    public void setRequester(Boolean isRequester) {
        this.isRequester = isRequester;
    }

    public String getWantedRole() {
        return wantedRole;
    }

    public void setWantedRole(String wantedRole) {
        this.wantedRole = wantedRole;
    }
}
