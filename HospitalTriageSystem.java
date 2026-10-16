import java.util.Scanner;

public class HospitalTriageSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Triage triage = new Triage();

        Doctor doctor1 = new Doctor(
                1, "Dr. Ravi", "Emergency Medicine");

        int choice;

        do {
            System.out.println("\n=== HOSPITAL TRIAGE SYSTEM ===");
            System.out.println("1. Register Patient");
            System.out.println("2. Display All Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Display Doctor Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter patient ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter patient name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter patient age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter symptoms: ");
                    String symptoms = sc.nextLine();

                    System.out.println("Select illustrative priority:");
                    System.out.println("1. High");
                    System.out.println("2. Medium");
                    System.out.println("3. Low");
                    System.out.print("Enter urgency level: ");

                    int level = sc.nextInt();
                    sc.nextLine();

                    if (level < 1 || level > 3) {
                        System.out.println("Invalid urgency level.");
                        break;
                    }

                    Patient patient = new Patient(
                            id, name, age, symptoms, level);

                    triage.addPatient(patient);
                    break;

                case 2:
                    triage.displayAllPatients();
                    break;

                case 3:
                    System.out.print("Enter patient ID to search: ");
                    int searchId = sc.nextInt();

                    triage.searchPatient(searchId);
                    break;

                case 4:
                    doctor1.displayDoctor();
                    break;

                case 5:
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid menu choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}