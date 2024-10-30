package psuti.ru.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "connection_request")
public class ConnectionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "connection_request_id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @Column(name = "reg_number", nullable = false, length = 20)
    private String regNumber;

    @Column(name = "date_begin", nullable = false)
    private LocalDate dateBegin;

    @Column(name = "date_end")
    private LocalDate dateEnd;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "add_info", length = 250)
    private String addInfo;

    @ManyToMany
    @JoinTable(name = "aggregator_specialist_connection_request_id",
            joinColumns = @JoinColumn(name = "connection_request_id", referencedColumnName = "connection_request_id"),
            inverseJoinColumns = @JoinColumn(name = "aggregator_specialist_id", referencedColumnName = "aggregator_specialist_id"))
    private List<AggregatorSpecialist> aggregatorSpecialists;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConnectionRequest that = (ConnectionRequest) o;
        return id.equals(that.id) && organization.equals(that.organization) && regNumber.equals(that.regNumber) &&
                dateBegin.equals(that.dateBegin) && Objects.equals(dateEnd, that.dateEnd) &&
                status.equals(that.status) && Objects.equals(addInfo, that.addInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, organization, regNumber, dateBegin, dateEnd, status, addInfo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ConnectionRequest{");
        sb.append("id=").append(id);
        sb.append(", organization=").append(organization);
        sb.append(", regNumber='").append(regNumber).append('\'');
        sb.append(", dateBegin=").append(dateBegin);
        sb.append(", dateEnd=").append(dateEnd);
        sb.append(", status='").append(status).append('\'');
        sb.append(", addInfo='").append(addInfo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
