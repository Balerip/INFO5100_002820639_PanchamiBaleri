import java.util.UUID;

class Television {
    UUID television_id;
    String brand;
    String type;

    double size;

    String picture_quality;

    String sound_quality;

    String ports;

    boolean screen_mirroring_enabled;

    boolean enables_power_saving;

    Television(String brand,String type,double size,String picture_quality,String sound_quality, String ports,boolean screen_mirroring_enabled,boolean enables_power_saving)
    {
        this.television_id= UUID.randomUUID();
        this.brand=brand;
        this.size=size;
        this.picture_quality=picture_quality;
        this.sound_quality=sound_quality;
        this.ports=ports;
        this.screen_mirroring_enabled=screen_mirroring_enabled;
        this.enables_power_saving=enables_power_saving;
        System.out.println("Instance of Television class created with unique id"+television_id);

    }

    public void is_energy_efficient()
    {
        if(this.enables_power_saving)
        {
            System.out.println("The television has automatic power saving and goes on stand_by when not in use");
        }
        else
        {
            System.out.println("Try to buy television with power saving features enabled");
        }
    }
    public void compatibility()
    {
        if(this.type=="Smart-Tv")
        {
            System.out.print("The television is compatible with most devices");
        }
        else
        {
            System.out.print("The television is not compatible with other devices");
        }
    }

    public void viewing_experience()
    {
        if(this.screen_mirroring_enabled)
        {
            System.out.print("Can be used to mirror content from other devices and gives better viewing experience");
        }
        else
        {
            System.out.print("Cannot be used to mirror content from other devices");
        }
    }



}
