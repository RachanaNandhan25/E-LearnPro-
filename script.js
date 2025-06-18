document.addEventListener("DOMContentLoaded", () => {
  // Add confirm password input
  const confirmPasswordInput = document.createElement("input");
  confirmPasswordInput.type = "password";
  confirmPasswordInput.className = "form-control mt-3";
  confirmPasswordInput.id = "confirmPassword";
  confirmPasswordInput.placeholder = "Confirm Password";
  const signupForm = document.querySelector("#signup form");
  signupForm.insertBefore(
    confirmPasswordInput,
    signupForm.querySelector("button")
  );

  // Add show/hide password toggle
  addPasswordToggle("loginPassword");
  addPasswordToggle("signupPassword");
  addPasswordToggle("confirmPassword");

  // Login functionality
  const loginForm = document.querySelector("#login form");
  loginForm.addEventListener("submit", function (e) {
    e.preventDefault();
    const email = document.getElementById("loginEmail").value.trim();
    const password = document.getElementById("loginPassword").value.trim();

    if (!validateEmail(email)) {
      alert("Please enter a valid email address.");
      return;
    }

    if (password.length < 6) {
      alert("Password must be at least 6 characters long.");
      return;
    }

    const user = JSON.parse(localStorage.getItem(email));
    if (user && user.password === password) {
      showLoginPopup(); // Show success
      loginForm.reset();
    } else {
      alert("Invalid email or password.");
    }
  });

  // Signup functionality
  signupForm.addEventListener("submit", function (e) {
    e.preventDefault();

    const name = document.getElementById("signupName").value.trim();
    const email = document.getElementById("signupEmail").value.trim();
    const password = document.getElementById("signupPassword").value.trim();
    const confirmPassword = document
      .getElementById("confirmPassword")
      .value.trim();

    if (name === "") {
      alert("Please enter your full name.");
      return;
    }

    if (!validateEmail(email)) {
      alert("Please enter a valid email address.");
      return;
    }

    if (!validateStrongPassword(password)) {
      alert(
        "Password must contain at least 6 characters, an uppercase letter, a lowercase letter, a number, and a special character."
      );
      return;
    }

    if (password !== confirmPassword) {
      alert("Passwords do not match.");
      return;
    }

    if (localStorage.getItem(email)) {
      alert("User already exists. Please log in.");
      return;
    }

    // Store user
    localStorage.setItem(email, JSON.stringify({ name, email, password }));
    alert("Registration successful!");
    signupForm.reset();
  });

  // Close popup
  document.getElementById("closePopup").addEventListener("click", () => {
    document.getElementById("loginPopup").style.display = "none";
    document.getElementById("popupOverlay").style.display = "none";
  });
});

// Helpers
function validateEmail(email) {
  const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return regex.test(email);
}

function validateStrongPassword(password) {
  return (
    password.length >= 6 &&
    /[A-Z]/.test(password) &&
    /[a-z]/.test(password) &&
    /\d/.test(password) &&
    /[!@#$%^&*(),.?":{}|<>]/.test(password)
  );
}

function addPasswordToggle(inputId) {
  const input = document.getElementById(inputId);
  if (!input) return;

  const wrapper = document.createElement("div");
  wrapper.style.position = "relative";
  input.parentNode.insertBefore(wrapper, input);
  wrapper.appendChild(input);

  const toggle = document.createElement("span");
  toggle.innerText = "👁️";
  toggle.style.position = "absolute";
  toggle.style.right = "10px";
  toggle.style.top = "50%";
  toggle.style.transform = "translateY(-50%)";
  toggle.style.cursor = "pointer";
  wrapper.appendChild(toggle);

  toggle.addEventListener("click", () => {
    input.type = input.type === "password" ? "text" : "password";
  });
}

function showLoginPopup() {
  const popup = document.getElementById("loginPopup");
  const overlay = document.getElementById("popupOverlay");

  popup.style.display = "block";
  overlay.style.display = "block";

  // Redirect after 2 seconds (2000ms)
  setTimeout(() => {
    window.location.href = "registration.html";
  }, 2000);
}
