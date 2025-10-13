package iuh.fit.se.bai2;

import iuh.fit.se.bai2.beans.javabased.Config;
import iuh.fit.se.bai2.beans.xmlbased.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJava {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Employee emp = context.getBean(Employee.class);
        System.out.println(emp);
    }
}

