# LineCounterApp

## Description
This is a simple Java Console Application that counts the number of vertical black lines in a black and white image. The image should be created using MS Paint, with black lines on a white background. The program accepts a single argument, which is the absolute path to the image file.

## How to Use
1. Compile the application using a Java compiler.
   Example:

2. Run the application from the command line with the absolute path to the image as the only argument.
Example:


### Expected Output:


## Error Handling
- If an invalid number of arguments are provided, the application will display an error message.
- If the file does not exist at the provided path, the application will display an error message.
- Any other exceptions encountered during execution will be displayed as error messages.

## Requirements
- Java Runtime Environment (JRE)
- The image must be in JPG format.

## Unit Test Coverage
Unit tests have been added to ensure the `countVerticalLines` method works correctly across various scenarios. The tests cover the following cases:

1. **Single Vertical Line**: Tests an image with exactly one vertical black line to ensure it is counted correctly.
   
2. **Multiple Vertical Lines**: Tests an image containing multiple vertical black lines to verify that each distinct line is counted.

3. **No Vertical Lines**: Tests an image with no vertical black lines (all white) to confirm that the result is zero.

4. **Interrupted Vertical Line**: Tests an image with an interrupted vertical black line (with a small gap) to ensure that it is still counted as a single line.

These tests are implemented using the JUnit framework. The test class `LineCounterAppTest` includes all the test cases mentioned above. To run the tests, make sure you have JUnit included in your project dependencies.

### How to Run the Tests
1. Compile the test class with JUnit:


2. Execute the tests:


## Summary of Development
During development, it was crucial to ensure that the application could handle different image sizes and formats reliably. The main challenge was to ensure that only vertical lines were counted, and that no other black pixels (e.g., noise or non-vertical lines) were incorrectly counted.

In addition, unit tests were created to ensure robustness and correctness in different edge cases, providing confidence that the method behaves as expected in various scenarios.
