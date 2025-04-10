package org.lol.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.lol.converter.BirthdayConverter;

@Setter
@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
@Entity
@Table(name = "users", schema = "public")
public class UserLol {
    @Id
    private String username;
    private String firstname;
    private String lastname;
    @Column(name = "birth_date")
//    private LocalDate birthDate;
//    private Integer age;
    @Convert(converter = BirthdayConverter.class)
    private Birthday birthDate;

    @Enumerated(EnumType.STRING)
    private Role role;

    public UserLol() {

    }

    public UserLol(String username, String firstname, String lastname, Birthday birthDate, Role role) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserLol{" +
                "username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthDate=" + birthDate +
                ", role=" + role +
                '}';
    }
}
