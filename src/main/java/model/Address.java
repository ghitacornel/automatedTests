package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {

    private Long id;
    private String street;
    private Integer number;
    private Person person;

}
