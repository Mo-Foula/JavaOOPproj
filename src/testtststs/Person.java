package testtststs;


import java.util.ArrayList;

/*
-Name: String
-ID: String
-Code: int
-Address: String
-Age: int
name id add code age
*/
public abstract class Person {
    public String Name,ADdress;
    public Integer Code,Age,ID;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getADdress() {
        return ADdress;
    }

    public void setADdress(String ADdress) {
        this.ADdress = ADdress;
    }

    public Integer getCode() {
        return Code;
    }

    public void setCode(Integer Code) {
        this.Code = Code;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer Age) {
        this.Age = Age;
    }

    public Person(String Name, Integer ID, String ADdress, Integer Code, Integer Age) {
        this.Name = Name;
        this.ID = ID;
        this.ADdress = ADdress;
        this.Code = Code;
        this.Age = Age;
    }
    public static <T extends Person , E> T search(ArrayList<T> a,E aa){
       
        String v= aa.getClass().getSimpleName();
        if (v.equals("Integer"))
        for (int i = 0; i < a.size(); i++) {
            if (aa.equals(a.get(i).getID()))
                return a.get(i);
        }
        else if (v.equals("String"))
             for (int i = 0; i < a.size(); i++) {
            if (aa.equals(a.get(i).getName()))
                return a.get(i);
        }
        
        return null;
    }
    
//    public abstract <T extends Person,E>  void update(ArrayList<T> a,E aa)
//            ;
    public <T extends Person> void upd_ID ( T a,String Name, String ADdress, int Code, Integer Age) {
     a.setADdress(ADdress);
     a.setAge(Age);a.setCode(Code);a.setName(Name);
    }
    public <T extends Person> void upd_Name ( T a,Integer ID, String ADdress, Integer Code, Integer Age) {
     a.setADdress(ADdress);
     a.setAge(Age);a.setCode(Code);a.setID(ID);}}