CREATE TABLE Authors (
    AuthorID SERIAL PRIMARY KEY,
    AuthorName VARCHAR(255),
    BirthDate DATE,
    Nationality VARCHAR(50),
    Biography TEXT
);
