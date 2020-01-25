package pl.sw.gov.persondossier.domain;

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
@Table(name = "adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String street;

    @NotEmpty
    @NotNull
    private String street_number;

    @NotEmpty
    @NotNull
    private String country;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private Adress adress;
}
