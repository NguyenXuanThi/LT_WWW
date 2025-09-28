package iuh.fit.se;
import iuh.fit.se.beans.xmlbased.Class;
import iuh.fit.se.beans.xmlbased.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import iuh.fit.se.beans.xmlbased.Student;

public class Main {
    private static ApplicationContext context;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("beans.xml");
        Student student1 = context.getBean("student1", Student.class);
        Student student2 = context.getBean("student2", Student.class);
        Student student3 = context.getBean("student3", Student.class);
        Person person1 = context.getBean("person1", Person.class);
        Class class_ = context.getBean("class2", Class.class);
//        System.out.println(student1);
//        System.out.println(student2);
//        System.out.println(student3);
        System.out.println(class_);

    }
}

