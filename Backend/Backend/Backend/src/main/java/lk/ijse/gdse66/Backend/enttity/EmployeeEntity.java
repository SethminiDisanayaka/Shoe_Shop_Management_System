package lk.ijse.gdse66.Backend.enttity;

import jakarta.persistence.*;
import lk.ijse.gdse66.Backend.enums.AccessRole;
import lk.ijse.gdse66.Backend.enums.Branch;
import lk.ijse.gdse66.Backend.enums.Designation;
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
    @Column(columnDefinition = "LONGTEXT")
    private String employeeProfilePic;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String status;
    @Enumerated(EnumType.STRING)
    private Branch branch;
    @Enumerated(EnumType.STRING)
    private Designation designation;
    @Enumerated(EnumType.STRING)
    private AccessRole accessRole;
    @Temporal(TemporalType.DATE)
    private Date DOB;
    @Temporal(TemporalType.DATE)
    private Date joinDate;
    private String address;
    @Column(unique = true)
    private String contactNo;
    @Column(unique = true)
    private String Email;
    private String guardianName;
    @Column(unique = true)
    private String guardianContactNo;
}
