package iuh.fit.se.bai2.beans.javabased;

import iuh.fit.se.bai2.beans.xmlbased.Address;
import iuh.fit.se.bai2.beans.xmlbased.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Address address() {
        return new Address("Hanoi", "HN", "Vietnam");
    }

    @Bean
    public Employee employee() {
        return new Employee(1, "Nguyen Van A", address());
    }
}
