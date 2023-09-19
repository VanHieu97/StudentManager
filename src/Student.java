import java.util.Arrays;

public class Student {
    private int id;
    private String name;
    private String sex;
    private double[] pointArray = new double[3];
    private static int IdUp = 1;

    public Student( String name, String sex, double[] pointArray) {
        this.id = IdUp++;
        this.name = name;
        this.sex = sex;
        this.pointArray = pointArray;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double[] getPoint() {
        return pointArray;
    }

    public void setPoint(double[] point) {
        this.pointArray = point;
    }
    public double MediumScore(){
        double Avg = 0;
        for (int i = 0; i < pointArray.length; i++) {
            Avg+= pointArray[i];
        }
        return Avg/ pointArray.length;
    }


    @Override
    public String toString() {
        return "Sinh viên " +
                "id= " + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", Điểm " +"Toán " + pointArray[0] +" Văn "+pointArray[1]+" Anh "+pointArray[2];
    }
}

