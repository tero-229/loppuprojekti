package academy.ystavasovellus.entities;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;
    private String maakunta;
    private String info;
    private boolean sportinterest;
    private boolean freetime;

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

    public String getMaakunta() {
        return maakunta;
    }

    public void setLaani(String maakunta) {
        this.maakunta = maakunta;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isSportinterest() {
        return sportinterest;
    }

    public void setSportinterest(boolean sportinterest) {
        this.sportinterest = sportinterest;
    }

    public boolean isFreetime() {
        return freetime;
    }

    public void setFreetime(boolean freetime) {
        this.freetime = freetime;
    }


}