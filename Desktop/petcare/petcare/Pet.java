package petcare;

public class Pet {
    private String name;
    private String species;
    private int age;
    private String vaccinationStatus;
    private Owner owner;

    public Pet(String name, String species, int age, String vaccinationStatus, Owner owner) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.vaccinationStatus = vaccinationStatus;
        this.owner = owner;
    }

    public String getName() { 
        return name; 
    }
    public String getSpecies() { 
        return species; 
    }
    public int getAge() { 
        return age; 
    }

    public String getVaccinationStatus() { return vaccinationStatus; }
    public Owner getOwner() { return owner; }

    public void setVaccinationStatus(String vaccinationStatus) { 
        this.vaccinationStatus = vaccinationStatus; 
    }

    @Override
    public String toString() {
        return "Pet: " + name + " (" + species + ", " + age + " yrs)\n"
             + "Vaccination: " + vaccinationStatus + "\n"
             + owner.toString();
    }
}
