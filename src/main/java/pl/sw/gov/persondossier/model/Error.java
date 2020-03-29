package pl.sw.gov.persondossier.model;

import lombok.*;

@Data
public class Error {
    int code;
    String message;
    String cause;
}
