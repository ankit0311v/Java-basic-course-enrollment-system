import java.io.BufferedReader;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static HashMap<Integer,Course> coursedata=new HashMap<>();
    static HashMap<Integer,Students> studentdata=new HashMap<>();
     static void showallstudentdata(){
        for(var e:studentdata.entrySet()){
            System.out.println(e.getValue().studentid+" "+e.getValue().name+" "+e.getValue().email);
            System.out.println("COURSES ENROLLED IN -");
            for(var x:e.getValue().enrolledcourses){
                System.out.println(x.courseid+" "+x.coursename+" "+x.description);
            }
            System.out.println();
        }
    }
    static void showallcoursedata(){
        for(var e:coursedata.entrySet()){
            System.out.println(e.getValue().courseid+" "+e.getValue().coursename+" "+e.getValue().description);

        }
    }

    public static void main(String[] args) {
        int enteredvalue=0;
        Scanner sc=new Scanner(System.in);


        while(true){

            System.out.println("1.Add Courses");
            System.out.println("2.Register Students");
            System.out.println("3.Enroll Student in Course");
            System.out.println("4.Show DATA");
            System.out.println("5.Exit Option");
            enteredvalue=sc.nextInt();
            sc.nextLine();
            if(enteredvalue==1){
                while(true){
                    System.out.println("ENTER COURSE ID-");
                    int enteredcourseid=sc.nextInt();
                    sc.nextLine();
                    System.out.println("ENTER COURSE NAME-");
                    String enteredcoursename=sc.nextLine();
                    System.out.println("ENTER COURSE DESCRIPTION-");
                    String entereddescription=sc.nextLine();
                    if(coursedata.containsKey(enteredcourseid)){
                        System.out.println("----COURSE DATA ALREADY PRESENT----");
                    }
                    else{
                        Course courseobject=new Course(enteredcourseid,enteredcoursename,entereddescription);
                        coursedata.put(enteredcourseid,courseobject);
                        System.out.println("----COURSE DATA ENTERED SUCCESSFULLY----");

                    }
                    while(true){
                        System.out.println("1.ENTER NEW DATA");
                        System.out.println("2.EXIT");
                        enteredvalue=sc.nextInt();
                        sc.nextLine();
                        if(enteredvalue==1 || enteredvalue==2)break;
                        else System.out.println("--------------INVALID INPUT-----------------");
                    }
                    if(enteredvalue==2)break;
                }
            }
            else if(enteredvalue==2){
                while(true){
                    System.out.println("ENTER STUDENT ID-");
                    int enteredstudentid=sc.nextInt();
                    sc.nextLine();
                    System.out.println("ENTER STUDENT NAME-");
                    String enteredstudentname=sc.nextLine();
                    System.out.println("ENTER STUDENT EMAIL-");
                    String enteredstudentemail=sc.nextLine();
                    //here
                    Pattern pattern=Pattern.compile("[a-zA-z]+[0-9]+@gmail\\.com");
                    Matcher tomatch=pattern.matcher(enteredstudentemail);

                    if(tomatch.matches()) {


                        if (studentdata.containsKey(enteredstudentid)) {
                            System.out.println("DATA ALREADY PRESENT");
                        } else {
                            Students studentobject = new Students(enteredstudentid, enteredstudentname, enteredstudentemail);
                            studentdata.put(enteredstudentid, studentobject);
                            System.out.println("---- STUDENT DATA ENTERED SUCCESSFULLY----");
                        }

                    }else{
                        System.out.println("INVALID EMAIL ID-");
                    }
                    while (true) {
                        System.out.println("1.ENTER ANOTHER STUDENT DETAIL");
                        System.out.println("2.EXIT");
                        enteredvalue = sc.nextInt();
                        sc.nextLine();
                        if (enteredvalue == 1 || enteredvalue == 2) break;
                        else {
                            System.out.println("--------------INVALID INPUT-----------------");
                        }
                    }
                    if (enteredvalue == 2) break;
                }
            }
            else if(enteredvalue==3){
                while(true){
                    System.out.println("ENTER STUDENT ID-");
                    int enrollmententrystudentid=sc.nextInt();
                    sc.nextLine();
                    if(studentdata.containsKey(enrollmententrystudentid)){
                        System.out.println("ENTER COURSE ID TO ENROLLED-");
                        int enrolledentrycourseid=sc.nextInt();
                        if(coursedata.containsKey(enrolledentrycourseid)){
                            Course enteredcourse=coursedata.get(enrolledentrycourseid);
                            studentdata.get(enrollmententrystudentid).enrolledcourses.add(enteredcourse);
                            System.out.println("----ENROLLED SUCCESSFULLY----");
                        }else{
                            System.out.println("----INVALID COURSE ID----");
                        }
                    }
                    else{
                        System.out.println("-------ENTERED STUDENT ID IS NOT PRESENT IN DATABASE------");
                    }
                    while(true){
                        System.out.println("1.ENROLLED ANOTHER STUDENT");
                        System.out.println("2.EXIT");
                        enteredvalue=sc.nextInt();
                        sc.nextLine();
                        if(enteredvalue==1 || enteredvalue==2)break;
                        else System.out.println("--------------INVALID INPUT-----------------");
                    }
                    if(enteredvalue==2)break;
                }
            }
            else if(enteredvalue==4){
                while(true) {
                    System.out.println("1.SHOW STUDENT DATA");
                    System.out.println("2.SHOW COURSE DATA");
                    enteredvalue = sc.nextInt();
                    sc.nextLine();
                    if (enteredvalue == 1) showallstudentdata();
                    else if (enteredvalue == 2) showallcoursedata();
                    else {
                        System.out.println("--------------INVALID INPUT-----------------");
                    }
                    while (true) {
                        System.out.println("1.SHOW ANOTHER");
                        System.out.println("2.EXIT");
                        enteredvalue = sc.nextInt();
                        sc.nextLine();
                        if (enteredvalue == 1 || enteredvalue == 2) break;
                        else System.out.println("--------------INVALID INPUT-----------------");
                    }
                    if (enteredvalue == 2) break;
                }
            }
            else if(enteredvalue==5){
                break;
            }
            else{
                System.out.println("--------------INVALID INPUT-----------------");
            }

        }
    }
}