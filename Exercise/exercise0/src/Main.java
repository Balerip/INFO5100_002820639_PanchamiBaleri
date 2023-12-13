public class Main {
    public static void main(String[] args)
    {
        System.out.println();
        //Creating apartment class objects
        Apartment a1=new Apartment("Flat", "Modern", "Wooden",4, 36, 786, 2, 2542);
        a1.check_maintainence_ease();
        System.out.println();
        Apartment a2=new Apartment("Independent House","Old","Carpet",2,90,2000,5,10800);
        a2.display_apartment_info();
        System.out.println();
        Apartment a3=new Apartment("Flat","Old","Carpet",1,75,1000,3,3200);
        a3.yearly_rent();
        System.out.println();
        //Creating bag class objects
        Bag b1=new Bag("Tote",50.0,"black",400.0,"Marc Jacobs",true,325,"cloth");
        b1.bag_holding_capacity(45);
        System.out.println();
        Bag b2=new Bag("bagpack",30.0,"yellow",300.0,"Adidas",true,30,"cloth");
        b2.purpose();
        System.out.println();
        Bag b3=new Bag("Handbag",40.0,"White",300.0,"COACH",false,395,"cotton");
        b3.bag_sustainability();
        System.out.println();
        //Creating book class objects
        Book bo1=new Book("NancyDrew",250,"Carolyn Keene","Mystery",15.99,true,"English",false);
        bo1.read();
        System.out.println();
        Book bo2= new Book("The Alchemist",166,"Paulo Coehlo","Drama",14.61,true,"English",true);
        bo2.is_available_online();
        System.out.println();
        Book bo3=new Book("The Fault in Our Stars",316,"John Green","Romance",15,true,"English",true);
        bo3.is_expensive();
        System.out.println();
        //Creating Bottle class
        Bottle bot1=new Bottle("black","Soda",16.9,"plastic",false,"Coca-Cola",13.0,false);
        bot1.bottle_hold_capacity(15.0);
        System.out.println();
        Bottle bot2=new Bottle("white","wine",25.0,"glass",true,"Decoy",25.4,true);
        bot2.drink_type();
        System.out.println();
        Bottle bot3=new Bottle("white","Water",16.9,"steel",true,"evian",16.9,false);
        bot3.effect_on_carbon_footprint();
        System.out.println();
        //Craeting ClassRoom class
        ClassRoom c1=new ClassRoom(1045,"offline","Powerpoints",50,"Priya","Sonal","Projector");
        c1.teach();
        System.out.println();
        ClassRoom c2=new ClassRoom(902,"online","Worksheets",45,"Anusha","Tanya","Blackboard");
        System.out.println(c2.mode_of_instruction());
        System.out.println();
        ClassRoom c3=new ClassRoom(708,"Offline","Presentation",70,"Manoj","Navin","Blackboard");
        c3.teaching_aid();
        System.out.println();


        //Creating Computer class
        Computer co1=new Computer("Personal Computer","1GB","HP","Windows 10","Intel Iris Xe",30.0,1000.0,"does not need external battery,works till power is turned ON");
        co1.computer_portability();
        System.out.println();
        Computer co2=new Computer("Laptop","24GB","Dell","Window 10","Intel Graphics",24.0,800.0,"lasts upto 8 hrs");
        co2.display_computer_info();
        System.out.println();
        Computer co3=new Computer("Tablet","16 GB","Samsung","Android 10","Adreno 506",8.0,300.0,"Lasts for 4-5 hrs");
        co3.screen_size();
        System.out.println();
        //Creating inner class CPU object for Computer class
        Computer.CPU cp1=co1.new CPU("Intel Core i7-10700K", 8);
        cp1.print_cpu_info();
        //Creating inner class Keyboard object for Computer class
        Computer.Keyboard k1=co1.new Keyboard("Logitech", "K380", "Wireless");
        k1.adjustBacklitIntensity(50);
        System.out.println();

        //Creating Restaurant Class
        Restaurant r1=new Restaurant("BBC",10,4,"Ramen",4.0,true,30,true);
        r1.chef_special_availability();
        System.out.println();
        Restaurant r2=new Restaurant("IDC",8,6,"South-Indian",3.5,false,20,true);
        r2.restaurant_popularity();
        System.out.println();
        Restaurant r3=new Restaurant("Chang's",9,7,"Chineese Noodles",4.5,true,50,false);
        r3.seating_capacity();
        System.out.println();
        //Creating Student Class
        Student s1=new Student("Anusha",1001,25,"CS",6000.0,3,"A","DJS");
        s1.enroll();
        System.out.println();
        Student s2=new Student("Myra",1051,23,"Extc",4500,3,"B+","ASU");
        s2.pay_fees();
        System.out.println();
        Student s3=new Student("Mihir",2001,27,"Mechanical",4000,3,"A","MTU");
        s3.scholarship_eligibility();
        System.out.println();
        //Creating Television Class
        Television t1=new Television("Sony","Smart-Tv",55,"UHD","Dolby","HDMI",true,true);
        t1.compatibility();
        System.out.println();
        Television t2=new Television("Samsung", "OLED", 65.0, "8K", "DTS:X", "HDMI, USB, Ethernet", true, false);
        t2.is_energy_efficient();
        System.out.println();
        Television t3=new Television("Sony", "LED", 30, "4K", "Dolby Atmos", "USB", true, false);
        t3.viewing_experience();
        System.out.println();
        //Creating Wadrobe class
        Wardrobe w1 = new Wardrobe("IKEA", "Wood", 200.0, 120.0, 4, 3, true, "Sliding");
        w1.is_detachable();
        System.out.println();
        Wardrobe w2=new Wardrobe("Hometown", "Metal", 180.0, 90.0, 5, 2, false, "Hinged");
        w2.is_multipurpose();
        System.out.println();
        Wardrobe w3=new Wardrobe("KingsBrand", "MDF", 220.0, 150.0, 6, 4, true, "Sliding");
        w3.structure();
        System.out.println();
    }
}




