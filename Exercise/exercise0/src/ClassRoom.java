import java.util.UUID;

class ClassRoom {
    UUID classroom_id;
    int classroom_number;
    String instruction_type;

    String resources;

    int no_of_students;
    String instructor_name;

    String teaching_assistant_name;

    String sitting_arrangement_type;

    String teaching_visual_aid;


    ClassRoom(int classroom_number, String instruction_type, String resources, int no_of_students, String instructor_name, String teaching_assistant_name, String teaching_visual_aid) {
        this.classroom_id=UUID.randomUUID();
        this.classroom_number = classroom_number;
        this.instruction_type = instruction_type;
        this.resources = resources;
        this.no_of_students = no_of_students;
        this.instructor_name = instructor_name;
        this.teaching_assistant_name = teaching_assistant_name;
        this.sitting_arrangement_type = sitting_arrangement_type;
        this.teaching_visual_aid = teaching_visual_aid;
        System.out.println("Instance of Classroom class created with unique id"+classroom_id);


    }

    public  String mode_of_instruction() {
        if (this.instruction_type == "online") {
            return "Students can attend the lecture from home";
        } else {
            return "Students have to be present in class";
        }
    }

    public void teach() {
        String instructor_presence="present";
        if (instructor_presence=="present") {
            System.out.print("The lecture will be taught by" + this.instructor_name);
        } else {
            System.out.print("The lecture will be taught by" + this.teaching_assistant_name);
        }
    }

    public void teaching_aid() {
        if(this.teaching_visual_aid=="projector")
        {
            System.out.println("Need to reserve"+" "+this.teaching_visual_aid+" "+"for the professor");
        }
        else
        {
            System.out.println("Need not reserve"+" "+this.teaching_visual_aid+" "+ "for the professor");
        }

    }
}
