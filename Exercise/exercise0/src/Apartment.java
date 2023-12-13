import java.util.UUID;

class Apartment{
    UUID apartment_id;
    String apartment_type;
    String equipments_type;
    String flooring_type;
    int no_of_floors;
    double balcony_size;
    double area;
    int no_of_rooms;
    double monthly_rent;

    public Apartment(String apartment_type, String equipments_type, String flooring_type, int no_of_floors, double balcony_size, double area, int no_of_rooms, double monthly_rent) {
        this.apartment_id= UUID.randomUUID();
        this.apartment_type = apartment_type;
        this.equipments_type = equipments_type;
        this.flooring_type = flooring_type;
        this.no_of_floors = no_of_floors;
        this.balcony_size = balcony_size;
        this.area = area;
        this.no_of_rooms = no_of_rooms;
        this.monthly_rent = monthly_rent;
        System.out.println("Instance of Apartment class created with unique id "+apartment_id);
    }
    public void check_maintainence_ease()
    {
        if(this.flooring_type=="Wooden")
        {
            System.out.println("The house can be easily cleaned frequently");
        }
        else
        {
            System.out.println("The house flooring has to be maintained properly to avoid liquid from spillint over the floor");
        }
    }
    public void yearly_rent()
    {
        double yearly_rent=this.monthly_rent*12;
        System.out.println("The yearly rent for the apartment is:"+yearly_rent);

    }

    public void display_apartment_info()
    {
        System.out.println("The apartment type is:"+this.apartment_type);
        System.out.println("The equipments type in the apartment is:"+this.apartment_type);
        System.out.println("The flooring type in the apartment is:"+this.flooring_type);
        System.out.println("The number of floors in the apartment is:"+this.no_of_floors);
        System.out.println("The balcony size of the apartment is:"+this.balcony_size);
        System.out.println("The area of the apartment is:"+this.area);
        System.out.println("The number of rooms in the apartment is:"+this.no_of_rooms);
        System.out.println("The Monthly rent of the apartment is:"+this.monthly_rent);
    }
}
