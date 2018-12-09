package dk.hgigym.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Date 04. dec. 2018
 */
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String activity;
    private String date;
    private String time;
    private String location;
    private String phone;
    private String note;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "request")
    public Set<UserRequest> userRequests = new HashSet<>();



    public Request() {
    }

    public Request(String activity, String date, String time, String place, String phone, String note) {
        this.activity = activity;
        this.date = date;
        this.time = time;
        this.location = place;
        this.phone = phone;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<UserRequest> getUserRequests() {
        return userRequests;
    }

    public void setUserRequests(Set<UserRequest> userRequests) {
        this.userRequests = userRequests;
    }
}
