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

#CREATE users AND customer table
CREATE TABLE customer(
	id SERIAL PRIMARY KEY,
	email VARCHAR(25),
	pwd VARCHAR(255),
	role VARCHAR(25)
)

INSERT INTO customer(email, pwd, role) VALUES ('jogndoe@example.com', '54321', 'admin');

#BCryptPasswordEncoder

#https://bcrypt-generator.com/
#12345 TO $2a$12$2f.HgyFG16BIL/oH439s7uAwp5/9uiP7PIZefyIDMk40dVo2H.c7u

INSERT INTO customer(email, pwd, role) VALUES ('happy@example.com', '$2a$12$2f.HgyFG16BIL/oH439s7uAwp5/9uiP7PIZefyIDMk40dVo2H.c7u', 'admin');
