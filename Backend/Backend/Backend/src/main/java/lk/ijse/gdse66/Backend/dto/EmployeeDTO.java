package lk.ijse.gdse66.Backend.dto;

import lk.ijse.gdse66.Backend.enums.AccessRole;
import lk.ijse.gdse66.Backend.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO {
    private String employeeCode;
    private String employeeName;
    private String employeeProfilePic;
    private Gender gender;
    private String status;
    private String designation;
    private AccessRole accessRole;
    private Date DOB;
    private Date joinDate;
    private String branch;
    private String address;
    private String contactNo;
    private String Email;
    private String guardianName;
    private String guardianContactNo;
}
