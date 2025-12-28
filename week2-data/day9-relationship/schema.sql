CREATE TABLE students (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(50) NOT NULL
);


CREATE TABLE grades (
                        id SERIAL PRIMARY KEY,
                        student_id INT,
                        subject VARCHAR(50),
                        score INT,
                        CONSTRAINT fk_student
                            FOREIGN KEY(student_id)
                                REFERENCES students(id)
                                ON DELETE CASCADE
);