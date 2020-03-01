/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtststs;

/**
 *
 * @author Mohamed Foula
 */
public class Doctor extends Person {

    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String Speciality) {
        this.Speciality = Speciality;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double Salary) {
        this.Salary = Salary;
    }

    //name id add code age
    private String Speciality;
    private Double Salary;
    
    public Doctor(String Name, Integer ID, Integer Code,String ADdress,  Integer Age, String Speciality, double Salary) {
        super(Name, ID, ADdress, Code, Age);
        this.Speciality = Speciality;
        this.Salary = Salary;
    }
}
    
  
/*
create table doctor( name varchar(70) not null, id number(20), code number(5),address varchar(100),age number (3),speciality varchar(30),salary number(10,2),primary key(name));
  insert into doctor values ('Ali',1215425,300,'Mandara',29,'Emergencies',7250.49);
*/