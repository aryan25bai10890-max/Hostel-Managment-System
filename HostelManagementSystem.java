import java.io.*;
import java.util.*;

/*
 * HOSTEL MANAGEMENT SYSTEM
 * One-file Core Java project demonstrating Modules 1-4.
 *
 * Project structure:
 * HostelManagementSystem/
 * ├── HostelManagementSystem.java
 * └── data/
 *     ├── students.txt
 *     ├── rooms.txt
 *     └── fees.txt
 */
public class HostelManagementSystem {

    // Module 1: variables, data types, operators, final and static
    static final double MONTHLY_FEE = 5000.0;
    static final int MAX_ROOMS = 20;

    static Scanner sc = new Scanner(System.in);
    static Hostel hostel = new Hostel();

    // Module 2: enum
    enum RoomType {
        SINGLE, DOUBLE, TRIPLE
    }

    // Module 2: interface
    interface FeeManagement {
        double calculateFee(int months);
    }

    // Module 2: abstract class, encapsulation, constructor, method
    abstract static class Person {
        private String name;

        Person() {
            this.name = "Unknown";
        }

        Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        abstract void displayDetails();
    }

    // Module 2: inheritance, encapsulation, this, super, overriding
    static class Student extends Person implements FeeManagement {
        private int rollNumber;
        private String course;
        private int year;
        private String phone;
        private int roomNumber;
        private RoomType roomType;
        private String feeStatus;

        Student() {
            super();
            this.rollNumber = 0;
            this.course = "Unknown";
            this.year = 0;
            this.phone = "Unknown";
            this.roomNumber = 0;
            this.roomType = RoomType.SINGLE;
            this.feeStatus = "Pending";
        }

        Student(int rollNumber, String name, String course, int year,
                String phone, int roomNumber, RoomType roomType,
                String feeStatus) {
            super(name);
            this.rollNumber = rollNumber;
            this.course = course;
            this.year = year;
            this.phone = phone;
            this.roomNumber = roomNumber;
            this.roomType = roomType;
            this.feeStatus = feeStatus;
        }

        public int getRollNumber() {
            return rollNumber;
        }

        public String getCourse() {
            return course;
        }

        public int getYear() {
            return year;
        }

        public String getPhone() {
            return phone;
        }

        public int getRoomNumber() {
            return roomNumber;
        }

        public RoomType getRoomType() {
            return roomType;
        }

        public String getFeeStatus() {
            return feeStatus;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setRoomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
        }

        public void setRoomType(RoomType roomType) {
            this.roomType = roomType;
        }

        public void setFeeStatus(String feeStatus) {
            this.feeStatus = feeStatus;
        }

        // Method overriding
        @Override
        void displayDetails() {
            System.out.println("Roll Number : " + rollNumber);
            System.out.println("Name        : " + getName());
            System.out.println("Course      : " + course);
            System.out.println("Year        : " + year);
            System.out.println("Phone       : " + phone);
            System.out.println("Room Number : " +
                    (roomNumber == 0 ? "Not Allocated" : roomNumber));
            System.out.println("Room Type   : " +
                    (roomNumber == 0 ? "Not Allocated" : roomType));
            System.out.println("Fee Status  : " + feeStatus);
        }

        // Method overloading
        double calculateFee() {
            return MONTHLY_FEE;
        }

        @Override
        public double calculateFee(int months) {
            return MONTHLY_FEE * months;
        }
    }

    // Module 2: class, object, constructor, encapsulation, enum
    static class Room {
        private int roomNumber;
        private RoomType roomType;
        private boolean occupied;

        Room() {
            this.roomNumber = 0;
            this.roomType = RoomType.SINGLE;
            this.occupied = false;
        }

        Room(int roomNumber, RoomType roomType, boolean occupied) {
            this.roomNumber = roomNumber;
            this.roomType = roomType;
            this.occupied = occupied;
        }

        public int getRoomNumber() {
            return roomNumber;
        }

        public RoomType getRoomType() {
            return roomType;
        }

        public boolean isOccupied() {
            return occupied;
        }

        public void setOccupied(boolean occupied) {
            this.occupied = occupied;
        }
    }

    // Module 3: custom exception
    static class RoomNotAvailableException extends Exception {
        RoomNotAvailableException(String message) {
            super(message);
        }
    }

    // Module 2: Hostel class; Module 4: ArrayList and arrays
    static class Hostel {
        private ArrayList<Student> students = new ArrayList<>();
        private Room[] rooms = new Room[MAX_ROOMS];

        // static member
        private static int totalStudents = 0;

        Hostel() {
            initializeRooms();
        }

        private void initializeRooms() {
            for (int i = 0; i < MAX_ROOMS; i++) {
                int roomNo = 101 + i;
                RoomType type;

                if (i % 3 == 0) {
                    type = RoomType.SINGLE;
                } else if (i % 3 == 1) {
                    type = RoomType.DOUBLE;
                } else {
                    type = RoomType.TRIPLE;
                }

                rooms[i] = new Room(roomNo, type, false);
            }
        }

        public static int getTotalStudents() {
            return totalStudents;
        }

        public ArrayList<Student> getStudents() {
            return students;
        }

        public Room[] getRooms() {
            return rooms;
        }

        public Student findStudent(int rollNumber) {
            // Module 1: for-each loop
            for (Student s : students) {
                if (s.getRollNumber() == rollNumber) {
                    return s;
                }
            }
            return null;
        }

        private Room findRoom(int roomNumber) {
            // Module 1: for loop
            for (Room room : rooms) {
                if (room.getRoomNumber() == roomNumber) {
                    return room;
                }
            }
            return null;
        }

        public void addStudent(Student student) {
            students.add(student);
            totalStudents++;
        }

        public void deleteStudent(Student student) {
            students.remove(student);
            totalStudents--;
        }

        public void allocateRoom(int rollNumber, int roomNumber)
                throws RoomNotAvailableException {
            Student student = findStudent(rollNumber);

            if (student == null) {
                throw new RoomNotAvailableException("Student not found.");
            }

            Room room = findRoom(roomNumber);

            if (room == null) {
                throw new RoomNotAvailableException("Room does not exist.");
            }

            if (room.isOccupied()) {
                throw new RoomNotAvailableException(
                        "Room " + roomNumber + " is already occupied.");
            }

            if (student.getRoomNumber() != 0) {
                throw new RoomNotAvailableException(
                        "Student already has room " + student.getRoomNumber() + ".");
            }

            room.setOccupied(true);
            student.setRoomNumber(roomNumber);
            student.setRoomType(room.getRoomType());
        }

        public void vacateRoom(int rollNumber)
                throws RoomNotAvailableException {
            Student student = findStudent(rollNumber);

            if (student == null) {
                throw new RoomNotAvailableException("Student not found.");
            }

            if (student.getRoomNumber() == 0) {
                throw new RoomNotAvailableException(
                        "This student does not have an allocated room.");
            }

            Room room = findRoom(student.getRoomNumber());

            if (room != null) {
                room.setOccupied(false);
            }

            student.setRoomNumber(0);
            student.setRoomType(RoomType.SINGLE);
        }

        public int countOccupiedRooms() {
            int count = 0;

            // Array traversal
            for (Room room : rooms) {
                if (room.isOccupied()) {
                    count++;
                }
            }

            return count;
        }

        public int countAvailableRooms() {
            return rooms.length - countOccupiedRooms();
        }

        public void displayStudents() {
            if (students.isEmpty()) {
                System.out.println("\nNo student records found.");
                return;
            }

            System.out.println("\n--------------------------------------------------------------------------------");
            System.out.printf("%-8s %-18s %-18s %-6s %-8s %-10s %-10s%n",
                    "Roll", "Name", "Course", "Year", "Room", "Type", "Fee");
            System.out.println("--------------------------------------------------------------------------------");

            for (Student s : students) {
                String room = s.getRoomNumber() == 0
                        ? "None" : String.valueOf(s.getRoomNumber());

                String type = s.getRoomNumber() == 0
                        ? "None" : s.getRoomType().toString();

                System.out.printf("%-8d %-18s %-18s %-6d %-8s %-10s %-10s%n",
                        s.getRollNumber(),
                        s.getName(),
                        s.getCourse(),
                        s.getYear(),
                        room,
                        type,
                        s.getFeeStatus());
            }

            System.out.println("--------------------------------------------------------------------------------");
        }

        public void displayAvailableRooms() {
            System.out.println("\nAvailable Rooms:");
            boolean found = false;

            for (Room room : rooms) {
                if (!room.isOccupied()) {
                    System.out.println("Room " + room.getRoomNumber()
                            + " - " + room.getRoomType());
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No rooms available.");
            }
        }

        public void displayOccupiedRooms() {
            System.out.println("\nOccupied Rooms:");
            boolean found = false;

            for (Room room : rooms) {
                if (room.isOccupied()) {
                    System.out.println("Room " + room.getRoomNumber()
                            + " - " + room.getRoomType());
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No rooms are occupied.");
            }
        }
    }

    // Module 3: multithreading
    static class HostelStatusThread extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("\n----------------------------------------");
                    System.out.println("        HOSTEL STATUS MONITOR");
                    System.out.println("----------------------------------------");
                    System.out.println("Total Rooms     : " + hostel.getRooms().length);
                    System.out.println("Occupied Rooms  : " + hostel.countOccupiedRooms());
                    System.out.println("Available Rooms : " + hostel.countAvailableRooms());
                    System.out.println("----------------------------------------");

                    // Demonstrates Thread.sleep()
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                System.out.println("Status monitor interrupted.");
                Thread.currentThread().interrupt();
            }
        }
    }

    // Module 3: throws and exception handling
    static int readInt(String message) throws NumberFormatException {
        System.out.print(message);
        String input = sc.nextLine().trim();
        return Integer.parseInt(input);
    }

    static String readNonEmpty(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();

            if (input.length() == 0) {
                System.out.println("Input cannot be empty.");
                continue;
            }

            return input;
        }
    }

    static RoomType readRoomType() {
        while (true) {
            System.out.println("1. SINGLE");
            System.out.println("2. DOUBLE");
            System.out.println("3. TRIPLE");

            try {
                int choice = readInt("Select room type: ");

                switch (choice) {
                    case 1:
                        return RoomType.SINGLE;
                    case 2:
                        return RoomType.DOUBLE;
                    case 3:
                        return RoomType.TRIPLE;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    static void addStudent() {
        System.out.println("\n========== ADD STUDENT ==========");

        try {
            int roll = readInt("Enter roll number: ");

            if (roll <= 0) {
                throw new IllegalArgumentException("Roll number must be positive.");
            }

            if (hostel.findStudent(roll) != null) {
                System.out.println("A student with this roll number already exists.");
                return;
            }

            String name = readNonEmpty("Enter name: ");
            String course = readNonEmpty("Enter course: ");
            int year = readInt("Enter year: ");

            if (year <= 0) {
                throw new IllegalArgumentException("Year must be positive.");
            }

            String phone = readNonEmpty("Enter phone number: ");

            Student student = new Student(
                    roll, name, course, year, phone,
                    0, RoomType.SINGLE, "Pending"
            );

            hostel.addStudent(student);
            System.out.println("Student added successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } finally {
            System.out.println("Add Student operation completed.");
        }
    }

    static void searchStudent() {
        System.out.println("\n========== SEARCH STUDENT ==========");

        try {
            int roll = readInt("Enter roll number: ");
            Student student = hostel.findStudent(roll);

            if (student == null) {
                System.out.println("Student not found.");
            } else {
                student.displayDetails();
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid roll number.");
        }
    }

    static void updateStudent() {
        System.out.println("\n========== UPDATE STUDENT ==========");

        try {
            int roll = readInt("Enter roll number: ");
            Student student = hostel.findStudent(roll);

            if (student == null) {
                System.out.println("Student not found.");
                return;
            }

            System.out.println("1. Update Name");
            System.out.println("2. Update Course");
            System.out.println("3. Update Year");
            System.out.println("4. Update Phone");
            System.out.println("5. Update Fee Status");

            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    student.setName(readNonEmpty("Enter new name: "));
                    break;
                case 2:
                    student.setCourse(readNonEmpty("Enter new course: "));
                    break;
                case 3:
                    int year = readInt("Enter new year: ");
                    if (year <= 0) {
                        throw new IllegalArgumentException("Year must be positive.");
                    }
                    student.setYear(year);
                    break;
                case 4:
                    student.setPhone(readNonEmpty("Enter new phone: "));
                    break;
                case 5:
                    String status = readNonEmpty(
                            "Enter fee status (Paid/Pending): ");
                    if (status.equalsIgnoreCase("paid")) {
                        student.setFeeStatus("Paid");
                    } else if (status.equalsIgnoreCase("pending")) {
                        student.setFeeStatus("Pending");
                    } else {
                        throw new IllegalArgumentException(
                                "Use only Paid or Pending.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
                    return;
            }

            System.out.println("Student details updated successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }

    static void deleteStudent() {
        System.out.println("\n========== DELETE STUDENT ==========");

        try {
            int roll = readInt("Enter roll number: ");
            Student student = hostel.findStudent(roll);

            if (student == null) {
                System.out.println("Student not found.");
                return;
            }

            // Vacate room first if allocated
            if (student.getRoomNumber() != 0) {
                hostel.vacateRoom(roll);
            }

            hostel.deleteStudent(student);
            System.out.println("Student deleted successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid roll number.");
        } catch (RoomNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void allocateRoom() {
        System.out.println("\n========== ALLOCATE ROOM ==========");

        try {
            int roll = readInt("Enter student roll number: ");
            int room = readInt("Enter room number: ");

            hostel.allocateRoom(roll, room);
            System.out.println("Room " + room + " allocated successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numeric values.");
        } catch (RoomNotAvailableException e) {
            System.out.println("Room Allocation Error: " + e.getMessage());
        }
    }

    static void vacateRoom() {
        System.out.println("\n========== VACATE ROOM ==========");

        try {
            int roll = readInt("Enter student roll number: ");
            hostel.vacateRoom(roll);
            System.out.println("Room vacated successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid roll number.");
        } catch (RoomNotAvailableException e) {
            System.out.println("Vacate Error: " + e.getMessage());
        }
    }

    static void calculateFee() {
        System.out.println("\n========== HOSTEL FEE ==========");

        try {
            int roll = readInt("Enter student roll number: ");
            Student student = hostel.findStudent(roll);

            if (student == null) {
                System.out.println("Student not found.");
                return;
            }

            // Method overloading: calculateFee()
            double oneMonthFee = student.calculateFee();

            int months = readInt("Enter number of months: ");

            if (months <= 0) {
                throw new IllegalArgumentException(
                        "Number of months must be positive.");
            }

            // Overloaded method: calculateFee(int)
            double totalFee = student.calculateFee(months);

            System.out.println("\nStudent Name : " + student.getName());
            System.out.println("Monthly Fee  : Rs. " + oneMonthFee);
            System.out.println("Months       : " + months);
            System.out.println("Total Fee    : Rs. " + totalFee);

        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numeric values.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }

    // Module 4: File I/O
    static void createDataDirectory() {
        File directory = new File("data");

        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Data directory created.");
            }
        }
    }

    static void saveData() {
        createDataDirectory();

        // Multiple catch handling
        try (
                BufferedWriter studentWriter =
                        new BufferedWriter(new FileWriter("data/students.txt"));
                BufferedWriter roomWriter =
                        new BufferedWriter(new FileWriter("data/rooms.txt"));
                BufferedWriter feeWriter =
                        new BufferedWriter(new FileWriter("data/fees.txt"))
        ) {
            // Save students
            for (Student s : hostel.getStudents()) {
                studentWriter.write(
                        s.getRollNumber() + "," +
                        cleanText(s.getName()) + "," +
                        cleanText(s.getCourse()) + "," +
                        s.getYear() + "," +
                        cleanText(s.getPhone()) + "," +
                        s.getRoomNumber() + "," +
                        s.getRoomType() + "," +
                        s.getFeeStatus()
                );
                studentWriter.newLine();

                feeWriter.write(
                        s.getRollNumber() + "," +
                        s.calculateFee() + "," +
                        s.getFeeStatus()
                );
                feeWriter.newLine();
            }

            // Save rooms
            for (Room room : hostel.getRooms()) {
                roomWriter.write(
                        room.getRoomNumber() + "," +
                        (room.isOccupied() ? "Occupied" : "Available") + "," +
                        room.getRoomType()
                );
                roomWriter.newLine();
            }

            System.out.println("Data saved successfully.");

        } catch (IOException e) {
            System.out.println("File error while saving data: " + e.getMessage());
        } finally {
            System.out.println("Save operation completed.");
        }
    }

    static void loadData() {
        createDataDirectory();

        File studentFile = new File("data/students.txt");
        File roomFile = new File("data/rooms.txt");

        // If no saved files exist, use fresh/default rooms.
        if (!studentFile.exists() && !roomFile.exists()) {
            System.out.println("No previous data found. Starting with empty records.");
            return;
        }

        try {
            loadStudents();
            loadRooms();
            loadFees();
            System.out.println("Data loaded successfully.");
        } catch (IOException | NumberFormatException |
                 IllegalArgumentException e) {
            System.out.println("Error while loading data: " + e.getMessage());
        }
    }

    static void loadStudents() throws IOException {
        File file = new File("data/students.txt");

        if (!file.exists()) {
            return;
        }

        hostel.getStudents().clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().length() == 0) {
                    continue;
                }

                String[] parts = line.split(",", -1);

                if (parts.length < 8) {
                    continue;
                }

                int roll = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                String course = parts[2].trim();
                int year = Integer.parseInt(parts[3].trim());
                String phone = parts[4].trim();
                int roomNumber = Integer.parseInt(parts[5].trim());
                RoomType roomType = RoomType.valueOf(parts[6].trim().toUpperCase());
                String feeStatus = parts[7].trim();

                Student student = new Student(
                        roll, name, course, year, phone,
                        roomNumber, roomType, feeStatus
                );

                hostel.getStudents().add(student);
            }

            // Synchronize static count with loaded records.
            Hostel.totalStudents = hostel.getStudents().size();
        }
    }

    static void loadRooms() throws IOException {
        File file = new File("data/rooms.txt");

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().length() == 0) {
                    continue;
                }

                String[] parts = line.split(",", -1);

                if (parts.length < 3) {
                    continue;
                }

                int roomNumber = Integer.parseInt(parts[0].trim());
                boolean occupied =
                        parts[1].trim().equalsIgnoreCase("Occupied");
                RoomType roomType =
                        RoomType.valueOf(parts[2].trim().toUpperCase());

                for (Room room : hostel.getRooms()) {
                    if (room.getRoomNumber() == roomNumber) {
                        room.setOccupied(occupied);
                        break;
                    }
                }
            }
        }
    }

    static void loadFees() throws IOException {
        File file = new File("data/fees.txt");

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().length() == 0) {
                    continue;
                }

                String[] parts = line.split(",", -1);

                if (parts.length < 3) {
                    continue;
                }

                int roll = Integer.parseInt(parts[0].trim());
                String status = parts[2].trim();

                Student student = hostel.findStudent(roll);

                if (student != null) {
                    student.setFeeStatus(status);
                }
            }
        }
    }

    static String cleanText(String text) {
        // Prevent commas from breaking the simple CSV-like file format.
        return text.replace(",", " ");
    }

    static void printMenu() {
        System.out.println("\n================================================");
        System.out.println("             HOSTEL MANAGEMENT SYSTEM");
        System.out.println("================================================");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Allocate Room");
        System.out.println("5. Vacate Room");
        System.out.println("6. Display Available Rooms");
        System.out.println("7. Display Occupied Rooms");
        System.out.println("8. Calculate Hostel Fee");
        System.out.println("9. Update Student Details");
        System.out.println("10. Delete Student");
        System.out.println("11. Save Data");
        System.out.println("12. Load Data");
        System.out.println("13. Start Hostel Status Monitor");
        System.out.println("14. Exit");
        System.out.println("================================================");
    }

    // Module 2: polymorphism demonstration
    static void demonstratePolymorphism() {
        Person personReference = new Student(
                999, "Demo Student", "Computer Science", 2,
                "0000000000", 0, RoomType.SINGLE, "Pending"
        );

        // Runtime polymorphism: Person reference refers to Student object.
        // The Student version of displayDetails() is called.
        System.out.println("\nPolymorphism demonstration:");
        personReference.displayDetails();
    }

    public static void main(String[] args) {

        createDataDirectory();

        System.out.println("===============================================");
        System.out.println("       WELCOME TO HOSTEL MANAGEMENT SYSTEM");
        System.out.println("===============================================");

        loadData();

        // Module 1: while loop
        boolean running = true;

        while (running) {
            printMenu();

            try {
                int choice = readInt("Enter your choice: ");

                // Module 1: switch statement
                switch (choice) {
                    case 1:
                        addStudent();
                        break;

                    case 2:
                        hostel.displayStudents();
                        break;

                    case 3:
                        searchStudent();
                        break;

                    case 4:
                        allocateRoom();
                        break;

                    case 5:
                        vacateRoom();
                        break;

                    case 6:
                        hostel.displayAvailableRooms();
                        break;

                    case 7:
                        hostel.displayOccupiedRooms();
                        break;

                    case 8:
                        calculateFee();
                        break;

                    case 9:
                        updateStudent();
                        break;

                    case 10:
                        deleteStudent();
                        break;

                    case 11:
                        saveData();
                        break;

                    case 12:
                        loadData();
                        break;

                    case 13:
                        System.out.println(
                                "\nStarting hostel status monitor..."
                        );

                        HostelStatusThread thread =
                                new HostelStatusThread();

                        thread.start();

                        try {
                            thread.join();
                        } catch (InterruptedException e) {
                            System.out.println("Monitor interrupted.");
                            Thread.currentThread().interrupt();
                        }
                        break;

                    case 14:
                        System.out.println("\nSaving data before exit...");
                        saveData();
                        System.out.println("Thank you for using Hostel Management System.");
                        running = false;
                        break;

                    default:
                        System.out.println(
                                "Invalid choice. Please select 1-14."
                        );
                        continue;
                }

            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid input. Please enter a number."
                );
            } catch (Exception e) {
                System.out.println(
                        "Unexpected error: " + e.getMessage()
                );
            }
        }

        sc.close();
    }
}
