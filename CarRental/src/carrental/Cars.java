package carrental;
// Generated May 1, 2018 2:30:41 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Cars generated by hbm2java
 */
public class Cars  implements java.io.Serializable {


     private String registrationNo;
     private String make;
     private String model;
     private int rentRate;
     private String availability;
     private byte[] image;
     private Set customerbookingses = new HashSet(0);

    public Cars() {
    }

	
    public Cars(String registrationNo, String make, String model, int rentRate, String availability) {
        this.registrationNo = registrationNo;
        this.make = make;
        this.model = model;
        this.rentRate = rentRate;
        this.availability = availability;
    }
    public Cars(String registrationNo, String make, String model, int rentRate, String availability, byte[] image, Set customerbookingses) {
       this.registrationNo = registrationNo;
       this.make = make;
       this.model = model;
       this.rentRate = rentRate;
       this.availability = availability;
       this.image = image;
       this.customerbookingses = customerbookingses;
    }
   
    public String getRegistrationNo() {
        return this.registrationNo;
    }
    
    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }
    public String getMake() {
        return this.make;
    }
    
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return this.model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    public int getRentRate() {
        return this.rentRate;
    }
    
    public void setRentRate(int rentRate) {
        this.rentRate = rentRate;
    }
    public String getAvailability() {
        return this.availability;
    }
    
    public void setAvailability(String availability) {
        this.availability = availability;
    }
    public byte[] getImage() {
        return this.image;
    }
    
    public void setImage(byte[] image) {
        this.image = image;
    }
    public Set getCustomerbookingses() {
        return this.customerbookingses;
    }
    
    public void setCustomerbookingses(Set customerbookingses) {
        this.customerbookingses = customerbookingses;
    }




}

