#CREATE users AND authorities table
create table users(
	id SERIAL PRIMARY KEY,
	username VARCHAR(45),
	password VARCHAR(150) UNIQUE,
	enabled INT
);

create table authorities(
	id SERIAL PRIMARY KEY,
	username VARCHAR(45),
	authority VARCHAR(45)
)

INSERT INTO users(username, PASSWORD, enabled) VALUES ('happy', '12345', 1);
INSERT INTO authorities (username, authority) VALUES ('happy', 'write');