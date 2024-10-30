package psuti.ru.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "user_public_id")
    private Long publicId;

    @Column(name = "user_name", nullable = false, length = 50)
    private String name;

    @Column(name = "user_surname", nullable = false, length = 50)
    private String surName;

    @Column(name = "user_patronymic", length = 50)
    private String patronymic;

    @Column(name = "user_phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "user_email", nullable = false, unique = true)
    private String email;

    @Column(name = "add_info", length = 250)
    private String addInfo;

    @Column(name = "password", length = 250, unique = true)
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id.equals(user.id) && Objects.equals(publicId, user.publicId) &&
                Objects.equals(name, user.name) && Objects.equals(surName, user.surName) &&
                Objects.equals(patronymic, user.patronymic) && phoneNumber.equals(user.phoneNumber) &&
                email.equals(user.email) && Objects.equals(addInfo, user.addInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, publicId, name, surName, patronymic, phoneNumber, email, addInfo);
    }
}
