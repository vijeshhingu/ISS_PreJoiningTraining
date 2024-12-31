// Function to switch between the registration and login forms
function toggleForms() {
  const registrationForm = document.getElementById('registration-form');
  const loginForm = document.getElementById('login-form');

  // If the registration form is visible, hide it and show the login form, or vice versa
  if (registrationForm.style.display === "none") {
    registrationForm.style.display = "block";
    loginForm.style.display = "none";
  } else {
    registrationForm.style.display = "none";
    loginForm.style.display = "block";
  }
}

// Handle the registration form submission
document.getElementById('register-form').addEventListener('submit', function(event) {
  event.preventDefault();  // Prevent the form from submitting normally

  // Get the values from the registration form
  const username = document.getElementById('reg-username').value;
  const password = document.getElementById('reg-password').value;

  // Check if the username and password are entered
  if (username && password) {
    // Store the username and password in localStorage
    localStorage.setItem('username', username);
    localStorage.setItem('password', password);

    // Notify the user that registration is successful
    alert('Registration successful! You can now login.');

    // Switch to the login form
    toggleForms();
  } else {
    alert('Please fill in both fields.');
  }
});

// Handle the login form submission
document.getElementById('login-form').addEventListener('submit', function(event) {
  event.preventDefault();  // Prevent the form from submitting normally

  // Get the values from the login form
  const username = document.getElementById('login-username').value;
  const password = document.getElementById('login-password').value;

  // Retrieve the stored credentials from localStorage
  const storedUsername = localStorage.getItem('username');
  const storedPassword = localStorage.getItem('password');

  // Check if the entered credentials match the stored ones
  if (username === storedUsername && password === storedPassword) {
    alert('Login successful!');
  } else {
    alert('Invalid credentials. Please try again.');
  }
});
