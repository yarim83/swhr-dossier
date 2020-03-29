package pl.sw.gov.persondossier.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.sw.gov.persondossier.model.Address;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesDto {

    private String firstName;

    private String lastName;

    private String email;

    private String pesel;

    private String sex;

    private LocalDate birthDate;

    private long photoId;

    private Address address;

    private Long department_id;

}
