package iuh.fit.se.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "First Name khong duoc phep rong")
    private String firstName;
    @NotEmpty(message = "Last Name khong duoc phep rong")
    private String lastName;
    @NotNull(message = "Gender phai duoc chon")
    private Gender gender;
    @NotNull(message = "Dob khong duoc phep rong")
    private LocalDate dateOfBirth;
    @NotEmpty(message = "Email khong duoc phep rong")
    private String email;
    @NotEmpty(message = "Phone khong duoc phep rong")
    private String phone;
    @NotEmpty(message = "Address khong duoc phep rong")
    private String address;
}
