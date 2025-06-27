package sprint2.classes;

public sealed abstract class User permits Student, Faculty {
    protected final String userId;
    protected final String email;
    protected final String password;
    protected final String role;

    public User(String userId, String email, String password, String role) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public boolean isValidEmail() {
        return email != null && email.contains("@") && email.contains(".");
    }

    public boolean isPasswordStrong() {
        return password != null && password.length() >= 6;
    }

    public abstract String getProfile();
}

