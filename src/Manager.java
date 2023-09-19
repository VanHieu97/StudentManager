import java.util.ArrayList;

public interface Manager {
    public void add(Student student);
    public void delete(int id);
    public void edit(int id,String name, String sex, double[] point);
    public Student findById(int id);
    public ArrayList<Student> findByName(String name);
    public double AvgAllStudent();
    public double getStudentAvgMax();
    public ArrayList<Student> showAllInfo();
}
