package pl.sw.gov.persondossier.dto;

import lombok.*;
import pl.sw.gov.persondossier.model.Address;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
