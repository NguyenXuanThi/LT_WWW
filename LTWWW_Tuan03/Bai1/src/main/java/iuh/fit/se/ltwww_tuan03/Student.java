package iuh.fit.se.ltwww_tuan03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String firstName;
    private String lastName;
    private String birthday;
    private String email;
    private String phone;
    private String gender;
    private String address;
    private String city;
    private String pinCode;
    private String state;
    private String country;
    private String hobbies;
    private List<Qualification> qualifications;
    private String courseAppliedFor; // BCA, B.Com, B.Sc, B.A

}
