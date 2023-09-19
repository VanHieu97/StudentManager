import java.util.ArrayList;
import java.util.Scanner;

public class MenuStudent {
    StudentManager Manager = new StudentManager();
    Scanner inputNumber = new Scanner(System.in);
    Scanner inputStr = new Scanner(System.in);
    public void showMenu(){
        Student student = new Student("Hiếu","Nam",new double[]{7,8,9});
        Student student1 = new Student("Long","Nam",new double[]{6,8,9});
        Student student2 = new Student("Cường","Nam",new double[]{8,8,9});
        Student student3 = new Student("Thiện","Nam",new double[]{9,8,9});
        Manager.add(student);
        Manager.add(student1);
        Manager.add(student2);
        Manager.add(student3);
        int choice;
        do {
            System.out.println("=====Manager Student====");
            System.out.println("1: Thêm mới sinh viên");
            System.out.println("2: Xóa sinh viên");
            System.out.println("3: Sửa sinh viên");
            System.out.println("4: Tìm kiếm sinh viên");
            System.out.println("5: Hiển thị danh sách theo tên sinh viên gần đúng");
            System.out.println("6: Sinh viên có điểm trung bình lớn nhất");
            System.out.println("7: Hiển thị tất cả sinh viên");
            System.out.println("0: Thoát chương trình");
            System.out.println("Nhập lựa chon của bạn: ");
            choice = inputNumber.nextInt();
            switch (choice){
                case 1:
                    formShowAdd();
                    break;
                case 2:
                    formDelete();
                    break;
                case 3:
                    formEdit();
                    break;
                case 4:
                    formFindById();
                    break;
                case 5:
                    formFindByName();
                    break;
                case 6:
                    formGetAvgMax();
                    break;
                case 7:
                    formShowInfoStudent();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn NGU");
            }

        }while (true);
    }
    public void formShowAdd(){
        System.out.println("Form thông tin sinh viên");
        System.out.println("Nhập tên");
        String name = inputStr.nextLine();
        System.out.println("Nhập giới tính");
        String sex = inputStr.nextLine();
        double[] points = new double[3];
        System.out.println("Nhập điểm toán");
        points[0] =  inputNumber.nextDouble();
        System.out.println("Nhập điểm Văn");
        points[1] = inputNumber.nextDouble();
        System.out.println("Nhập điểm Anh");
        points[2] = inputNumber.nextDouble();
    }
    public void formDelete(){
        System.out.println("Form ID sinh viên muốn xóa");
        System.out.println("Nhập ID");
        int id = inputNumber.nextInt();
       if(Manager.findIndexById(id) != -1){
           Manager.delete(id);
           System.out.println("Đã xóa thành công");
       }
        System.out.println("Không tìm thấy ID tương ứng");
    }
    public void formEdit(){
        System.out.println("Form Edit sinh viên muốn sửa");
        System.out.println("Nhập ID sinh viên muốn sửa");
        int id = inputNumber.nextInt();
        if(Manager.findIndexById(id) != -1){
            System.out.println("Nhập tên");
            String name = inputStr.nextLine();
            System.out.println("Nhập giới tính");
            String sex = inputStr.nextLine();
            System.out.println("Nhập điểm Toán");
            double toan = inputNumber.nextDouble();
            System.out.println("Nhập điểm Văn");
            double van = inputNumber.nextDouble();
            System.out.println("Nhập điểm Anh");
            double anh = inputNumber.nextDouble();
            Manager.edit(id,name,sex,new double[]{toan,van,anh});
        }
    }
    public void formFindById(){
        System.out.println("Form tìm kiếm sinh viên theo ID");
        System.out.println("Nhập ID sinh viên muốn tìm");
        int id = inputNumber.nextInt();
        if(Manager.findIndexById(id) != -1){
            System.out.println("Sinh viên có ID "+id+" tương ứng là:");
            System.out.println(Manager.findById(id));
        }else {
            System.out.println("Không tìm thấy Sinh viên có "+id +" tương ứng");
        }
    }
    public void formFindByName(){
        System.out.println("Form tìm sinh viên theo tên gần đúng");
        System.out.println("Nhập vào tên sinh viên muốn tìm");
        String name = inputStr.nextLine();
        ArrayList<Student> findStudent = Manager.findByName(name);
        if (findStudent == null){
            System.out.println("Không có sinh viên theo tên tương ứng");
        }else {
            for (Student Student: findStudent) {
                System.out.println(Student);
            }
        }
    }
    public void formGetAvgMax(){
        System.out.println("Sinh viên có điểm cao nhất là");
        System.out.println(Manager.getStudentAvgMax());
    }
    public void formShowInfoStudent(){
        System.out.println("Danh sách sinh viên trong lớp là: ");
        for (Student student: Manager.listStudent) {
            System.out.println(student);
        }
    }
}
