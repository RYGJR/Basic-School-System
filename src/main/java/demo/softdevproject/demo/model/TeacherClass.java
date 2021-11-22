
package demo.softdevproject.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacherclass")
public class TeacherClass {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "section")
    private String section;

    @Column(name = "email")
    private String email;

    @Column(name = "prelim")
    private String prelim;

    @Column(name = "midterm")
    private String midterm;

    @Column(name ="finals")
    private String finals;

    @Column(name = "finalGrade")
    private String finalGrade;





    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSection() {
        return section;
    }
    public void setSection(String section) {
        this.section = section;
    }

    public String getFinalGrade() {
        return finalGrade;
    }
    public void setFinalGrade(String finalGrade) {
        this.finalGrade = finalGrade;
    }

    public String getPrelim() {
        return prelim;
    }
    public void setPrelim(String prelim) {
        this.prelim = prelim;
    }

    public String getMidterm() {
        return midterm;
    }
    public void setMidterm(String midterm) {
        this.midterm = midterm;
    }

    public String getFinals() {
        return finals;
    }
    public void setFinals(String finals) {
        this.finals = finals;
    }

}
