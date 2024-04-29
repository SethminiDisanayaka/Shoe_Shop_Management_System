package lk.ijse.gdse66.Backend.embeded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Address {
    String name;
    String lane;
    String city;
    String state;
    String code;
    String country;
}
