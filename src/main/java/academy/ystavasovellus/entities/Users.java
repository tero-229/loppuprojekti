package academy.ystavasovellus.entities;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long id;
    @Column(name = "first_name")
    @NotEmpty(message = "Please provide your first name")
    private String firstName;
    @Column(name = "last_name")
    @NotEmpty(message = "Please provide your last name")
    private String lastName;
    @Column(name = "age")
    public int age;
    @Column(name = "state")
    public String state;
    @Column(name = "info")
    public String info;
    @Column(name = "friendlist")
    public String friendlist;
    @Column(name = "sports")
    public Boolean sports;
    @Column(name = "freetime")
    public Boolean freetime;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Please provide a valid e-mail")
    @NotEmpty(message = "Please provide an e-mail")
    private String email;

    @Column(name = "password")
    @Transient
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "confirmation_token")
    private String confirmationToken;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public long getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getInfo()
    {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }



    public Boolean getSports() {
        return sports;
    }

    public void setSports(Boolean sports) {
        this.sports = sports;
    }

    public Boolean getFreetime() {
        return freetime;
    }

    public void setFreetime(Boolean freetime) {
        this.freetime = freetime;
    }

    public String getFriendlist() {
        return friendlist;
    }

    public void setFriendlist(String friendlist) {
        this.friendlist = friendlist;
    }


    @Override
    public String toString() {
        return "Nimi: " + firstName + " " + "lastName"  + "Ikä: " + age + "Maakunta: " + state + "Lisätiedot: " + info;
    }
}