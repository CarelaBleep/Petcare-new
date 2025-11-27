package petcare;

import java.io.*;
import java.util.*;

public class PetCareSystem {

    static final String FILE_NAME = "petcare_records.txt";
    
    // ANSI Color Codes
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String PURPLE = "\u001B[35m";
    static final String CYAN = "\u001B[36m";
    static final String WHITE = "\u001B[37m";
    static final String BRIGHT_GREEN = "\u001B[92m";
    static final String BRIGHT_YELLOW = "\u001B[93m";
    static final String BRIGHT_CYAN = "\u001B[96m";
    static final String BRIGHT_MAGENTA = "\u001B[95m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        // Show welcome animation
        showWelcomeAnimation();

        do {
            displayMenu();
            System.out.print(CYAN + "Choose an option: " + RESET);
            choice = sc.nextInt();
            sc.nextLine(); // clear newline

            switch (choice) {
                case 1 -> createRecord(sc);
                case 2 -> readRecords();
                case 3 -> updateRecord(sc);
                case 4 -> deleteRecord(sc);
                case 5 -> {
                    showExitAnimation();
                    System.out.println(YELLOW + "Exiting system..." + RESET);
                }
                default -> System.out.println(RED + "✗ Invalid choice!" + RESET);
            }
        } while (choice != 5);

        sc.close();
    }

    // ========== ANIMATIONS ==========
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

 private static void showWelcomeAnimation() {
    System.out.println("\n" + BLUE);
    String[] hello = {
        "┌─────────────────────────────────────────────────────────────────────────────┐",
        "│                                                                             │",
        "│" + YELLOW + "               ██▀▀█ ██▀▀▀ █▀▀▀█▀▀▀ ██▀▀▀  ██▀▀█  ██▀▀█  ██▀▀▀    " + BLUE +"           │",
        "│" + YELLOW + "               ██▄▄█ ██▄▄     █    ██     ██▄▄█  ██▄▄▀  ██▄▄      " + BLUE +"           │",
        "│" + YELLOW + "               ██    ██▀▀     █    ██     ██  █  ██ ▀█  ██▀▀       " + BLUE +"          │",
        "│ " + YELLOW + "              ██    ██▄▄▄    █    ██▄▄▄  ██  █  ██  █  ██▄▄▄     " + BLUE +"           │",
        "│                                                                             │",
        "│                                                                             │",
        "│                                                                             │",
        "│                       Welcome to the PetCare System!                        │",
        "│                                                                             │",
        "│" + WHITE + "                                 (\\__/)                                      " + BLUE + "│",
        "│" + WHITE + "                                 ( •.•)                                      " + BLUE + "│",
        "│" + WHITE + "                                 / > ♥                                       " + BLUE + "│",
        "└─────────────────────────────────────────────────────────────────────────────┘"
    };

    for (String hlines : hello) {
        System.out.println(hlines);
        sleep(80);
    }

    System.out.println(RESET);
}



    private static void showExitAnimation() {
        System.out.println("\n" + BRIGHT_YELLOW);
        String[] bye = {
            "  ____                 _ _                _ ",
            " / ___| ___   ___   __| | |__  _   _  ___| |",
            "| |  _ / _ \\ / _ \\ / _` | '_ \\| | | |/ _ \\ |",
            "| |_| | (_) | (_) | (_| | |_) | |_| |  __/_|",
            " \\____|\\___/ \\___/ \\__,_|_.__/ \\__, |\\___(_)",
            "                                |___/        "
        };
        
        for (String line : bye) {
            System.out.println(line);
            sleep(80);
        }
        System.out.println(RESET);
        
        // Pet waving goodbye
        System.out.println(WHITE + "      /\\_/\\  " + RESET);
        System.out.println(WHITE + "     ( ^.^ ) " + RESET + YELLOW + "  *wave*" + RESET);
        System.out.println(WHITE + "      > ^ <  " + RESET);
        sleep(1000);
    }

    private static void displayMenu() {
        System.out.println(BLUE + "┌─────────────────────────────────────────────────────────────────────────────┐" + RESET);
        System.out.println(BRIGHT_CYAN + "│  " + YELLOW + "PetCare Menu" + BRIGHT_CYAN + "                                                               │" + RESET);
        System.out.println(BLUE + "│─────────────────────────────────────────────────────────────────────────────│" + RESET);
        System.out.println(BRIGHT_CYAN + "│ " + GREEN + "1." + YELLOW + "Create Record" + BRIGHT_CYAN + "                                                             │" + RESET);
        System.out.println(BRIGHT_CYAN + "│ " + GREEN + "2." + YELLOW + "View All Records" + BRIGHT_CYAN + "                                                          │" + RESET);
        System.out.println(BRIGHT_CYAN + "│ " + GREEN + "3." + YELLOW + "Update Record" + BRIGHT_CYAN + "                                                             │" + RESET);
        System.out.println(BRIGHT_CYAN + "│ " + GREEN + "4." + YELLOW + "Delete Record" + BRIGHT_CYAN + "                                                             │" + RESET);
        System.out.println(BRIGHT_CYAN + "│ " + GREEN + "5." + RED + "Exit" + BRIGHT_CYAN + "                                                                      │" + RESET);
        System.out.println(BLUE + "└─────────────────────────────────────────────────────────────────────────────┘" + RESET);
    }

    private static void showLoadingAnimation(String message) {
        String[] spinner = {"⠋", "⠙", "⠹", "⠸", "⠼", "⠴", "⠦", "⠧", "⠇", "⠏"};
        for (int i = 0; i < 20; i++) {
            System.out.print("\r" + CYAN + spinner[i % spinner.length] + " " + message + "..." + RESET);
            sleep(50);
        }
        System.out.print("\r" + " ".repeat(50) + "\r");
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // ========== CREATE ==========
    private static void createRecord(Scanner sc) {
        System.out.println("\n" + BRIGHT_YELLOW + "Adding New Pet Record" + RESET);
        
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            // Pet info
            System.out.print(CYAN + "Enter Pet Name: " + RESET);
            String petName = sc.nextLine();
            System.out.print(CYAN + "Enter Species: " + RESET);
            String species = sc.nextLine();
            System.out.print(CYAN + "Enter Age: " + RESET);
            String age = sc.nextLine();
            System.out.print(CYAN + "Enter Vaccination Status: " + RESET);
            String vacc = sc.nextLine();
            
            // Owner info (COMPLETE)
            System.out.print(CYAN + "Enter Owner Name: " + RESET);
            String ownerName = sc.nextLine();
            System.out.print(CYAN + "Enter Owner Contact Number: " + RESET);
            String contactNumber = sc.nextLine();
            System.out.print(CYAN + "Enter Owner Address: " + RESET);
            String address = sc.nextLine();
            
            // Appointment info
            System.out.print(CYAN + "Enter Appointment Date (yyyy-MM-dd): " + RESET);
            String date = sc.nextLine();
            
            // ... date validation ...
            
            System.out.print(CYAN + "Enter Reason: " + RESET);
            String reason = sc.nextLine();

            showLoadingAnimation("Saving record");

            // NEW CSV FORMAT with all 9 fields
            writer.write(petName + "," + species + "," + age + "," + vacc + "," +
                        ownerName + "," + contactNumber + "," + address + "," +
                        date + "," + reason + "\n");
            
            System.out.println(GREEN + "✓ Record added successfully!" + RESET);
        } catch (IOException e) {
            System.out.println(RED + "✗ Error writing file: " + e.getMessage() + RESET);
        }
    }

    // ========== READ ==========
    private static void readRecords() {
        showLoadingAnimation("Loading records");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n" + BRIGHT_MAGENTA + "╔══════════════════════════════════════════════╗" + RESET);
            System.out.println(BRIGHT_MAGENTA + "║        PetCare Records Database              ║" + RESET);
            System.out.println(BRIGHT_MAGENTA + "╚══════════════════════════════════════════════╝" + RESET);
            
            int count = 0;
            while ((line = reader.readLine()) != null) {
                count++;
                String[] data = line.split(",");
                System.out.println("\n" + YELLOW + "Record #" + count + RESET);
                System.out.println(CYAN + "Pet: " + RESET + WHITE + data[0] + GREEN + " (" + data[1] + ", " + data[2] + " yrs)" + RESET);
                System.out.println(CYAN + "Vaccination: " + RESET + BRIGHT_GREEN + data[3] + RESET);
                System.out.println(CYAN + "Owner: " + RESET + WHITE + data[4] + RESET);
                System.out.println(CYAN + "Contact: " + RESET + WHITE + data[5] + RESET);
                System.out.println(CYAN + "Address: " + RESET + WHITE + data[6] + RESET);
                System.out.println(CYAN + "Appointment: " + RESET + BRIGHT_YELLOW + data[7] + RESET + " | " + data[8]);
            }
            
            if (count == 0) {
                System.out.println(YELLOW + "\nNo records found yet." + RESET);
            }
        } catch (FileNotFoundException e) {
            System.out.println(YELLOW + "\nNo records found yet." + RESET);
        } catch (IOException e) {
            System.out.println(RED + "✗ Error reading file: " + e.getMessage() + RESET);
        }
    }

    // ========== UPDATE ==========
    private static void updateRecord(Scanner sc) {
        System.out.print(CYAN + "\nEnter Pet Name to update: " + RESET);
        String petToUpdate = sc.nextLine();

        List<String> lines = new ArrayList<>();
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equalsIgnoreCase(petToUpdate)) {
                    found = true;
                    System.out.print(CYAN + "Enter new Vaccination Status: " + RESET);
                    data[3] = sc.nextLine();
                    line = String.join(",", data);
                    showLoadingAnimation("Updating record");
                    System.out.println(GREEN + "✓ Record updated!" + RESET);
                }
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println(RED + "✗ Error reading file: " + e.getMessage() + RESET);
            return;
        }

        if (found) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (String l : lines) {
                    writer.write(l + "\n");
                }
            } catch (IOException e) {
                System.out.println(RED + "✗ Error saving file: " + e.getMessage() + RESET);
            }
        } else {
            System.out.println(RED + "✗ Pet not found." + RESET);
        }
    }

    // ========== DELETE ==========
    private static void deleteRecord(Scanner sc) {
        System.out.print(CYAN + "\nEnter Pet Name to delete: " + RESET);
        String petToDelete = sc.nextLine();

        List<String> lines = new ArrayList<>();
        boolean deleted = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (!data[0].equalsIgnoreCase(petToDelete)) {
                    lines.add(line);
                } else {
                    deleted = true;
                }
            }
        } catch (IOException e) {
            System.out.println(RED + "✗ Error reading file: " + e.getMessage() + RESET);
            return;
        }

        if (deleted) {
            showLoadingAnimation("Deleting record");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String l : lines) {
                writer.write(l + "\n");
            }
        } catch (IOException e) {
            System.out.println(RED + "✗ Error saving file: " + e.getMessage() + RESET);
        }

        if (deleted)
            System.out.println(GREEN + "✓ Record deleted!" + RESET);
        else
            System.out.println(RED + "✗ Pet not found." + RESET);
    }
}
