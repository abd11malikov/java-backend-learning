# Day 11: Maven & Dependency Management

## 🎯 Concepts Learned
- **POM (Project Object Model):** The `pom.xml` is the blueprint.
- **GAV Coordinates:** `GroupId` (Company), `ArtifactId` (Project), `Version`.
- **Dependency Management:** No more manual JAR downloads. Maven fetches them from Central.
- **Scopes:**
    - `compile` (Default, needed everywhere).
    - `provided` (Available on the server, e.g., Lombok).
    - `test` (Only for JUnit).

## 🛠️ Commands Mastered
- `mvn clean`: Deletes the `target` folder (removes old compiled code).
- `mvn compile`: Compiles `.java` into `.class`.
- `mvn dependency:tree`: visualizes the hierarchy of libraries and finds **Transitive Dependencies**.

## 🏗️ Structure created
We set up a project ready for **JDBC** (Postgres Driver added).