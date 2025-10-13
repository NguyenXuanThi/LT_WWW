package iuh.fit.se.bai2;

import iuh.fit.se.bai2.beans.xmlbased.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXML {
    private static ApplicationContext context;
    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("beans.xml");

        Employee emp1 = (Employee) context.getBean("employee1");
        Employee emp2 = (Employee) context.getBean("employee2");

        System.out.println(emp1);
        System.out.println(emp2);
    }
}
