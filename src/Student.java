import java.util.LinkedList;

public class Student{
	private String name = "";
	private int grade;
	private String schoolNumber;
	private LinkedList<Course> courseList = new LinkedList<>();
	Student(){
	}
	Student(String name, int grade, String schoolNumber){
		this.name = name;
		this.grade = grade;
		this.schoolNumber = schoolNumber;
	}
	boolean equals(Student student){
		return this.schoolNumber.equals(student.getSchoolNumber());
	}
	
	public void printElement(){
		System.out.println("Name:          " + name);
		System.out.println("Grade:         " + grade);
		System.out.println("School Number: " + schoolNumber);
		if( courseList.size() == 0 ) {
            System.out.println("This student has no course\n");
            return;
        }
        System.out.println("Selected course:");
        courseList.forEach( (i) ->  System.out.println("\t" + i) );
        System.out.println();
	}

	public String getName(){
		return name;
	}
	public int getGrade(){
		return grade;
	}
	public String getSchoolNumber(){
		return schoolNumber;
	}
	public String toString(){
		return name;
	}
	public void addCourse(Course... courseList){
        StringBuilder addedList = new StringBuilder();
        for(Course i : courseList){
            if( !this.courseList.contains(i) ) {
                addedList.append('\t').append(i).append('\n');
                this.courseList.add(i);
                i.addStudent(this);
            }
        }
        if( addedList.length() != 0 ){
        	System.out.println("Student: " + this);
            System.out.println("Add course:");
            System.out.println(addedList);
            System.out.println();
        }
        
	}
	public void deleteCourse(Course... courseList) {
        StringBuilder deletedList = new StringBuilder();
        for(Course i : courseList) {
            if( this.courseList.remove(i) ) {
                deletedList.append("\t").append(i).append("\n");
                i.deleteStudent(this);
            }
        }
        if( deletedList.length() != 0 ) {
        	System.out.println("Student: " + this);
            System.out.println("Delete course:");
            System.out.println(deletedList);
            System.out.println();
        }
    }
}
