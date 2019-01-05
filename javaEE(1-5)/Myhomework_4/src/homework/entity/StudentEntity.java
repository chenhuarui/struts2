package homework.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student", schema = "homework_your", catalog = "")
public class StudentEntity {
    private String studentId;
    private String studentName;
    private Integer studentAge;
    private String classId;

    @Id
    @Column(name = "student_id", nullable = false, length = 11)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "student_name", nullable = true, length = 11)
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "student_age", nullable = true)
    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    @Basic
    @Column(name = "class_id", nullable = true)
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(studentId, that.studentId) &&
                Objects.equals(studentName, that.studentName) &&
                Objects.equals(studentAge, that.studentAge) &&
                Objects.equals(classId, that.classId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(studentId, studentName, studentAge, classId);
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                ", classId='" + classId + '\'' +
                '}';
    }
}
