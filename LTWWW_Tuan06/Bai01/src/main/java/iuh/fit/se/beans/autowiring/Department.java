package iuh.fit.se.beans.autowiring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private String id;
    private String name;
    private Faculty faculty;

    public Department(Faculty faculty){
        this.faculty = faculty;
    }
}
