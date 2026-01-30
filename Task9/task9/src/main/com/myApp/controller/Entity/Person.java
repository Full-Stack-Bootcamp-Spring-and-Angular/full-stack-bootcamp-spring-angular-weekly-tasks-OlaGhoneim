package main.com.myApp.controller.Entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@lombok.Getter
@lombok.Setter

@Entity
@Table(
        name = "person"
)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id"
    )
    private int id;
    @Column(
            name = "firstname"
    )
    private String firstname;

    @Column(
            name = "lastname"
    )
    private String lastname;
    @OneToOne (mappedBy = "person")
    private Passport passport;
    @Column(
            name = "password"
    )
    private String password;


    public Person() {
    }

    public Person( String firstname,String lastname,String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;

    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", passport=" + passport +
                ", password='" + password + '\'' +
                '}';
    }
}
