package academy.ystavasovellus.entities;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long id;
    @Column(name = "name")
    public String name;
    @Column(name = "age")
    public int age;
    @Column(name = "maakunta")
    public String state;
    @Column(name = "info")
    public String info;
    @Column(name = "friendlist")
    public String friendlist;
    @Column(name = "sports")
    public Boolean sports;
    @Column(name = "freetime")
    public Boolean freetime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setState(String maakunta) {
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
        return "Nimi: " + name  + "Ikä: " + age + "Maakunta: " + state + "Lisätiedot: " + info;
    }
}