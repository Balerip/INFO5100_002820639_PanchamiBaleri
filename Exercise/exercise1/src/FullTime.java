//Creating Full Time child class
class FullTime extends Student {
    private int[] exam_score = new int[2]; //creating an array to hold 2 exam scores

    public FullTime(String name, int[] exam_score) {
        super(name);
        this.exam_score = exam_score;
    }

    public int[] getExam_score() {
        return exam_score;
    }

}