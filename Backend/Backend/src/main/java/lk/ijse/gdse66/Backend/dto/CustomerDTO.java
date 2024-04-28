package lk.ijse.gdse66.Backend.dto;

import lk.ijse.gdse66.Backend.enums.Gender;
import lk.ijse.gdse66.Backend.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
