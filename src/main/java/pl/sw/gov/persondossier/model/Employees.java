package pl.sw.gov.persondossier.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "employees")
public class Employees extends AbstractEntity {

    @NotEmpty
    @NotNull
    private String firstName;

    @NotEmpty
    @NotNull
    private String lastName;

    @Email
//    @UniqueElements
    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String pesel;

    @NotEmpty
    @NotNull
    private String sex;

    private long photoId;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonIgnore
    @CreatedDate()
    private LocalDate createdDate = LocalDate.now();

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "permission_level_id")
    private PermissionLevel permissionLevel;

}
