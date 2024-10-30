package psuti.ru.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "address_type")
public class AddressType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_type_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "address_type_name", nullable = false, length = 30)
    private String name;

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
        AddressType that = (AddressType) o;
        return id.equals(that.id) && name.equals(that.name) && Objects.equals(addInfo, that.addInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, addInfo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AddressType{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", addInfo='").append(addInfo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
