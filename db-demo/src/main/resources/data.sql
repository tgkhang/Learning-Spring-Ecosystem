-- Table creation
CREATE TABLE person (
                        id INT NOT NULL,
                        name VARCHAR(255) NOT NULL,
                        location VARCHAR(255),
                        birth_date TIMESTAMP,
                        PRIMARY KEY (id)
);

-- Insert sample rows
INSERT INTO person (id, name, location, birth_date)
VALUES (10001, 'Alice', 'HCMC', CURRENT_TIMESTAMP);

INSERT INTO person (id, name, location, birth_date)
VALUES (10002, 'Bob', 'Hanoi', CURRENT_TIMESTAMP);

INSERT INTO person (id, name, location, birth_date)
VALUES (10003, 'Charlie', 'Da Nang', CURRENT_TIMESTAMP);
