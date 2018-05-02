package carrental;
// Generated May 1, 2018 2:30:41 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Customers generated by hbm2java
 */
public class Customers  implements java.io.Serializable {


     private Integer id;
     private String username;
     private String name;
     private String password;
     private String contactNo;
     private String email;
     private String address;
     private Integer fine;
     private Set customerbookingses = new HashSet(0);

    public Customers() {
    }

	
    public Customers(String username, String name, String password, String contactNo, String email, String address) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.contactNo = contactNo;
        this.email = email;
        this.address = address;
    }
    public Customers(String username, String name, String password, String contactNo, String email, String address, Integer fine, Set customerbookingses) {
       this.username = username;
       this.name = name;
       this.password = password;
       this.contactNo = contactNo;
       this.email = email;
       this.address = address;
       this.fine = fine;
       this.customerbookingses = customerbookingses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getContactNo() {
        return this.contactNo;
    }
    
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getFine() {
        return this.fine;
    }
    
    public void setFine(Integer fine) {
        this.fine = fine;
    }
    public Set getCustomerbookingses() {
        return this.customerbookingses;
    }
    
    public void setCustomerbookingses(Set customerbookingses) {
        this.customerbookingses = customerbookingses;
    }




}

