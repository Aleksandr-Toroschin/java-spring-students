BEGIN;

DROP TABLE IF EXISTS students CASCADE;
CREATE TABLE students (id bigserial PRIMARY KEY, name VARCHAR(255), score int);
INSERT INTO students (name, score) VALUES
('Bob', 10),
('Max', 20),
('Tom', 100),
('Bill', 50),
('Will', 99);

COMMIT;