CREATE TABLE IF NOT EXIST RUn (
    id INT NOT NULL,
    title VARCHAR(250) NOT NULL,
    started_on timestamp NOT NULL,
    completed_on timestamp NOT NULL,
    miles INT NOT NULL,
    location VARCHAR(250) NOT NULL,
    PRIMARY KEY (id)
);