import java.util.UUID;

class Restaurant {
    UUID restaurant_id;
    String name;
    int no_of_tables;
    int no_of_seats_per_table;
    String chef_special;
    double rating;

    boolean is_rooftop;

    int customers;

    boolean restaurant_open;

    public Restaurant(String name, int no_of_tables, int no_of_seats_per_table, String chef_special, double rating, boolean is_rooftop, int customers, boolean restaurant_open) {
        this.restaurant_id= UUID.randomUUID();
        this.name = name;
        this.no_of_tables = no_of_tables;
        this.no_of_seats_per_table = no_of_seats_per_table;
        this.chef_special = chef_special;
        this.rating = rating;
        this.is_rooftop = is_rooftop;
        this.customers = customers;
        this.restaurant_open = restaurant_open;
        System.out.println("Instance of Restaurant class created with unique id "+restaurant_id);
    }

    public void chef_special_availability()
    {
        if(this.restaurant_open)
        {
            System.out.println("The Chef can prepare chef's special "+this.chef_special);
        }
        else
        {
            System.out.println("The restaurant is closed and not available for chef's special");
        }
    }

    public void seating_capacity()
    {
        System.out.println("The seating capacity of the restaurant is:"+Double.toString(this.no_of_tables*this.no_of_seats_per_table));
    }

    public void restaurant_popularity()
    {
        if(this.rating>=4)
        {
            System.out.println("The restaurant is very popular");
        }
        else
        {
            System.out.println("The restaurant is not very popular");
        }
    }


}
