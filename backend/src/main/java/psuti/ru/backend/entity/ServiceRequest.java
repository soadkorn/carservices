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
import java.time.LocalDateTime;
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
@Table(name = "service_request")
public class ServiceRequest {

    public ServiceRequest(User clientId, Organization organizationId, LocalDateTime dateService, String addInfo,
                          List<ServiceDetail> details) {
        this.clientId = clientId;
        this.organizationId = organizationId;
        this.dateService = dateService;
        this.addInfo = addInfo;
        this.details = details;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_request_id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private User clientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organizationId;

    @Column(name = "data_service", nullable = false)
    private LocalDateTime dateService;

    @Column(name = "add_info", length = 250)
    private String addInfo;

    @ManyToMany
    @JoinTable(name = "service_request_detail",
            joinColumns = @JoinColumn(name = "service_request_id", referencedColumnName = "service_request_id"),
            inverseJoinColumns = @JoinColumn(name = "service_detail_id", referencedColumnName = "service_detail_id"))
    private List<ServiceDetail> details;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServiceRequest that = (ServiceRequest) o;
        return id.equals(that.id) && dateService.equals(that.dateService) &&
                Objects.equals(addInfo, that.addInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateService, addInfo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ServiceRequest{");
        sb.append("id=").append(id);
        sb.append(", clientId=").append(clientId);
        sb.append(", organizationId=").append(organizationId);
        sb.append(", dateService=").append(dateService);
        sb.append(", addInfo='").append(addInfo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
