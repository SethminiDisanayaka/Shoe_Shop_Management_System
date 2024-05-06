package lk.ijse.gdse66.Backend.enttity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.ijse.gdse66.Backend.enums.AccessRole;
import lk.ijse.gdse66.Backend.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    private String employeeCode;
    private String employeeName;
    private String employeeProfilePic;
    private Gender gender;
    private String status;
    private String designation;
    private AccessRole accessRole;
    private Date DOB;
    private Date joinDate;
    private String attachedBranch;
    private String address;
    private String contactNo;
    private String Email;
    private String guardianName;
    private String guardianContactNo;
}
