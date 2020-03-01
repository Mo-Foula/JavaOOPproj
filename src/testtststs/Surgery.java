/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtststs;

public class Surgery {
    int code;
    String name;
    String Pname;
    String dr;
    String bookeddate;

    public int getCode() {
        return code;
    }

    public Surgery(int code, String name, String dr, String bookeddate) {
        this.code = code;
        this.name = name;
        this.dr = dr;
        this.bookeddate = bookeddate;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPname() {
        return Pname;
    }

    public Surgery(int code, String name, String Pname, String dr, String bookeddate) {
        this.code = code;
        this.name = name;
        this.Pname = Pname;
        this.dr = dr;
        this.bookeddate = bookeddate;
    }

    public void setPname(String Pname) {
        this.Pname = Pname;
    }

    public String getDr() {
        return dr;
    }

    public void setDr(String dr) {
        this.dr = dr;
    }

    public String getBookeddate() {
        return bookeddate;
    }

    public void setBookeddate(String bookeddate) {
        this.bookeddate = bookeddate;
    }
    
}
