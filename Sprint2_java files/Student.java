package sprint2.classes;

import java.time.LocalDate;

public final class Student extends User {
    private final String fullName;
    private final LocalDate dateOfBirth;
    private final String gender;
    private final String college;
    private final String qualification;
    private final String courseInterested;
    private final String country;
    private final String state;
    private final String city;

    public Student(String userId, String email, String password, String role,
                   String fullName, LocalDate dateOfBirth, String gender,
                   String college, String qualification, String courseInterested,
                   String country, String state, String city) {
        super(userId, email, password, role);
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.college = college;
        this.qualification = qualification;
        this.courseInterested = courseInterested;
        this.country = country;
        this.state = state;
        this.city = city;
    }
    public String getFullName() {
        return fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getCollege() {
        return college;
    }

    public String getQualification() {
        return qualification;
    }

    public String getCourseInterested() {
        return courseInterested;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }


    @Override
    public String getProfile() {
        return """
            Student Profile
            ------------------
            Name: %s
            DOB: %s
            Gender: %s
            Email: %s
            College: %s
            Qualification: %s
            Interested Course: %s
            Location: %s, %s, %s
            Role: %s
            """.formatted(fullName, dateOfBirth, gender, email, college, qualification,
                courseInterested, city, state, country, role);
    }
}

