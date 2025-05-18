import java.util.ArrayList;

public class Students {
    int studentid;
    String name;
    String email;

    ArrayList<Course> enrolledcourses;
    Students(int sid,String etdname,String eml){
        this.studentid=sid;
        this.name=etdname;
        this.email=eml;
        enrolledcourses=new ArrayList<>();
    }
}
