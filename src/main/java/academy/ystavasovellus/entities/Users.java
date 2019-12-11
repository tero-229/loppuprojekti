package academy.ystavasovellus.entities;
import javax.persistence.*;

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
    public String maakunta;
    @Column(name = "info")
    public String info;


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

    public void setMaakunta(String maakunta) {
        this.maakunta = maakunta;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    @Override
    public String toString() {
        return "Name: " + name  + "Age: " + age + "Maakunta: " + maakunta + "Information: " + info;
    }
}