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
import java.math.BigDecimal;
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
@Table(name = "service_detail")
public class ServiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_detail_id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", nullable = false)
    private TypeService typeId;

    @Column(name = "service_detail_code", nullable = false, length = 3)
    private String code;

    @Column(name = "service_detail_name", nullable = false, length = 50)
    private String name;

    @Column(name = "service_detail_cost", nullable = false)
    private BigDecimal cost;

    @Column(name = "service_detail_duration", nullable = false)
    private Integer duration;

    @Column(name = "add_info", length = 250)
    private String addInfo;

    @ManyToMany
    @JoinTable(name = "service_request_detail",
            joinColumns = @JoinColumn(name = "service_detail_id", referencedColumnName = "service_detail_id"),
            inverseJoinColumns = @JoinColumn(name = "service_request_id", referencedColumnName = "service_request_id"))
    private List<ServiceRequest> requests;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServiceDetail that = (ServiceDetail) o;
        return id.equals(that.id) && code.equals(that.code) && name.equals(that.name) && cost.equals(that.cost) &&
                duration.equals(that.duration) && Objects.equals(addInfo, that.addInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, cost, duration, addInfo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ServiceDetail{");
        sb.append("id=").append(id);
        sb.append(", typeId=").append(typeId);
        sb.append(", code='").append(code).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", cost=").append(cost);
        sb.append(", duration=").append(duration);
        sb.append(", addInfo='").append(addInfo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
