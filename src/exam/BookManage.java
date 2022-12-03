package exam;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BookManage {
    private ArrayList<Books> BookList = new ArrayList<Books>();

    Scanner sc = new Scanner(System.in);
    //input
    public String inputID() {
        System.out.print("Input book ID: ");
        String ID = sc.nextLine();
        return ID;
    }
    public String inputName() {
        System.out.print("Input Name: ");
        String Name = sc.nextLine();
        return Name;
    }
    public String inputAuthor() {
        System.out.print("Input Author: ");
        String lastname = sc.nextLine();
        return lastname;
    }
    public int inputPrice() {
        System.out.print("Input Price: ");
        while (true) {
            try {
                int age = sc.nextInt();
                if (age < 0 && age > 150) {
                    throw new NumberFormatException("age is greater than 0 and must be less than 200");
                }
                return age;
            } catch (NumberFormatException ex) {
                System.out.print("Invalid! Input book ID again: ");
            }
        }
    }

    public void addBook(){
        String ID = inputID();
        String Name = inputName();
        String Author = inputAuthor();
        double Price = inputPrice();

        Books student = new Books(ID, Name, Author,  Price);
        BookList.add(new Books());
    }



    public void saveBook() throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream("book.txt");
            DataOutputStream dos = new DataOutputStream(fos);

            //read file
            FileInputStream fis = new FileInputStream("book.txt");
            DataInputStream dis = new DataInputStream(fis);
            String txt = dis.readLine();
            while (txt != null) {
                System.out.println(txt);
                txt = dis.readLine();
            }
        } catch (FileNotFoundException f) {
            System.out.println("File not found");
        } catch (IOException io) {
            System.out.println("Error...");
        }
    }

    //read files -> show student
    public void readFiles() throws IOException, ClassNotFoundException {
        File f = new File("books.txt");
        FileInputStream fin = new FileInputStream(f);
        ObjectInputStream objin = new ObjectInputStream(fin);

        BookList = new ArrayList<Books>();
        BookList = (ArrayList)objin.readObject();

        showBook();

        objin.close();
        fin.close();
    }

    public void showBook() {
        if (BookList.size()==0){
            System.out.println("List is empty");
        }
        else{
            System.out.println("|   EnrolID   |      Full name      |  Age  |");
            System.out.print("=============================================\n");
            for (Books st : BookList) {
                System.out.format("| %11s | %19s | %5d |\n",st.getID(),st.getName() + " " + st.getAuthor(),st.getPrice());
            }
        }
    }

}