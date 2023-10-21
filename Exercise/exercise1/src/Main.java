import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        /*Create a object for session class and then create part time students and full time students
        objects in random order and add it to the add student method of the session class*/
        Session session = new Session();
        for (int i = 1; i <= 20; i++) {
            if (r.nextInt(20) % 2 == 0) {
                PartTime partTime_student = new PartTime("Part-Time" + " " + i + " student");
                session.add_student(partTime_student);

            } else {
                FullTime fullTime_student = new FullTime("Full-Time" + " " + i + " student", new int[]{r.nextInt(50), r.nextInt(50)});
                session.add_student(fullTime_student);

            }
        }
        /*for each part-time and full-time student in the session class add 15 quiz scorea
         in the score_add method of the student class*/
        for (int k = 0; k < session.get_students().size(); k++) {
            for (int l = 0; l < 15; l++) {
                session.get_students().get(k).score_add(r.nextDouble(10));
            }
        }

        session.print_scores_of_each_student();//print 15 scores of each student
        //session.print_scores_of_students_in_ascending_order();//print 15 scores of each student in ascending order
        System.out.println("The average quiz scores for 20 students are:"+session.average_quiz_scores()); //average scores of each student
        session.print_average_quiz_scores_ascending_order();//prints average scores of 20 students in ascending order
        session.print_names_part_time_students();//print names of part time students
        session.print_exam_scores_full_time_students();//prints 2 exam scores of Full time students with their names
    }

}
