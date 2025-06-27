package sprint2.classes;

import java.time.LocalDate;

public class MainP {
    public static void main(String[] args) {
        Student student = new Student(
                "S101", "alice@example.com", "securePass123", "STUDENT",
                "Alice Johnson", LocalDate.of(2001, 5, 14), "Female",
                "ABC University", "BSc", "Data Science",
                "India", "Telangana", "Hyderabad"
        );

        Faculty faculty = new Faculty(
                "F501", "prof.jane@example.com", "teachStrong!", "FACULTY",
                "Dr. Jane Smith", "Computer Science", "PhD", "Machine Learning"
        );

        Course course = new Course("C001", "Java Programming", "Intro to Java", 6);

        Enrollment enrollment = new Enrollment("E202406", student, course, LocalDate.now(), "CONFIRMED");

        System.out.println(student.getProfile());
        System.out.println(faculty.getProfile());
        System.out.println(course.details());
        System.out.println(enrollment.summary());
    }
}

