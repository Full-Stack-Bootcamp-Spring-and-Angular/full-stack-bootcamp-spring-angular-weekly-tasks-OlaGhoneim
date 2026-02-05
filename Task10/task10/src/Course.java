import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="course")
@Setter
@Getter
@NoArgsConstructor
public class Course {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

   @Column(name="Course_name")
   private String courseName;

   @ManyToOne(cascade=CascadeType.ALL)
   @JoinColumn(name="instructor_id")
   private Instructor instructor;
   public Course(String courseName) {
      this.courseName=courseName;
   }
}
