package main.com.myApp.controller.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@lombok.Getter
@lombok.Setter

@Entity
@Table(
        name = "user"
)
public class User {
    @Id
    @Column(
            name = "id"
    )
    private int id;
    @Column(
            name = "username"
    )
    private String username;
    @Column(
            name = "password"
    )
    private String password;


    public User() {
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;

    }
}
