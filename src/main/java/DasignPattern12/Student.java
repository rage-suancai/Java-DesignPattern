package DasignPattern12;

/**
 * @author YXS
 * @PackageName: DasignPattern12
 * @ClassName: Student
 * @Desription:
 * @date 2022/11/25 11:16
 */
public class Student implements Cloneable {

    String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /*@Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/

    @Override
    protected Object clone() throws CloneNotSupportedException {

        Student student = (Student) super.clone();
        student.name = new String(name);
        return student;

    }

}
