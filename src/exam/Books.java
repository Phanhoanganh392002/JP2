package exam;

public class Books {
     String ID,Name,Author;
     Double Price;
    public Books(){

    }
    public Books(String ID, String name, String author, Double price) {
        this.ID = ID;
        Name = name;
        Author = author;
        Price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }
}
