package main.com.myApp.controller.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(
        name = "passport"
)
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private int id;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="person_id")
    private Person person;
    @Column(name="passport_number")
    private String passport_number;


    private LocalDate expiry_date;

    public Passport(String passport_number, LocalDate expiry_date) {

        this.passport_number = passport_number;
        this.expiry_date = expiry_date;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", passport_number='" + passport_number + '\'' +
                ", expiry_date=" + expiry_date +
                '}';
    }
}
