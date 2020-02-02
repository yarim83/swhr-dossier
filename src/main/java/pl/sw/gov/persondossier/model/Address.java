package pl.sw.gov.persondossier.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Address extends AbstractEntity {

    @NotNull(message = "{user.firstName.notNull}")
    @NotEmpty(message = "{user.firstName.size}")
    private String street;

    @NotEmpty
    @NotNull
    private String street_number;

    @NotEmpty
    @NotNull
    private String city;

    @NotEmpty
    @NotNull
    private String country;

}
