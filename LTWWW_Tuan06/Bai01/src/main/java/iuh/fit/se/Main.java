package iuh.fit.se;
import iuh.fit.se.beans.autowiring.Department;
import iuh.fit.se.beans.autowiring.Department2;
import iuh.fit.se.beans.javabased.Group;
import iuh.fit.se.beans.javabased.User;
import iuh.fit.se.beans.javabased.userService;
import iuh.fit.se.beans.xmlbased.Class;
import iuh.fit.se.beans.xmlbased.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import iuh.fit.se.beans.xmlbased.Student;

import static org.springframework.context.annotation.AnnotationConfigApplicationContextExtensionsKt.AnnotationConfigApplicationContext;

public class Main {
    private static ApplicationContext context;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("beans.xml");
        Student student1 = context.getBean("student1", Student.class);
        Student student2 = context.getBean("student2", Student.class);
        Student student3 = context.getBean("student3", Student.class);
        Person person1 = context.getBean("person1", Person.class);
        Class class_ = context.getBean("class2", Class.class);
        Department department = context.getBean("dept1", Department.class);
        Department department1 = context.getBean("dept2", Department.class);
        Department2 department2 = context.getBean("dept3", Department2.class);
        Department department3 = context.getBean("dept4", Department.class);
//        System.out.println(student1);
//        System.out.println(student2);
//        System.out.println(student3);
        System.out.println(department);
        System.out.println(department1);
        System.out.println(department2);
        System.out.println(department3);

        AnnotationConfigApplicationContext(userService.class);
        User user = context.getBean(User.class);
        System.out.println(user);
        Group group = context.getBean(Group.class);
        System.out.println(group);

    }
}

