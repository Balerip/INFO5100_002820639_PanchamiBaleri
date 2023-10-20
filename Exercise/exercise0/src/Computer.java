import java.util.UUID;

class Computer {
    UUID computer_id;
    String type;
    String RAM;
    String brand;
    String operating_system;

    String graphics;
    Double size;
    Double price;

    String battery_life;

    Computer(String type, String RAM, String brand, String operating_system, String graphics, Double size, Double price, String battery_life) {
        this.computer_id = UUID.randomUUID();
        this.type = type;
        this.RAM = RAM;
        this.brand = brand;
        this.operating_system = operating_system;
        this.graphics = graphics;
        this.size = size;
        this.price = price;
        this.battery_life = battery_life;
        System.out.println("Instance of Computer class created with unique id"+computer_id);
    }

    public void computer_portability() {
        if (this.type == "Personal Computer") {
            System.out.println("The" + this.type + "is not portable");
        } else if (this.type == "Laptop") {
            System.out.println("The" + this.type + "is portable");
        }
    }

    public void display_computer_info() {
        System.out.println("The computer type is:" + this.type);
        System.out.println("The computer RAM is:" + this.RAM);
        System.out.println("The computer brand is:" + this.brand);
        System.out.println("The computer operating system is:" + this.operating_system);
        System.out.println("The computer processing power is:" + this.graphics);
        System.out.println("The computer size is:" + this.size);
        System.out.println("The computer price is:" + this.price);
        System.out.println("The computer price is:" + this.battery_life);
    }

    public void screen_size() {
        if (this.type == "Personal Computer") {
            System.out.println("The" + this.type + "can be used for purposes that require big screen");
        } else if (this.type == "Laptop") {
            System.out.println("The" + this.type + "can be used for purposes that does not require big screen");
        } else {
            System.out.println("The" + this.type + "is used for purposes that needs reading and basic stuff");
        }

    }

    class CPU {
        String model;

        int numberOfCores;

        CPU(String model, int numberOfCores) {
            this.model = model;
            this.numberOfCores = numberOfCores;
        }

        public void print_cpu_info() {
            System.out.println("The computer object created has the mentioned CPU properties" + this.model + Integer.toString(this.numberOfCores));

        }
    }

    class Keyboard {
        UUID Keyboard_id;
        String brand;
        String model;
        String connection_type;

        Keyboard(String brand, String model, String Connection_type) {
            this.Keyboard_id = UUID.randomUUID();
            this.brand = brand;
            this.model = model;
            this.connection_type = connection_type;
        }

        public void adjustBacklitIntensity(int intensity) {
            System.out.println("Adjusting backlight intensity to " + intensity + "%");
        }
    }
}
