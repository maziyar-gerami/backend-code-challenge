# Boxing Project

This project consists of two folders, each serving a distinct purpose.

## Boxing

The **Boxing** folder contains the core project, implemented with Gradle. It's designed to solve the knapsack 0-1 problem using a dynamic programming solution. The project follows Test-Driven Development (TDD) principles.

### Running the Boxing Project

To run the project:

1. Open the Boxing project.
2. Run the `Main` class.
3. When prompted, enter the maximum weight of each box as a float value.
4. Enter the specifications for each box in the following format:
(1,53.38,$45)(2,88.62,$98)(3,78.48,$3)(4,72.30,$76)(5,30.18,$9)(6,46.34,$48)
5. Press Enter, and the program will solve the problem, returning the IDs of the selected boxes.

### Example

For example, with a maximum weight of 81 and the specified format for each pack, the result would be:
Selected item[s] id: [4]

## Web Service Project

The **Web Service Project** is developed using Spring Boot, Hibernate, and JPA. Gradle serves as the build tool. The project includes three APIs for:
1. Creating items with the aforementioned format string.
2. Retrieving all products in the database.
3. Calculating the average price in a given range.

### Running the Web Service Project

To run the Web Service project:

1. Open the Web Service project.
2. Run the `Application.java` file.
3. The Spring Boot application will start the webserver.

### API Documentation

The API documentation and contracts are available in a Postman collection located in the `resources` folder.

## Contributing

Feel free to contribute to this project! If you have any suggestions or find issues, please open an [issue](link-to-issues).


