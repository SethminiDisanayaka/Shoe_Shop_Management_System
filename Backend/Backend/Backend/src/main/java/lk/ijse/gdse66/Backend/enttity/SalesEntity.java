package lk.ijse.gdse66.Backend.enttity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class SalesEntity {

    @Id
    private String orderNo;

    @CreationTimestamp
    private LocalDateTime purchaseDate;

    private Double total;
    private String paymentMethod;
    private Integer totalPoints;
    private String cashier;

    @ManyToOne
    @JoinColumn(name = "customer_name", nullable = false)
    private CustomerEntity customerName;



}
