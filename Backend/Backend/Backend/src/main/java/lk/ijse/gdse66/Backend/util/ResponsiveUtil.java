package lk.ijse.gdse66.Backend.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponsiveUtil {
    private String state;
    private String message;
    private Object data;
}
