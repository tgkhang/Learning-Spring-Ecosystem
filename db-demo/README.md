
Restart ứng dụng Spring Boot (rất quan trọng — application.properties chỉ load lúc khởi động).
Mở lại http://localhost:8080/h2-console.
Điền chính xác:
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password: (để trống)
Bấm Connect.


insert database h2 command
```sql
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

```



