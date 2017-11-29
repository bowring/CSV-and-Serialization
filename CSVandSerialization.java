/**
 * Testing CSV and Serialization
 *
 * @author Ryan Barrett
 * @version November 29, 2017
 */
import java.util.*;
import java.io.*;
public class CSVandSerialization
{
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        ArrayList<Person> list = null;

        try{
            FileInputStream fileReader = new FileInputStream("People");
            Scanner fileScanner = new Scanner(fileReader);
            list = getList(fileScanner);
            System.out.println("Current people on file: ");
            for(int i = 0; i < list.size(); i++)
                System.out.println(list.get(i));
            String entry = "";
            getPeople(entry, userInput, list);
            makeList(list);
        }catch(Exception e){
            System.out.println("Something went wrong");
        }
    }

    //returns list of persons
    public static ArrayList<Person> getList(Scanner fileScanner){
        ArrayList<Person> list = new ArrayList<>();
        while(fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            String firstName = line.substring(0, line.indexOf(","));
            String lastName = line.substring(line.indexOf(",") + 1, line.lastIndexOf(","));
            String DOB = line.substring(line.lastIndexOf(",") + 1);
            firstName.trim();
            lastName.trim();
            DOB.trim();
            list.add(new Person(firstName, lastName, DOB));
        }
        return list;
    }

    //makes list of persons on file
    public static void makeList(ArrayList<Person> list) throws Exception{
        FileOutputStream finalFile = new FileOutputStream("People");
        PrintWriter fileWriter = new PrintWriter(finalFile);
        for(int i = 0; i < list.size(); i++)
            fileWriter.print(list.get(i).getFirstName() + ", "
                + list.get(i).getLastName() + ", " + list.get(i).getDOB());
        fileWriter.close();
    }

    //gets more people from user
    public static void getPeople(String entry, Scanner userInput, ArrayList<Person> list){
        while(!entry.equals("q")){
            if(!entry.equals("")){
                String line = userInput.nextLine();
                String firstName = line.substring(0, line.indexOf(","));
                String lastName = line.substring(line.indexOf(",") + 1, line.lastIndexOf(","));
                String DOB = line.substring(line.lastIndexOf(",") + 1);
                firstName.trim();
                lastName.trim();
                DOB.trim();
                list.add(new Person(firstName, lastName, DOB));
            }
            if(entry.equals("a"))
                for(int i = 0; i < list.size(); i++)
                    System.out.println(list.get(i));
            System.out.println("To add new people enter people in the form first name, last name, DOB or enter q to quit");
            System.out.println("To see current people on file enter a :" );
            entry = userInput.nextLine();
        }
    }
}