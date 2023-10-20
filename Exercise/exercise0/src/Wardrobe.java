import java.util.UUID;

class Wardrobe {
        UUID wardrobe_id;
        String brand;
        String material;
        double height;
        double width;

        int no_of_drawers;
        int no_of_shelves;
        boolean has_mirror;
        String door_type;

        public Wardrobe(String brand, String material, double height, double width, int no_of_drawers, int no_of_shelves, boolean has_mirror, String door_type) {
            this.wardrobe_id= UUID.randomUUID();
            this.brand = brand;
            this.material = material;
            this.height = height;
            this.width = width;
            this.no_of_drawers = no_of_drawers;
            this.no_of_shelves = no_of_shelves;
            this.has_mirror = has_mirror;
            this.door_type = door_type;
            System.out.println("Instance of Wardrobe class created with unique id"+wardrobe_id);
        }

        public void is_detachable()
        {
            if (this.brand=="ikea")
            {
                System.out.println("The wardrobe is deatchable and needs to be fixed manually");
            }
            else
            {
                System.out.println("The wardrobe is not deatchable and need not be fixed manually");
            }
        }

        public void is_multipurpose()
        {
            if(this.has_mirror)
            {
                System.out.println("The wardrobe is multipurpose");
            }
            else
            {
                System.out.println("The wardrobe is not multipurpose");
            }
        }

        public void structure()
        {
            if(this.door_type=="sliding")
            {
                System.out.println("The wardrobe has sliding doors");
            }
            else if (this.door_type=="open")
            {
                System.out.println("The wardrobe has doors which can be opened");
            }
            else
            {
                System.out.println("The wardrobe has only drawers");
            }
        }

}


