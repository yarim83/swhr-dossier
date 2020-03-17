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

    //    @NotNull
    //   @NotEmpty
    private String street;

    //    @NotNull
    //    @NotEmpty
    private String streetNumber;

    //    @NotNull
    //    @NotEmpty
    private String city;
//
//    @NotNull
//    @NotEmpty
    private String country;

}
