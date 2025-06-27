package sprint2.classes;


public class Course {
    private final String courseId;
    private final String title;
    private final String description;
    private final int durationWeeks;

    public Course(String courseId, String title, String description, int durationWeeks) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.durationWeeks = durationWeeks;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDurationWeeks() {
        return durationWeeks;
    }

    public String details() {
        return """
            Course ID: %s
            Title: %s
            Duration: %d weeks
            Description: %s
            """.formatted(courseId, title, durationWeeks, description);
    }
}

