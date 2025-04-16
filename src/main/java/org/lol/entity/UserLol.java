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
    @GeneratedValue(generator = "lol", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "lol", sequenceName = "lol_seq_name", allocationSize = 1)
    private Long id;
    private String username;
    @Embedded
    private UserInfo userInfo;
    @Column(name = "birth_date")
//    private LocalDate birthDate;
//    private Integer age;
    @Convert(converter = BirthdayConverter.class)
    private Birthday birthDate;

    @Enumerated(EnumType.STRING)
    private Role role;

    public UserLol() {

    }

    public UserLol(String username, UserInfo userInfo, Birthday birthDate, Role role) {
        this.username = username;
        this.userInfo = userInfo;
        this.birthDate = birthDate;
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserLol{" +
                "username='" + username + '\'' +
                ", userInfo=" + userInfo +
                ", birthDate=" + birthDate +
                ", role=" + role +
                '}';
    }
}
