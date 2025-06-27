package sprint2.classes;

import java.time.LocalDate;

public record Enrollment(
        String enrollmentId,
        Student student,
        Course course,
        LocalDate enrollmentDate,
        String status
) {
    public String summary() {
        String message = switch (status.toUpperCase()) {
            case "PENDING" -> "Awaiting approval.";
            case "CONFIRMED" -> "Enrollment confirmed.";
            case "REJECTED" -> "Enrollment rejected.";
            default -> "Unknown status.";
        };

        return """
            Enrollment ID: %s
            Student: %s
            Course: %s
            Date: %s
            Status: %s (%s)
            """.formatted(enrollmentId, student.getFullName(), course.getTitle(),
                enrollmentDate, status, message);
    }
}

