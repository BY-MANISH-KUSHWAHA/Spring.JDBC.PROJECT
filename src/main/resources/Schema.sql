-- CREATING A TABLE
-- CREATE TABLE TABLE_NAME
CREATE TABLE Player(
--  COLUMN_NAME TYPE REQUIRED OR OPTIONAL
                       PID INTEGER NOT NULL,
                       Name VARCHAR(255) NOT NULL ,
                       Age INTEGER NOT NULL,
                       Nationality VARCHAR(50) NOT NULL,
                       DOB TIMESTAMP,
                       Designation INTEGER,
    -- UNIQUE KEY FOR THE TABLE
                       PRIMARY KEY (PID)
);


