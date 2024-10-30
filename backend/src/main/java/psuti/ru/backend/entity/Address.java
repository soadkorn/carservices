package psuti.ru.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_type_id", nullable = false)
    private AddressType addressType;

    @Column(name = "subject_name", nullable = false, length = 50)
    private String subjectName;

    @Column(name = "city_name", nullable = false, length = 50)
    private String cityName;

    @Column(name = "street_name", nullable = false, length = 50)
    private String streetName;

    @Column(name = "house_number", nullable = false, length = 10)
    private String houseNumber;

    @Column(name = "add_info", length = 250)
    private String addInfo;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return id.equals(address.id) && organization.equals(address.organization) &&
                addressType.equals(address.addressType) && subjectName.equals(address.subjectName) &&
                cityName.equals(address.cityName) && streetName.equals(address.streetName) &&
                houseNumber.equals(address.houseNumber) && Objects.equals(addInfo, address.addInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, organization, addressType, subjectName, cityName, streetName, houseNumber, addInfo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("id=").append(id);
        sb.append(", organization=").append(organization);
        sb.append(", addressType=").append(addressType);
        sb.append(", subjectName='").append(subjectName).append('\'');
        sb.append(", cityName='").append(cityName).append('\'');
        sb.append(", streetName='").append(streetName).append('\'');
        sb.append(", houseNumber='").append(houseNumber).append('\'');
        sb.append(", addInfo='").append(addInfo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
