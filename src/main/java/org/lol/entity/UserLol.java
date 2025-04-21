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
    @SequenceGenerator(name = "lol", sequenceName = "users_id_seq", allocationSize = 1)
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

//    @ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity companyEntity;

    public UserLol() {

    }

    public UserLol(Long id, String username, UserInfo userInfo, Birthday birthDate, Role role, CompanyEntity companyEntity) {
        this.id = id;
        this.username = username;
        this.userInfo = userInfo;
        this.birthDate = birthDate;
        this.role = role;
        this.companyEntity = companyEntity;
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
