import java.util.UUID;

class Book {
    UUID book_id;
    String book_title;
    int no_of_pages;
    String author;
    String genre;
    double price;
    boolean readers_choice;
    String language;
    boolean softcopy_available;

    public Book(String book_title, int no_of_pages, String author, String genre, double price, boolean readers_choice, String language, boolean softcopy_available) {
        this.book_id= UUID.randomUUID();
        this.book_title = book_title;
        this.no_of_pages = no_of_pages;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.readers_choice = readers_choice;
        this.language = language;
        this.softcopy_available = softcopy_available;
        System.out.println("Instance of Book class created with unique id"+book_id);
    }

    public void read()
    {
        System.out.print("You can read the book");
    }
    public void is_expensive()
    {
        if(this.price>14.0)
        {
            System.out.print("The book is expensive");
        }
    }

    public void is_available_online()
    {
        if(this.softcopy_available)
        {
            System.out.println("The book is available online");
        }
    }


}
