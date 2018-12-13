package dk.hgigym.model;

import javax.persistence.*;

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
    private String wantedRole;
    @OneToOne
    private User requester;
    @OneToOne
    private User assignee;



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

    public User getRequester() {
        return requester;
    }

    public void setRequester(User requester) {
        this.requester = requester;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
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

    public String getWantedRole() {
        return wantedRole;
    }

    public void setWantedRole(String wantedRole) {
        this.wantedRole = wantedRole;
    }
}
