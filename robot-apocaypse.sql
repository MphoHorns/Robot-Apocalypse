CREATE TABLE survivor (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    age INT,
    gender VARCHAR(10),
    latitude FLOAT,
    longitude FLOAT,
    infected BOOLEAN DEFAULT FALSE
);

CREATE TABLE inventory (
    id SERIAL PRIMARY KEY,
    survivor_id BIGINT REFERENCES survivor(id)
);
