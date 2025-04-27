## Full-Stack Web Application (Work in Progress)

**Important Note:** This project is currently under development.

**Focus:** This application primarily demonstrates the back-end RESTful API capabilities. Consequently, the front-end features a minimal design.

## Technologies

### Back-end
* **Java**
    * Dependencies:
        * Spring Boot DevTools
        * Spring Web
        * Spring Security
        * JDBC API
        * Spring Data JPA
        * MySQL Driver
        * Validation
        * OpenAPI (Swagger UI) - for API documentation accessible via `/swagger-ui.html`

### Front-end
* **HTML**
* **CSS**
* **JavaScript**

### Database
* **MySQL**
    * Data Source:
        * The database schema and initial data are located in [chart_2023.sql](charts_2023.sql) and [chartaccounts.sql](chartaccounts.sql).
        * Chart_2023 is adapted from the "[Most Streamed Spotify Songs 2023](https://www.kaggle.com/datasets/nelgiriyewithana/top-spotify-songs-2023)" dataset on Kaggle, with some personal tweak.

## How to Try It Out

**Prerequisites:**

* **Java Development Kit (JDK):** Make sure you have Java installed on your system.
* **Maven:** This project uses Maven for dependency management.
* **MySQL:** You'll need a running MySQL database instance.

**Steps:**

1.  **Clone the Repository:**
    ```bash
    git clone https://github.com/RenelikesCats/full-stack-restful-api-charts.git
    cd full-stack-restful-api-charts
    ```

2.  **Set up the MySQL Database:**
    * Make sure you have MySql workbench installed
    * Execute the SQL script `chart_2023.sql` to create the tables and populate them with data.
    * Execute the SQL script `chartaccounts.sql`

3.  **Configure Spring Boot:**
    * **Important!** check the `src/main/resources/application.properties` file for database connection details (URL, username, password). Update these if necessary to match your MySQL setup.

4.  **Run the Back-end Application:**
    * Start the application from your IDE
    * The back-end application should start, typically running on `http://localhost:8080`. You can check the console output for the exact port.

5.  **Explore the API (Back-end):**
    * Once the back-end is running, you can access the API documentation using Swagger UI at: `http://localhost:8080/swagger-ui.html`. This will allow you to see the available API endpoints and interact with them.
    *  * **Note:** Without logging in as an administrator, only `GET` methods are accessible.
   
6. **View the Front-end Pages:**
    * The basic front-end pages can be accessed in your web browser.
        * The main page is typically at URL, `http://localhost:8080/` check your logs it might be different for you.
        * Admin page is at `http://localhost:8080/admin.html`.
      
7.  **Admin Login (for full API access):**
    * To access all API endpoints (including `POST`, `PUT`, `DELETE`, etc.), you'll need to log in as an administrator through the web application's login form.
    * Use the following credentials:
        * **Username:** `admin.admin@charts.be`
        * **Password:** `zorro`
   
**Note:** Since the front-end has minimal design, don't expect a fully interactive user experience. The primary focus is on demonstrating the back-end API.
