package petcare;

public class Appointment {
    private Pet pet;
    private String date;
    private String reason;

    public Appointment(Pet pet, String date, String reason) {
        this.pet = pet;
        this.date = date;
        this.reason = reason;
    }

    public Pet getPet() { 
        return pet; 
    }
    public String getDate() { 
        return date;
    }
    public String getReason() { 
        return reason; 
    }

    @Override
    public String toString() {
        return "Appointment for " + pet.getName() +
               " on " + date +
               " | Reason: " + reason;
    }
}
