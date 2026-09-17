# 🏨 Hostel Management System

A simple **console-based Java application** designed to manage students, hostel rooms, room allocation, hostel fees, and student records.

The project is developed using **Core Java** and demonstrates important Java programming concepts including **Classes & Objects, Constructors, Encapsulation, Inheritance, Abstraction, Interfaces, Polymorphism, Method Overloading, Method Overriding, ArrayList, Arrays, Loops, Conditions, Exception Handling, Custom Exceptions, Multithreading, and File Handling**.

---

## 👨‍💻 Project Information

* **Student Name:** Aryan Bardiya
* **Registration No.:** 25BAI10890
* **Project:** Hostel Management System
* **Programming Language:** Java
* **Course:** JAVA Programming (CSE2006)
* **Slot:** B22+B24
* **Project Type:** Console-Based Application

---

## 📌 Project Overview

The **Hostel Management System** is a menu-driven Java application developed to manage basic hostel operations.

The system allows the user to maintain student records, allocate and vacate hostel rooms, calculate hostel fees, update student information, and manage room availability.

Instead of maintaining hostel records manually, the application provides a simple console interface through which different operations can be performed.

The system allows users to:

* Add a student
* Display all students
* Search for a student
* Allocate a hostel room
* Vacate a hostel room
* Display available rooms
* Display occupied rooms
* Calculate hostel fees
* Update student details
* Delete a student
* Save data to files
* Load previously saved data
* Start a hostel status monitor
* Exit the application

The project is intentionally designed as a simple Core Java application so that fundamental Java programming and object-oriented programming concepts can be clearly demonstrated.

---

## 🎯 Objectives

The main objectives of this project are:

1. To develop a simple menu-driven Java application.
2. To understand and implement Classes and Objects.
3. To use constructors for initializing objects.
4. To implement encapsulation using private data members and methods.
5. To understand inheritance and abstraction.
6. To implement interfaces in Java.
7. To demonstrate method overloading and method overriding.
8. To use ArrayList and arrays for storing records.
9. To implement loops and conditional statements.
10. To handle invalid input using exception handling.
11. To create and use a custom exception.
12. To understand basic multithreading.
13. To calculate and manage hostel fees.
14. To store and retrieve data using file handling.
15. To apply Core Java concepts in a practical management system.

---

# ✨ Features

## 1. Add Student

The system allows a new student to be added by entering:

* Roll Number
* Name
* Course
* Year
* Phone Number

Each student can later be assigned a hostel room.

The system also checks whether the roll number already exists.

---

## 2. Display All Students

The application displays all registered students in a structured format.

The displayed information includes:

* Roll Number
* Name
* Course
* Year
* Room Number
* Room Type
* Fee Status

If no records are available, the system displays an appropriate message.

---

## 3. Search Student

Users can search for a student using their **roll number**.

If the student exists, their complete details are displayed.

If the student does not exist, the system displays:

```text
Student not found.
```

---

## 4. Allocate Room

A hostel room can be allocated to a student by entering:

* Student Roll Number
* Room Number

The system checks:

* Whether the student exists
* Whether the room exists
* Whether the room is already occupied
* Whether the student already has a room

If all conditions are satisfied, the room is allocated successfully.

---

## 5. Vacate Room

A student's allocated room can be vacated using their roll number.

When a room is vacated:

* The room becomes available.
* The student's room number is reset.
* The student's room type is reset.

The system also prevents a student without an allocated room from performing the operation.

---

## 6. Display Available Rooms

The application displays all rooms that are currently available.

Each available room is shown with:

```text
Room Number - Room Type
```

The project initially creates **20 rooms**, numbered from **101 to 120**.

The room types are:

* SINGLE
* DOUBLE
* TRIPLE

---

## 7. Display Occupied Rooms

The application displays all currently occupied rooms along with their room types.

If no rooms are occupied, the system displays an appropriate message.

---

## 8. Calculate Hostel Fee

The hostel fee is calculated using the predefined monthly fee.

The monthly hostel fee is:

```text
Rs. 5000
```

Users can enter the number of months and the application calculates the total fee.

Example:

```text
Monthly Fee  : Rs. 5000.0
Months       : 6
Total Fee    : Rs. 30000.0
```

The project demonstrates **method overloading** using:

```java
calculateFee()
```

and

```java
calculateFee(int months)
```

---

## 9. Update Student Details

The application allows existing student information to be updated.

The following details can be changed:

```text
1. Update Name
2. Update Course
3. Update Year
4. Update Phone
5. Update Fee Status
```

The fee status can be:

```text
Paid
Pending
```

---

## 10. Delete Student

A student can be deleted using their roll number.

If the student already has an allocated room, the room is automatically vacated before deleting the student record.

This prevents the deleted student's room from remaining incorrectly marked as occupied.

---

## 11. Save Data

The system stores hostel information in text files inside the `data` folder.

The following files are used:

```text
data/students.txt
data/rooms.txt
data/fees.txt
```

Student information, room information, and fee status are stored separately.

---

## 12. Load Data

Previously saved records can be loaded from the data files.

When the application starts, it automatically attempts to load previously saved information.

The user can also manually select:

```text
12. Load Data
```

to reload the stored records.

---

## 13. Hostel Status Monitor

The project includes a separate **thread** for monitoring hostel room status.

When started, the status monitor displays:

```text
HOSTEL STATUS MONITOR

Total Rooms     : 20
Occupied Rooms  : ...
Available Rooms : ...
```

The monitor runs repeatedly and uses:

```java
Thread.sleep(2000);
```

to pause for two seconds between status displays.

This feature demonstrates basic **multithreading and thread lifecycle operations**.

---

## 14. Exit

When the user selects Exit, the application automatically saves the current data before closing.

The program then displays:

```text
Thank you for using Hostel Management System.
```

---

# 🛠️ Technologies Used

| Technology         | Purpose                      |
| ------------------ | ---------------------------- |
| Java               | Main programming language    |
| Core Java          | Application development      |
| ArrayList          | Storing student records      |
| Arrays             | Managing hostel rooms        |
| Scanner            | Taking user input            |
| File Handling      | Saving and loading records   |
| Exception Handling | Handling invalid input       |
| Custom Exception   | Handling room-related errors |
| Multithreading     | Hostel status monitoring     |
| Console            | User interface               |

---

# 📚 Java Concepts Used

## Classes & Objects

The project contains several classes including:

```text
HostelManagementSystem
Person
Student
Room
Hostel
HostelStatusThread
RoomNotAvailableException
```

Objects are created from these classes to represent students, rooms, hostel data, and the status-monitoring thread.

---

## Constructors

Constructors are used to initialize objects.

For example, a student can be initialized using:

```java
Student student = new Student(
    roll, name, course, year, phone,
    0, RoomType.SINGLE, "Pending"
);
```

The project also demonstrates both default and parameterized constructors.

---

## Encapsulation

The project uses private data members and public getter/setter methods.

For example:

```java
private int rollNumber;
private String course;
private int year;
private String phone;
```

Getter and setter methods are used to access or modify the required information.

---

## Inheritance

The `Student` class inherits from the `Person` class:

```java
static class Student extends Person
```

This allows the Student class to reuse properties and methods from Person.

---

## Abstraction

The project uses an abstract class:

```java
abstract static class Person
```

The `Person` class contains an abstract method:

```java
abstract void displayDetails();
```

The Student class provides the implementation of this method.

---

## Interface

The project defines the `FeeManagement` interface:

```java
interface FeeManagement {
    double calculateFee(int months);
}
```

The Student class implements this interface.

---

## Method Overriding

The `Student` class overrides the `displayDetails()` method inherited from `Person`.

```java
@Override
void displayDetails() {
    ...
}
```

This demonstrates runtime method overriding.

---

## Method Overloading

The project contains two versions of the `calculateFee()` method:

```java
double calculateFee()
```

and

```java
double calculateFee(int months)
```

The first calculates the monthly fee, while the second calculates the fee for multiple months.

---

## Polymorphism

The project demonstrates runtime polymorphism using a `Person` reference referring to a `Student` object:

```java
Person personReference = new Student(...);
```

The overridden `displayDetails()` method of Student is then executed.

---

## `this` Keyword

The `this` keyword is used in constructors and setter methods to refer to the current object's variables.

Example:

```java
this.course = course;
this.year = year;
this.phone = phone;
```

---

## `super` Keyword

The `super` keyword is used to call the constructor of the parent class.

Example:

```java
super(name);
```

It allows the Student class to initialize the name property defined in the Person class.

---

## `final` Keyword

The project uses `final` for values that should remain constant during execution.

For example:

```java
static final double MONTHLY_FEE = 5000.0;
static final int MAX_ROOMS = 20;
```

---

## `static` Keyword

Static variables and methods are used for information shared at the class level.

For example:

```java
private static int totalStudents = 0;
```

The project also uses static methods for several application operations.

---

## Enum

The project uses an enum to represent hostel room types:

```java
enum RoomType {
    SINGLE, DOUBLE, TRIPLE
}
```

This restricts room types to predefined values.

---

## ArrayList

An `ArrayList` is used to store student records:

```java
private ArrayList<Student> students = new ArrayList<>();
```

This allows multiple student objects to be stored and managed dynamically.

---

## Arrays

An array is used to manage hostel rooms:

```java
private Room[] rooms = new Room[MAX_ROOMS];
```

The application initializes 20 rooms using this array.

---

## Loops

Different types of loops are used throughout the application.

Examples include:

```java
for (Student s : students)
```

and:

```java
while (running)
```

Loops are used for searching records, displaying rooms, initializing rooms, and repeatedly displaying the menu.

---

## Conditional Statements

The application uses:

* `if`
* `else if`
* `else`
* `switch`

to make decisions based on user input and application conditions.

---

## Exception Handling

Exception handling is used to prevent the application from terminating unexpectedly due to invalid input.

Examples include:

```java
NumberFormatException
```

and:

```java
IllegalArgumentException
```

The application also uses `try`, `catch`, and `finally`.

---

## Custom Exception

The project defines a custom exception:

```java
static class RoomNotAvailableException extends Exception
```

It is used for situations such as:

* Student not found
* Room does not exist
* Room already occupied
* Student already has a room
* Student does not have an allocated room

---

## Multithreading

The project contains a thread class:

```java
static class HostelStatusThread extends Thread
```

The thread overrides the `run()` method and periodically displays hostel room statistics.

The application also uses:

```java
thread.start();
```

and:

```java
thread.join();
```

to demonstrate thread execution and waiting for thread completion.

---

## File Handling

The application uses Java file-handling classes such as:

```text
File
FileReader
FileWriter
BufferedReader
BufferedWriter
```

The data is stored in simple text files rather than a database.

---

# 📁 Project Structure

```text
HostelManagementSystem/
│
├── HostelManagementSystem.java
│
├── data/
│   ├── students.txt
│   ├── rooms.txt
│   └── fees.txt
│
├── Screenshots/
│
├── Project Report.pdf
│
├── README.md
│
└── Statement.md
```

### `HostelManagementSystem.java`

Contains the complete Core Java application, including:

* Main menu
* Student management
* Room management
* Fee calculation
* Exception handling
* File handling
* Multithreading
* Supporting classes

The project intentionally keeps the implementation in a **single Java file**.

### `data/`

Contains files used for persistent storage.

### `students.txt`

Stores student information.

### `rooms.txt`

Stores room numbers, occupancy status, and room types.

### `fees.txt`

Stores student fee information and fee status.

---

# ⚙️ Requirements

To run this project, you need:

* Java JDK installed
* Command Prompt / PowerShell / Terminal
* A text editor or Java IDE

You can check whether Java is installed using:

```bash
java -version
```

and:

```bash
javac -version
```

---

# ▶️ How to Run

## Step 1: Open the Project Folder

Open the terminal inside the project folder:

```text
HostelManagementSystem
```

---

## Step 2: Compile the Program

Run:

```bash
javac HostelManagementSystem.java
```

---

## Step 3: Run the Program

Run:

```bash
java HostelManagementSystem
```

The application will start with the welcome screen and main menu.

---

# 🖥️ Main Menu

```text
================================================
             HOSTEL MANAGEMENT SYSTEM
================================================
1. Add Student
2. Display All Students
3. Search Student
4. Allocate Room
5. Vacate Room
6. Display Available Rooms
7. Display Occupied Rooms
8. Calculate Hostel Fee
9. Update Student Details
10. Delete Student
11. Save Data
12. Load Data
13. Start Hostel Status Monitor
14. Exit
================================================
```

---

# 💾 File Handling

The project uses simple text files for data storage instead of a database.

The following files are used:

```text
data/students.txt
data/rooms.txt
data/fees.txt
```

When the application starts, it creates the `data` directory if it does not already exist.

When the user selects:

```text
11. Save Data
```

the current records are written to the files.

When the user selects:

```text
12. Load Data
```

the saved records are loaded into the application.

Data is also automatically saved when the user selects:

```text
14. Exit
```

---

# 🧪 Testing

The application can be tested using the following operations:

| Test Case                            | Expected Result                      |
| ------------------------------------ | ------------------------------------ |
| Add valid student                    | Student is added successfully        |
| Add duplicate roll number            | Duplicate student is rejected        |
| Add student with invalid roll number | Error message displayed              |
| Search existing student              | Student details are displayed        |
| Search non-existing student          | Student not found message            |
| Allocate available room              | Room is allocated successfully       |
| Allocate occupied room               | Room allocation error displayed      |
| Allocate invalid room                | Room does not exist message          |
| Allocate room to unknown student     | Student not found message            |
| Allocate second room to same student | Allocation rejected                  |
| Vacate allocated room                | Room becomes available               |
| Vacate room for student without room | Error message displayed              |
| Display available rooms              | Available rooms are displayed        |
| Display occupied rooms               | Occupied rooms are displayed         |
| Calculate one-month fee              | Monthly fee displayed                |
| Calculate multi-month fee            | Total fee calculated                 |
| Update student details               | Student information updated          |
| Delete student                       | Student removed successfully         |
| Delete student with room             | Room is vacated before deletion      |
| Save data                            | Records stored in files              |
| Load data                            | Previous records restored            |
| Invalid menu input                   | Error message displayed              |
| Start status monitor                 | Hostel status displayed using thread |
| Exit application                     | Data saved before exit               |

---

# 📌 Sample Data

## Student

```text
Roll Number: 101
Name: Sarthak Jindal
Course: Computer Science
Year: 1
Phone: 9876543210
Room Number: 101
Room Type: SINGLE
Fee Status: Paid
```

## Room

```text
Room Number: 101
Room Type: SINGLE
Status: Occupied
```

## Fee

```text
Monthly Fee: Rs. 5000
Months: 6
Total Fee: Rs. 30000
Status: Paid
```

---

# 🔄 Example Working Flow

```text
Start Program
      ↓
Create / Load Data
      ↓
Display Main Menu
      ↓
Add Student
      ↓
Allocate Room
      ↓
Display / Search Student
      ↓
Calculate Hostel Fee
      ↓
Update Student Details
      ↓
Vacate / Delete Student
      ↓
Save Data
      ↓
Load Data when Required
      ↓
Start Status Monitor when Required
      ↓
Save Data
      ↓
Exit
```

---

# 🎓 Learning Outcomes

After completing this project, the following Java concepts were practiced:

* Creating Java classes
* Creating and using objects
* Constructors
* Encapsulation
* Inheritance
* Abstraction
* Interfaces
* Polymorphism
* Method overloading
* Method overriding
* `this` keyword
* `super` keyword
* `static` keyword
* `final` keyword
* Enums
* ArrayList
* Arrays
* Loops
* Conditional statements
* Switch statements
* Exception handling
* Custom exceptions
* Multithreading
* File handling
* Reading and writing text files
* Building a menu-driven console application

---

# 🚀 Future Improvements

The project can be extended in the future by adding:

* Student login and authentication
* Admin login
* Password protection
* Multiple hostel blocks
* More detailed room capacity management
* Student check-in and check-out dates
* Online fee payment
* Automatic fee reminders
* Fine calculation for late payments
* Graphical User Interface (GUI)
* Database connectivity using MySQL
* Search by student name or course
* Room-wise student reports
* Hostel attendance management
* Email or notification system
* Better report generation

---

# 👨‍💻 Author

**Aryan Bardiya**

Registration No.: **25BAI10890**

VIT Bhopal University

Course: **JAVA Programming (CSE2006)**

---

# 📄 Project Type

**Console-Based Core Java Application**

The project demonstrates the practical implementation of fundamental Java programming, object-oriented programming, exception handling, multithreading, and file-handling concepts through a Hostel Management System.
