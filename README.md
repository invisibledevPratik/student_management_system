"# student_management_system" 
🎓 Student Management System (Java Console App)
This is a Java-based console application to manage student records — including adding, viewing, updating, deleting, saving to file, and loading from file. The system also supports features like sorting, grade calculation, and filtering by course.

📁 Project Structure
StudentManagementSystem/
├── com/
│   ├── student/
│   │   ├── app/             → Contains MainApp.java (entry point)
│   │   ├── model/           → Contains Student.java (POJO class)
│   │   ├── service/         → Contains StudentService.java (business logic)
│   │   └── util/            → Contains FileUtil.java (file handling helper)
├── data/
│   └── students.txt         → Serialized student data (auto-created)

🚀 Features
• Add new student records
• View all students
• Search by roll number
• Delete and update records
• Sort by name or marks
• Show grades and top 3 performers
• Filter students by course
• Save/load records using file serialization

🧠 How It Works
• Students are stored in an in-memory List<Student>.
• File operations (Save/Load) use Java's built-in object serialization.
• Grades are based on marks:
90+  → A+
80+  → A
70+  → B
60+  → C
<60  → F

📌 How to Run
1. Clone or download this project in your Java IDE.
2. Make sure the folder data/ exists or the file path is correctly referenced in MainApp.java.
3. Run MainApp.java.
4. Use the menu to interact with the system.

💡 Sample Menu
--- Student Record System ---
1. Add Student
2. Show All Students
3. Search by Roll No
4. Delete Student
5. Update Student
6. Save Records
7. Load Records
8. Sort by Name
9. Sort by Marks
10. Show Grades
11. Show Toppers
12. Filter by Course
13. Total Students
0. Exit

📎 Notes
• Serialized file path is defined in MainApp.java:
  String file = "C:\\Users\\DELL\\eclipse-workspace\\StudentManagementSystem\\bin\\com\\students.txt";
  Modify this path based on your system if needed.

• You can change grade logic or add more filters/sorting options as practice.

✅ To Do (Suggestions)
• Add input validation
• Prevent duplicate roll numbers
• Export to CSV format
• Create GUI using JavaFX or Swing
• Integrate with a database (e.g., MySQL)

👨‍💻 Author
This project was built as part of a Java learning journey — great job applying object-oriented programming and file handling!
