
/**
 * Creates people
 *
 * @author Ryan Barrett
 * @version November 29, 2017
 */
public class Person
{
    private String firstName;
    private String lastName;
    private String DOB;
    
    public Person(String f, String l, String d){
        firstName = f;
        lastName = l;
        DOB = d;
    }
    
    public String getFirstName(){return firstName;}
    public void setFirstName(String f){firstName = f;}
    public String getLastName(){return lastName;}
    public void setLastName(String l){lastName = l;}
    public String getDOB(){return DOB;}
    public void setDOB(String d){DOB = d;}
    public String toString(){return firstName + " " + lastName + " " + DOB;}
}