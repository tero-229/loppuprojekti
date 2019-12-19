package academy.ystavasovellus.entities;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @JoinColumn(name = "username")
    public String username;
    @Column(name= "authority")
    public String authority = "ROLE_USER";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
