# User Validation System

This project demonstrates how to handle runtime errors using Java Exceptions. I built a validator to check user inputs and manage valid/invalid data flows without crashing the application.

## Overview
The application validates user registration details. It uses **Custom Exceptions** to distinguish between different types of invalid data (e.g., bad format vs. business rule violation).

## Features
- **Age Validation:** Throws `InvalidAgeException` if the user is under 18 or negative.
- **Email Validation:** Throws `InvalidEmailException` if the email format is incorrect (missing '@').
- **Name Validation:** Throws standard `IllegalArgumentException` for empty inputs.

## Technical Details
- Used `try-catch` blocks to handle errors gracefully.
- Created custom classes extending `RuntimeException` (Unchecked) to mimic Spring Boot best practices.
- Implemented specific catch blocks to provide distinct error messages for different failures.