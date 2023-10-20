import java.util.ArrayList;

/*creating student class and we will be using this class to create an arraylist in session class*/
class Student {
    private String student_name;
    private ArrayList<Double> quiz_scores;

    public Student(String student_name) {
        this.student_name = student_name;
        this.quiz_scores = new ArrayList<>();

    }

    //calculates average quiz_scores
    public double calculate_average_score_for_each_student() {
        double sum = 0.0;
        for (int i = 0; i < quiz_scores.size(); i++) {
            sum += quiz_scores.get(i);
        }
        double average = sum / quiz_scores.size();
        return average;

    }

    // adds score to the quiz_scores arraylist when this method is called
    public void score_add(double score) {
        quiz_scores.add(score);
    }


    public String getStudent_name() {
        return student_name;
    }

    public ArrayList<Double> getQuiz_scores() {
        return quiz_scores;
    }
}