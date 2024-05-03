package lk.ijse.gdse66.Backend.enttity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.ijse.gdse66.Backend.enums.Gender;
import lk.ijse.gdse66.Backend.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    private String customerCode;
    private String customerName;
    private Gender gender;
    private Date joinDate;
    private lk.ijse.gdse66.Backend.enums.Level Level;
    private double totalPoints;
    private Date DOB;
    private String address;
}
