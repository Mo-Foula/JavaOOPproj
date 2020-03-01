package testtststs;
import java.util.ArrayList;
public class Patient extends Person{
     String CaseType; 
     String DR;
     int Room;

    public String getCaseType() {
        return CaseType;
    }

    public void setCaseType(String CaseType) {
        this.CaseType = CaseType;
    }

    public Patient(int Room, String Name, Integer ID, String ADdress, Integer Code, Integer Age) {
        super(Name, ID, ADdress, Code, Age);
        this.Room = Room;
    }

    public String getDR() {
        return DR;
    }

    public void setDR(String DR) {
        this.DR = DR;
    }

    public int getRoom() {
        return Room;
    }

    public void setRoom(int Room) {
        this.Room = Room;
    }
    

    public Patient(  String Name, Integer ID , Integer Code, String ADdress, Integer Age ,String CaseType, String DR, int Room) {
        super(Name, ID, ADdress, Code, Age);
        this.CaseType = CaseType;
        this.DR = DR;
        this.Room = Room;
        
    }


    
}