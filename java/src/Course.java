import java.util.LinkedList;

public class Course{
    private String courseName = "";       //課程名稱
    private String courseNumber = "0000"; //課程代碼
    private final int maxStudentNumber;   //學生上限
    private int studentNumber = 0;        //目前學生數
    private String teacherName = "";      //教授名稱
    private LinkedList<Student> studentList;   //學生名單

    public Course(String courseName, String courseNumber, int maxStudentNumber, String teacherName) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.maxStudentNumber = maxStudentNumber;
        this.teacherName = teacherName;
        this.studentList = new LinkedList<>();
        System.out.println("A course is constructed");
    }
    public void addStudent(Student... studentList) {
        StringBuilder addedList = new StringBuilder();
        for(Student i : studentList){
            if( studentNumber < maxStudentNumber && !this.studentList.contains(i) ) {
                addedList.append('\t').append(i).append('\n');
                this.studentList.add(i);
                studentNumber++;
                i.addCourse(this);
            }
        }
        if( addedList.length() != 0 ){
            System.out.println("Course: " + this);
            System.out.println("Add student:");
            System.out.println(addedList);
            System.out.println();
        }
    }
    public void deleteStudent(Student... studentList) {
        StringBuilder deletedList = new StringBuilder();
        for(Student i : studentList) {
            if( this.studentList.remove(i) ) {
                studentNumber--;
                deletedList.append("\t").append(i).append("\n");
                i.deleteCourse(this);
            }
        }
        
        if(deletedList.length() != 0) {
            System.out.println("Course Name: " + this);
            System.out.println("Delete student:");
            System.out.println(deletedList);
            System.out.println();
        }
    }

    public boolean equals(Course course) {
        return this.courseNumber.equals(course.getCourseNumber());
    }
    public String toString(){
        return courseName;
    }
    public String getCourseName(){
        return courseName;
    }
    public String getCourseNumber(){
        return courseNumber;
    }
    public int getMaxStudentNumber(){
        return maxStudentNumber;
    }
    public int getStudentNumber(){
        return studentNumber;
    }
    public String getTeacherName(){
        return teacherName;
    }
    public void printElement(){
        System.out.println("Course name: " + courseName);
        System.out.println("Teacher: " + teacherName);
        System.out.println("Max student number: " + maxStudentNumber);
        if(studentNumber == 0){
            System.out.println("This course has no student\n");
            return;
        }
        System.out.println("Student: ");
        studentList.forEach( (i) ->  System.out.println("\t" + i) );
        System.out.println();
    }
    public Object[] getStudentList(){
        return studentList.toArray();
    }
    
}
