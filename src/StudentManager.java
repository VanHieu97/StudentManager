import java.util.ArrayList;

public class StudentManager implements Manager {
    public StudentManager() {
    }

    ArrayList<Student> listStudent = new ArrayList<>();

    public void add(Student student){
        listStudent.add(student);
    }
    public int findIndexById(int id){
        for (int i = 0; i < listStudent.size(); i++) {
            if(listStudent.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    public void delete(int id){
        int index = findIndexById(id);
       listStudent.remove(index);
        System.out.println("Xóa thành công");
    }
    public void edit(int id,String name, String sex, double[] point){
        for (Student newStudent: listStudent) {
            if(newStudent.getId()== id){
                newStudent.setName(name);
                newStudent.setSex(sex);
                newStudent.setPoint(point);
                System.out.println("Đã sửa thành công");
                return;
            }
        }
    }
    public Student findById(int id){
        for (int i = 0; i < listStudent.size(); i++) {
            if(listStudent.get(i).getId()==id){
               return listStudent.get(i);
            }
        }
        return null;
    };
    public ArrayList<Student> findByName(String name){
        ArrayList<Student> newStudent = new ArrayList<>();
        for (Student student: listStudent) {
            if(student.getName().toLowerCase().contains(name.toLowerCase())){
                newStudent.add(student);
            }
        }
        return newStudent;
    };
    public double AvgAllStudent(){
        double totalPoint = 0;
        for (Student student: listStudent) {
            totalPoint+= student.MediumScore();
        }
        return totalPoint/listStudent.size();
    };
    public double getStudentAvgMax(){
        double StudentAvgMax = 0;
        for (Student student: listStudent) {
            if(student.MediumScore() > StudentAvgMax){
                StudentAvgMax = student.MediumScore();
            }
        }
        return StudentAvgMax;
    }
    public ArrayList<Student> showAllInfo(){
       return listStudent;
    }
}
