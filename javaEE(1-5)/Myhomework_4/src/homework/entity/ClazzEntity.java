package homework.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "class", schema = "homework_your", catalog = "")
public class ClazzEntity {
    private String id;
    private String serialNumber;

    @Id
    @Column(name = "id", nullable = false, length = 30)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Serial_number", nullable = true, length = 30)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClazzEntity that = (ClazzEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(serialNumber, that.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialNumber);
    }

    @Override
    public String toString() {
        return "ClazzEntity{" +
                "id='" + id + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
