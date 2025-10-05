package multilevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MultilevelInheritanceDemo {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Person p1 = new Person("Arjun", 7878767676L, sdf.parse("2000-12-02"));
        System.out.println(p1);

        p1 = new Employee("Prabhu", 8080807070L, sdf.parse("1995-05-07"), "Sales", 45000);
        System.out.println(p1);

        p1 = new LevelOneEmployee("Madhavan", 9880807227L, sdf.parse("1988-03-02"), "Account", 85000, 200,
                "Signing Authority");
        System.out.println(p1);
    }
}
