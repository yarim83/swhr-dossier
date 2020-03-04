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

    @NotNull(message = "{address.name.notNull}")
    @NotEmpty(message = "{address.name.notEmpty}")
    private String street;

    @NotNull(message = "{address.name.notNull}")
    @NotEmpty(message = "{address.name.notEmpty}")
    private String street_number;

    @NotNull(message = "{address.name.notNull}")
    @NotEmpty(message = "{address.name.notEmpty}")
    private String city;

    @NotNull(message = "{address.name.notNull}")
    @NotEmpty(message = "{address.name.notEmpty}")
    private String country;

}
