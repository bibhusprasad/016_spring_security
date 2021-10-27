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