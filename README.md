
# Customer Care Registry

This is a Customer Care Registry project that facilitates communication and issue resolution among customers, agents, and the support team. The system allows customers to register complaints, transfer them, and engage in real-time chat with support agents.

## Roles

### 1. Customer

Customers can:
- Register complaints and describe their issues.
- Transfer complaints to specific agents or support teams.
- Participate in real-time chat for immediate assistance.

### 2. Agent

Agents are responsible for:
- Receiving and managing assigned complaints.
- Providing solutions to customer complaints.
- Engaging in real-time chat with customers for efficient communication.

### 3. Team

Support teams handle:
- Assigned complaints and collaborate to resolve complex issues.
- Monitoring and managing the overall complaint resolution process.
- Utilizing real-time chat for team communication.

## Technologies Used

- Java
- Spring Boot
- Thymeleaf (for web templates)
- Spring Data JPA (for data access)
- Spring Security (for authentication and authorization)
- Spring Websocket (for real-time chat)
- MySQL (as the database)
- Lombok (to reduce boilerplate code)

### Getting Started

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/moxhadeel571/HRMTOOL_SPRINGBOOT.git
   cd HRMTOOL_SPRINGBOOT
   ```

2. **Database Configuration:**
   - Configure your MySQL database settings in `src/main/resources/application.properties`.
   - Create a database named `hrm_tool`.

3. **Run the Application:**
   ```bash
   ./gradlew bootRun
   ```

   The application will start at `http://localhost:8080`.
###Video Tutorial

https://github.com/moxhadeel571/HRMTOOL_SPRINGBOOT/assets/60618158/7efa0851-1684-4b9c-b161-c1bf582fa167


4. Open your browser and visit [http://localhost:8080](http://localhost:8080) to access the application.

## Development

To contribute to the development of this project, follow these steps:

1. Fork the repository.
2. Create a new branch: `git checkout -b feature/new-feature`
3. Make your changes and commit them: `git commit -m 'Add new feature'`
4. Push to the branch: `git push origin feature/new-feature`
5. Submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
```

Feel free to customize this README based on additional details or features specific to your project. Adjust the technologies, prerequisites, and development steps accordingly.
