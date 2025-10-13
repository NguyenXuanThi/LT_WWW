package iuh.fit.se.bai2.beans.annotationbased;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Employee {
    private int id = 1;
    private String name = "Nguyen Van A";
    @Autowired
    private Address address;
}
