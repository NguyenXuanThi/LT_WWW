package iuh.fit.se.bai2;

import iuh.fit.se.bai2.beans.annotationbased.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("iuh.fit.se.bai2.beans.annotationbased")
public class MainAnnotation {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainAnnotation.class);
        Employee emp = context.getBean(Employee.class);
        System.out.println(emp);
    }
}

