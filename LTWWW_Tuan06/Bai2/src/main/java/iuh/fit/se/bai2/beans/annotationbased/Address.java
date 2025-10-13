package iuh.fit.se.bai2.beans.annotationbased;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Address {
    private String city = "Hanoi";
    private String state = "HN";
    private String country = "Vietnam";
}
