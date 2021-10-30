# CREATE product AND coupon TABLE 

create table coupon(
	id SERIAL PRIMARY KEY,
	code VARCHAR(20) UNIQUE,
	discount NUMERIC(5, 2),
	exp_date VARCHAR(50)
);

create table product(
	id SERIAL PRIMARY KEY,
	name VARCHAR(20),
	description VARCHAR(100),
	price NUMERIC(8,3)
);

#CREATE users, roles AND user_role TABLE

create table users(
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(20),
	last_name VARCHAR(20),
	email VARCHAR(25),
	password VARCHAR(256) UNIQUE
);

create table roles(
	id SERIAL PRIMARY KEY,
	name VARCHAR(20)
);

create table users_role(
	user_id INTEGER,
	role_id INTEGER,
	FOREIGN KEY (user_id) REFERENCES users(id),
	FOREIGN KEY (role_id) REFERENCES roles(id)
);

insert into users(first_name,last_name,email,password) values ('doug','bailey','doug@bailey.com','$2a$10$U2STWqktwFbvPPsfblVeIuy11vQ1S/0LYLeXQf1ZL0cMXc9HuTEA2');
insert into users(first_name,last_name,email,password) values ('john','ferguson','john@ferguson.com','$2a$10$YzcbPL.fnzbWndjEcRkDmO1E4vOvyVYP5kLsJvtZnR1f8nlXjvq/G');

insert into roles(name) values('ROLE_ADMIN');
insert into roles(name) values('ROLE_USER');

insert into users_role values(1,1);
insert into users_role values(2,2);

SELECT * FROM coupon c ;
SELECT * FROM product p ;
SELECT * FROM users u;
SELECT * FROM roles r;
SELECT * FROM users_role ur;