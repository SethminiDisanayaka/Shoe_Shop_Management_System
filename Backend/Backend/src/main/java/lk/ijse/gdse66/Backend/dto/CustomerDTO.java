package lk.ijse.gdse66.Backend.dto;

import lk.ijse.gdse66.Backend.enums.Gender;
import lk.ijse.gdse66.Backend.enums.Level;

import java.util.Date;

public class CustomerDTO {
    private String customerCode;
    private String customerName;
    private Gender gender;
    private Date joinDate;
    private Level Level;
    private double totalPoints;
    private Date DOB;
    private String address;
}
