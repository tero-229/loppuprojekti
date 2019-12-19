package academy.ystavasovellus.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long id;
    @JoinColumn(name = "username")
    @NotEmpty(message = "Please provide your username")
    private String username;
    @Column(name = "first_name")
    @NotEmpty(message = "Please provide your first name")
    private String firstName;
    @Column(name = "last_name")
    @NotEmpty(message = "Please provide your last name")
    private String lastName;
    @Column(name = "age")
    public int age = 0;
    @Column(name = "state")
    public String state;
    @Column(name = "info")
    public String info;
    @Column(name = "friendlist")
    public String friendlist;
    @Column(name = "sports")
    public boolean sports = false;
    @Column(name = "freetime")
    public boolean freetime = false;
    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Please provide a valid e-mail")
    @NotEmpty(message = "Please provide an e-mail")
    private String email;
    @Column(name="picturl")
    public String picturl;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private boolean enabled = true;
    @Column(name = "confirmation_token")
    private String confirmationToken;

    @Transient
    @OneToOne(targetEntity = Authority.class)
    private Authority authority;

    public Users() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPicturl() {
        return picturl;
    }

    public void setPicturl(String picturl) {
        this.picturl = picturl;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Nimi: " + firstName + " " + lastName  + " Ikä: " + age + " Asuinpaikka " + state + " Lisätiedot: " + info;

    }
}