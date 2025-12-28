INSERT INTO students (name) VALUES ('Otabek'), ('John Wick'), ('Alice'), ('Lazy Tom');

INSERT INTO grades (student_id, subject, score) VALUES
                                                    (1, 'Math', 90),
                                                    (1, 'History', 85),
                                                    (2, 'Math', 50),
                                                    (2, 'History', 55),
                                                    (3, 'Math', 95);

SELECT s.name, g.subject, g.score
FROM students s
         JOIN grades g ON s.id = g.student_id;

SELECT s.name, g.subject, g.score
FROM students s
         LEFT JOIN grades g ON s.id = g.student_id;

SELECT s.name, AVG(g.score) as average_grade
FROM students s
         JOIN grades g ON s.id = g.student_id
GROUP BY s.name
HAVING AVG(g.score) > 80;