package main.com.myApp.controller.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
public class User {
    @Id
    @Column (name="id")
  private int id;

    @Column (name="username")
  private String username;
    @Column (name="password")
  private String password;
    @Column (name="email")
  private String email;

    public User() {}
    public User(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

}
