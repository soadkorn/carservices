package psuti.ru.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="organization_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "organization_full_name", nullable = false, length = 150)
    private String fullName;

    @Column(name = "organization_short_name", nullable = false, length = 50)
    private String shortName;

    @Column(name = "inn", unique = true, nullable = false, length = 10)
    private String inn;

    @Column(name = "kpp", nullable = false, length = 9)
    private String kpp;

    @Column(name = "ogrn", nullable = false, length = 13)
    private String ogrn;

    @OneToOne
    @JoinColumn(name = "responsible_person_id")
    private User responsiblePerson;

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
        Organization that = (Organization) o;
        return id.equals(that.id) && fullName.equals(that.fullName) && shortName.equals(that.shortName) &&
                inn.equals(that.inn) && kpp.equals(that.kpp) && ogrn.equals(that.ogrn) &&
                Objects.equals(addInfo, that.addInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, shortName, inn, kpp, ogrn, addInfo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Organization{");
        sb.append("id=").append(id);
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", shortName='").append(shortName).append('\'');
        sb.append(", inn='").append(inn).append('\'');
        sb.append(", kpp='").append(kpp).append('\'');
        sb.append(", ogrn='").append(ogrn).append('\'');
        sb.append(", addInfo='").append(addInfo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
