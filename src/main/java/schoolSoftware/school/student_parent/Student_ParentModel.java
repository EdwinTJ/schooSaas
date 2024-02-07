package schoolSoftware.school.student_parent;

import jakarta.persistence.*;
import schoolSoftware.school.parent.ParentModel;
import schoolSoftware.school.parent.ParentRepository;
import schoolSoftware.school.student.StudentModel;
import schoolSoftware.school.student.StudentRepository;

@Entity
@Table(name = "student_parent")
@SecondaryTables({
        @SecondaryTable(name="parent", pkJoinColumns={
                @PrimaryKeyJoinColumn(name="parent_id", referencedColumnName="id")
        }),
        @SecondaryTable(name="student", pkJoinColumns={
                @PrimaryKeyJoinColumn(name="student_id", referencedColumnName="id")
        })
})
public class Student_ParentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
//    @JoinColumn(table = "student")
    @PrimaryKeyJoinColumn(name = "student_id", referencedColumnName = "id")
    private StudentModel student;

    @OneToOne
//    @JoinColumn(table = "parent")
    @PrimaryKeyJoinColumn(name = "parent_id", referencedColumnName = "id")
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
