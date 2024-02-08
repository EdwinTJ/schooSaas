package schoolSoftware.school.student_parent;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import schoolSoftware.school.parent.ParentModel;
import schoolSoftware.school.parent.ParentRepository;
import schoolSoftware.school.student.StudentModel;
import schoolSoftware.school.student.StudentRepository;

@Entity
@Transactional
@Table(name = "student_parent")
public class Student_ParentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "student_id")
    private StudentModel student;

    @OneToOne
    @JoinColumn(name = "parent_id")
    private ParentModel parent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StudentModel getStudent() {
        return student;
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }

    public ParentModel getParent() {
        return parent;
    }

    public void setParent(ParentModel parent) {
        this.parent = parent;
    }
}
