import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import javax.persistence.*;
@Entity
@Table(name="student")
@Setter
@Getter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name="course_student",
            joinColumns = @JoinColumn (name="student_id"),
            inverseJoinColumns=@JoinColumn (name="course_id")
    )
    private List<Course>courseList;

    public Student(String name) {
        this.name = name;
    }
}
