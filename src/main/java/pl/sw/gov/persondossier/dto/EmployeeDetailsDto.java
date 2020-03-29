package pl.sw.gov.persondossier.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.sw.gov.persondossier.model.Address;
import pl.sw.gov.persondossier.model.Department;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetailsDto {

    //Personal Data
    private String firstName;

    private String lastName;

    private String email;

    private String pesel;

    private String sex;

    private LocalDate birthDate;

    private long photoId;

    private Address address;

    private Department department;

}
