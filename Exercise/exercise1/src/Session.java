import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Creating session class that has array list of students
class Session {
    private ArrayList<Student> Students = new ArrayList<>(20);

    public Session() {
        this.Students = Students;
    }

    // adds part-time and full-time student objects to the Students array list
    public void add_student(Student s) {
        Students.add(s);
    }

    public ArrayList<Student> get_students() {
        return Students;
    }

    public void print_scores_of_each_student() {
        for (int i = 0; i < Students.size(); i++) {
            System.out.println("The 15 scores of " + Students.get(i).getStudent_name()+" are: "+Students.get(i).getQuiz_scores());
        }
    }

    public void print_scores_of_students_in_ascending_order() {
        for (int i = 0; i < Students.size(); i++) {
            ArrayList<Double> scores_of_each_student_in_ascending_order = Students.get(i).getQuiz_scores();
            Collections.sort(scores_of_each_student_in_ascending_order);
            System.out.println("The score of " + Students.get(i).getStudent_name() + " in ascending order is:" + scores_of_each_student_in_ascending_order);
        }

    }

    public ArrayList<Double> average_quiz_scores() {
        ArrayList<Double> average_quiz_scores = new ArrayList<>();
        for (int i = 0; i < Students.size(); i++) {
            average_quiz_scores.add(Students.get(i).calculate_average_score_for_each_student());
        }
        return average_quiz_scores;
    }

    public void print_average_quiz_scores_ascending_order() {
        List<Double> avg_quiz_scores_ascending_order = average_quiz_scores();
        Collections.sort(avg_quiz_scores_ascending_order);
        System.out.println("The average scores of 20 students in ascending order is: " + avg_quiz_scores_ascending_order);
    }

    public void print_names_part_time_students() {
        System.out.println("Part-Time Students");
        for (int i = 0; i < Students.size(); i++) {
            if (Students.get(i).getClass().equals(PartTime.class)) {
                System.out.println(Students.get(i).getStudent_name());
            }
        }
    }

    public void print_exam_scores_full_time_students()
    {
        System.out.println("Full-Time Students");
        for (int i = 0; i < Students.size(); i++) {
            if (Students.get(i).getClass().equals(FullTime.class)) {
                FullTime fulltime_student = (FullTime) Students.get(i);
                System.out.println(fulltime_student.getStudent_name() + " has scored " + fulltime_student.getExam_score()[0] + " in exam 1" + " and has scored " + fulltime_student.getExam_score()[1] + " in exam 2");
            }
        }
    }
}
