# Rooftop Energy Savings Backend

This repository contains the backend implementation of the Rooftop Energy Savings application. This application calculates energy savings based on rooftop area and provides APIs for managing rooftop data.

## Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Project Structure](#project-structure)
- [Usage](#usage)
  - [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or later
- Apache Maven

### Installation

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/your-username/rooftop-energy-savings-backend.git

2. Navigate to the project directory:
  ```bash   
  cd rooftop-energy-savings-backend

3. Build the project using Maven:

bash
Copy code
mvn clean install
Project Structure
The project follows a standard Maven project structure:

bash
Copy code
rooftop-energy-savings-backend/
├── src/
│   ├── main/
│   │   ├── java/       # Java source code
│   │   ├── resources/  # Configuration files
│   │   └── ...
│   └── test/
│       ├── java/       # Test source code
│       └── ...
├── pom.xml             # Maven configuration
└── ...
Usage
Running the Application
Ensure you have the necessary prerequisites installed.

Run the application using Maven:

bash
Copy code
mvn spring-boot:run
The application will start on the default port 8080.

API Documentation
The API documentation can be accessed by navigating to http://localhost:8080/swagger-ui.html after starting the application. This provides a detailed overview of the available APIs and how to use them.

Contributing
Contributions to this project are welcome! If you find a bug or have an idea for an enhancement, feel free to open an issue or submit a pull request.
