package schoolSoftware.school.grade;

import jakarta.persistence.*;

@Entity
@Table(name = "grade")
public class GradeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String gname;
    private String glevel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGlevel() {
        return glevel;
    }

    public void setGlevel(String glevel) {
        this.glevel = glevel;
    }
}
