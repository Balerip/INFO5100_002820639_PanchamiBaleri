import java.util.UUID;

class Student {
    UUID student_id;
    String student_name;
    int student_unique_identifier;
    int student_age;
    String department;
    double fees_per_course;
    int no_of_courses;
    String grade;
    String university_name;

    public Student(String student_name, int student_unique_identifier, int student_age, String department, double fees_per_course, int no_of_courses, String grade, String university_name) {
        this.student_id= UUID.randomUUID();
        this.student_name = student_name;
        this.student_unique_identifier = student_unique_identifier;
        this.student_age = student_age;
        this.department = department;
        this.fees_per_course = fees_per_course;
        this.no_of_courses = no_of_courses;
        this.grade = grade;
        this.university_name = university_name;
        System.out.println("Instance of Student class created with unique id "+student_id);
    }

    public void pay_fees()
    {
        System.out.println(this.student_name+" must pay fees of "+Double.toString(this.fees_per_course*this.no_of_courses));
    }
    public boolean enroll()
    {
        boolean is_enrolled=true;
        System.out.println("The student is enrolled");
        return is_enrolled;
    }
    public void scholarship_eligibility()
    {
        if(enroll()==true)
        {
            if(this.grade=="A" | this.grade=="A+")
            {
                System.out.println(this.student_name+" is eligible for scholarship");
            }
            else
            {
                System.out.println(this.student_name+" is not eligible for scholarship");
            }
        }
        else
        {
            System.out.println(this.student_name+" Student is not eligible for scholarship");
        }
    }


}
