package iuh.fit.se.beans.autowiring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department2 {
    private String id;
    private String name;
    private Faculty2 faculty;
}
