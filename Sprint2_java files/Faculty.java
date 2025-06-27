package sprint2.classes;

public final class Faculty extends User {
    private final String fullName;
    private final String department;
    private final String qualification;
    private final String expertiseArea;

    public Faculty(String userId, String email, String password, String role,
                   String fullName, String department,
                   String qualification, String expertiseArea) {
        super(userId, email, password, role);
        this.fullName = fullName;
        this.department = department;
        this.qualification = qualification;
        this.expertiseArea = expertiseArea;
    }


    public String getFullName() {
        return fullName;
    }

    public String getDepartment() {
        return department;
    }

    public String getQualification() {
        return qualification;
    }

    public String getExpertiseArea() {
        return expertiseArea;
    }

    @Override
    public String getProfile() {
        return """
            Faculty Profile
            ------------------
            Name: %s
            Email: %s
            Department: %s
            Qualification: %s
            Expertise: %s
            Role: %s
            """.formatted(fullName, email, department, qualification, expertiseArea, role);
    }
}
