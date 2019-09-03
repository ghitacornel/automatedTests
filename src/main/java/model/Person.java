package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class Person {

    private int id;
    private String name;
    private Date date;
    private Double salary;

    final private List<Address> addresses = new ArrayList<>();
//    private List<Address> addresses;

}
