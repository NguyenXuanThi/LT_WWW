/*CREATE TABLE account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    email      VARCHAR(100) NOT NULL UNIQUE,
    password   VARCHAR(100) NOT NULL,
    birth_date DATE,
    gender     ENUM('MALE', 'FEMALE')
);
*/

INSERT INTO account (first_name, last_name, email, password, birth_date, gender)
VALUES 
('Nguyen', 'Thi', 'thi@example.com', '123456', '2000-05-20', 'MALE'),
('Tran', 'An', 'an@example.com', 'abcdef', '1999-11-02', 'FEMALE'),
('Le', 'Hoa', 'hoa@example.com', 'qwerty', '2001-01-15', 'MALE');
`account`