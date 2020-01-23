package pl.sw.gov.persondossier.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotNull
    private String firstName;

    @NotEmpty
    @NotNull
    private String lastname;

    @Email
    private String email;

    @PESEL
    private String pesel;

    @NotEmpty
    @NotNull
    private String sex;

    private String photo_link;

    private LocalDateTime birth_date;

    @OneToOne
    @JoinColumn(name = "adress_id", unique = true)
    private Adress adress;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "permision_level_id")
    private PermisionLevel permisionLevel;

}
