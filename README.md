# Basic-Graphical-Calculator
A basic calculator with graphical user interface using Java.
Calculator GUI is a Java-based desktop application that offers a simple calculator interface using the Swing framework. The application allows users to perform basic arithmetic operations such as addition, subtraction, multiplication, and division. It features a clean and intuitive graphical user interface with a 4x4 grid of buttons and a display text field for showing input and results.

The interface includes number buttons (0-9), arithmetic operators (+, -, *, /), a clear button (C), and an equals button (=). The calculator performs single binary operations, meaning it calculates results based on one operator at a time (e.g., 5 + 3 = 8). It also handles division-by-zero errors gracefully by displaying an error message rather than crashing.

To run the project, ensure that Java Development Kit (JDK) version 8 or higher is installed on your system. Clone the repository and navigate to the project directory. Then compile the source file using the following command:
javac -d bin src/com/mycompany/calculator_gui/Calculator_GUI.java
Once compiled, you can run the application using:
java -cp bin com.mycompany.calculator_gui.Calculator_GUI

The project follows a typical Java package structure, with source files stored in the src/ directory and compiled class files output to the bin/ directory. This structure makes it easy to manage and expand the application as needed.

Planned future improvements include support for decimal point input, handling chained expressions (e.g., 2 + 3 * 4), enhanced styling for a more modern look, and optional support for keyboard input. These features would make the calculator more powerful and user-friendly.
