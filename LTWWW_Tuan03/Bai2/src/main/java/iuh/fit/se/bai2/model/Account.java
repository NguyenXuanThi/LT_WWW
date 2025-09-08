package iuh.fit.se.bai2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthDate;
    private String gender;
}
