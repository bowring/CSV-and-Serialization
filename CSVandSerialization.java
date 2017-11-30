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
    static ArrayList<Person> getList(Scanner fileScanner){
        ArrayList<Person> list = new ArrayList<>();
        while(fileScanner.hasNextLine())
            list.add(getPerson(fileScanner.nextLine()));
        return list;
    }

    //makes list of persons on file
    static void makeList(ArrayList<Person> list) throws Exception{
        FileOutputStream finalFile = new FileOutputStream("People");
        PrintWriter fileWriter = new PrintWriter(finalFile);
        for(int i = 0; i < list.size(); i++)
            fileWriter.println(list.get(i).getFirstName() + ", "
                + list.get(i).getLastName() + ", " + list.get(i).getDOB());
        fileWriter.close();
    }

    //gets more people from user
    static void getPeople(String entry, Scanner userInput, ArrayList<Person> list){
        while(!entry.equals("q")){            
            if(entry.equals("a"))
                for(int i = 0; i < list.size(); i++)
                    System.out.println(list.get(i));
            else if(!entry.equals(""))
                list.add(getPerson(entry));
            System.out.println("To add new people enter people in the form \"first name, last name, DOB\", enter q to quit,");
            System.out.println("or to  see current people on file enter a:" );
            entry = userInput.nextLine();
        }
    }

    static Person getPerson(String entry){
        String firstName = entry.substring(0, entry.indexOf(",")).trim();
        String lastName = entry.substring(entry.indexOf(",") + 1, entry.lastIndexOf(",")).trim();
        String DOB = entry.substring(entry.lastIndexOf(",") + 1).trim();
        return new Person(firstName, lastName, DOB);
    }
}