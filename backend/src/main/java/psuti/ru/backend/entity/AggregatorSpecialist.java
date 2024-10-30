package psuti.ru.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "aggregator_specialist")
public class AggregatorSpecialist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aggregator_specialist_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "aggregator_specialist_surname", nullable = false, length = 50)
    private String surname;

    @Column(name = "aggregator_specialist_name", nullable = false, length = 50)
    private String name;

    @Column(name = "aggregator_specialist_patronymic", length = 50)
    private String patronymic;

    @Column(name = "aggregator_specialist_department", nullable = false, length = 30)
    private String department;

    @Column(name = "aggregator_specialist_position", nullable = false, length = 20)
    private String position;

    @Column(name = "aggregator_specialist_phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "add_info", length = 250)
    private String addInfo;

    @ManyToMany
    @JoinTable(name = "aggregator_specialist_connection_request_id",
            joinColumns = @JoinColumn(name = "aggregator_specialist_id", referencedColumnName = "aggregator_specialist_id"),
            inverseJoinColumns = @JoinColumn(name = "connection_request_id", referencedColumnName = "connection_request_id"))
    private List<ConnectionRequest> connectionRequests;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AggregatorSpecialist that = (AggregatorSpecialist) o;
        return id.equals(that.id) && surname.equals(that.surname) && name.equals(that.name) &&
                Objects.equals(patronymic, that.patronymic) && department.equals(that.department) &&
                position.equals(that.position) && phoneNumber.equals(that.phoneNumber) &&
                Objects.equals(addInfo, that.addInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, patronymic, department, position, phoneNumber, addInfo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AggregatorSpecialist{");
        sb.append("id=").append(id);
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", patronymic='").append(patronymic).append('\'');
        sb.append(", department='").append(department).append('\'');
        sb.append(", position='").append(position).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", addInfo='").append(addInfo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
