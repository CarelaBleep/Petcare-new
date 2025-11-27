package petcare;

public class Owner {
    private String name;
    private String contactNumber;
    private String address;

    public Owner(String name, String contactNumber, String address) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    public String getName() { 
        return name; 
    }
    public String getContactNumber() { 
        return contactNumber; 
    }
    public String getAddress() { 
        return address; 
    }

    public void setContactNumber(String contactNumber) { 
        this.contactNumber = contactNumber; 
    }
    public void setAddress(String address) { 
        this.address = address; 
    }

    @Override
    public String toString() {
        return "Owner: " + name + ", Contact: " + contactNumber + ", Address: " + address;
    }
}
