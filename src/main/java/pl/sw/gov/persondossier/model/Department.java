package pl.sw.gov.persondossier.model;

import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "department")
public class Department extends AbstractEntity{

    @NotNull
    @NotEmpty
    private String longName;

    @NotNull
    @NotEmpty
    private String shortName;

    @NotNull
    @NotEmpty
    @Size(max = 300)
    private String description;

}
