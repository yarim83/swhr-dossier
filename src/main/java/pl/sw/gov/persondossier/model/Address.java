package pl.sw.gov.persondossier.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table
public class Address extends AbstractEntity {

    @NotNull
    @NotEmpty
    private String street;

    @NotNull
    @NotEmpty
    private String streetNumber;

    @NotNull
    @NotEmpty
    private String city;

    @NotNull
    @NotEmpty
    private String country;
}
