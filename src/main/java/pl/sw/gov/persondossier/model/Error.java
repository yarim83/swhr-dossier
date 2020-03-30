package pl.sw.gov.persondossier.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Error {
    int code;
    String message;
    String cause;
}
