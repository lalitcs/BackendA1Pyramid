# PyramidBackendA1

Overview
PyramidBackendA1 is a Spring Boot application designed for log management with AWS S3 integration. It generates, stores, and retrieves logs efficiently, ensuring robust logging solutions for cloud-based environments.

 Features
- REST APIs for log writing, fetching, and counting
- Scheduled log generation and storage
- AWS S3 integration for remote log management
- Configurable log storage and retention policies
- Dockerized deployment

 Technologies Used
- Java 17
- Spring Boot
- AWS S3 SDK
- SLF4J Logging
- Docker

 Installation & Setup Prerequisites
- Java 17 or later
- Maven
- AWS S3 bucket with credentials
- Docker (Optional for containerization)

 Steps to Run Locally
 Note: code is commented, un-comment the code then 
1. Clone the repository:
   
   git clone https://github.com/lalitcs/BackendA1Pyramid.git
   cd PyramidBackendA1
   
2. Update application.properties with your AWS credentials and configurations.
3. Build the project using Maven:
   
   mvn clean install
   
4. Run the application:
   
   java -jar target/PyramidBackendA1.jar
   

 API Endpoints

  POST| /logs/write | Writes a log entry |
  GET | /logs/fetch | Retrieves all logs |
  GET | /logs/count | Returns log count |

 Docker Setup
To run the application inside a Docker container:

 docker build -t pyramid-backend .
 docker run -p 8084:8084 pyramid-backend
 
 Troubleshooting
- Check console logs for errors.
- Ensure AWS credentials & permissions are correctly set.
- This service efficiently stores logs in S3, ensuring secure and scalable log management!
