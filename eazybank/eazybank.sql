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

#CORS AND CSRF

DROP TABLE customer;

CREATE TABLE customer(
	customer_id SERIAL PRIMARY KEY,
	name varchar(100) NOT NULL,
	email VARCHAR(100) NOT NULL,
	mobile_number varchar(20) NOT NULL,
	pwd VARCHAR(500) NOT NULL,
	role VARCHAR(100) NOT NULL,
	create_dt date DEFAULT NULL
);

INSERT INTO customer (name, email, mobile_number, pwd, role, create_dt) VALUES ('Happy','happy@example.com','9876548337', '$2a$12$2f.HgyFG16BIL/oH439s7uAwp5/9uiP7PIZefyIDMk40dVo2H.c7u', 'admin', CURRENT_DATE);

CREATE TABLE accounts (
  	customer_id int NOT NULL,
  	account_number serial PRIMARY KEY,
  	account_type varchar(100) NOT NULL,
  	branch_address varchar(200) NOT NULL,
  	create_dt date DEFAULT NULL,
  	FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
);

INSERT INTO accounts (customer_id, account_number, account_type, branch_address, create_dt) VALUES (1, 1865, 'Savings', '123 Main Street, New York', CURRENT_DATE);

CREATE TABLE account_transactions (
  	transaction_id varchar(200) PRIMARY KEY,
  	account_number int NOT NULL,
  	customer_id int NOT NULL,
  	transaction_dt date NOT NULL,
  	transaction_summary varchar(200) NOT NULL,
  	transaction_type varchar(100) NOT NULL,
  	transaction_amt int NOT NULL,
  	closing_balance int NOT NULL,
  	create_dt date DEFAULT NULL,
	FOREIGN KEY (account_number) REFERENCES accounts (account_number) ON DELETE CASCADE,
	FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
);

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type,transaction_amt,
closing_balance, create_dt)  VALUES (uuid_generate_v1(), 1865, 1, CURRENT_DATE-7, 'Coffee Shop', 'Withdrawal', 30,34500,CURRENT_DATE-7);

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type,transaction_amt,
closing_balance, create_dt)  VALUES (uuid_generate_v1(), 1865, 1, CURRENT_DATE-6, 'Uber', 'Withdrawal', 100,34400,CURRENT_DATE-6);

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type,transaction_amt,
closing_balance, create_dt)  VALUES (uuid_generate_v1(), 1865, 1, CURRENT_DATE-5, 'Self Deposit', 'Deposit', 500,34900,CURRENT_DATE-5);

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type,transaction_amt,
closing_balance, create_dt)  VALUES (uuid_generate_v1(), 1865, 1, CURRENT_DATE-4, 'Ebay', 'Withdrawal', 600,34300,CURRENT_DATE-4);

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type,transaction_amt,
closing_balance, create_dt)  VALUES (uuid_generate_v1(), 1865, 1, CURRENT_DATE-2, 'OnlineTransfer', 'Deposit', 700,35000,CURRENT_DATE-2);

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type,transaction_amt,
closing_balance, create_dt)  VALUES (uuid_generate_v1(), 1865, 1, CURRENT_DATE-1, 'Amazon.com', 'Withdrawal', 100,34900,CURRENT_DATE-1);

CREATE TABLE loans (
  	loan_number SERIAL PRIMARY KEY,
  	customer_id int NOT NULL,
  	start_dt date NOT NULL,
  	loan_type varchar(100) NOT NULL,
 	total_loan int NOT NULL,
  	amount_paid int NOT NULL,
  	outstanding_amount int NOT NULL,
  	create_dt date DEFAULT NULL,
	FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
);

INSERT INTO loans ( customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt)
 VALUES ( 1, '2020-10-13', 'Home', 200000, 50000, 150000, '2020-10-13');

INSERT INTO loans ( customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt)
 VALUES ( 1, '2020-06-06', 'Vehicle', 40000, 10000, 30000, '2020-06-06');

INSERT INTO loans ( customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt)
 VALUES ( 1, '2018-02-14', 'Home', 50000, 10000, 40000, '2018-02-14');

INSERT INTO loans ( customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt)
 VALUES ( 1, '2018-02-14', 'Personal', 10000, 3500, 6500, '2018-02-14');

CREATE TABLE cards (
  	card_id SERIAL PRIMARY KEY,
  	card_number varchar(100) NOT NULL,
  	customer_id int NOT NULL,
  	card_type varchar(100) NOT NULL,
  	total_limit int NOT NULL,
  	amount_used int NOT NULL,
  	available_amount int NOT NULL,
  	create_dt date DEFAULT NULL,
  	FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
);

INSERT INTO cards (card_number, customer_id, card_type, total_limit, amount_used, available_amount, create_dt)
 VALUES ('4565XXXX4656', 1, 'Credit', 10000, 500, 9500, CURRENT_DATE);

INSERT INTO cards (card_number, customer_id, card_type, total_limit, amount_used, available_amount, create_dt)
 VALUES ('3455XXXX8673', 1, 'Credit', 7500, 600, 6900, CURRENT_DATE);

INSERT INTO cards (card_number, customer_id, card_type, total_limit, amount_used, available_amount, create_dt)
 VALUES ('2359XXXX9346', 1, 'Credit', 20000, 4000, 16000, CURRENT_DATE);

CREATE TABLE notice_details (
  	notice_id SERIAL PRIMARY KEY,
  	notice_summary varchar(200) NOT NULL,
  	notice_details varchar(500) NOT NULL,
  	notic_beg_dt date NOT NULL,
 	notic_end_dt date DEFAULT NULL,
  	create_dt date DEFAULT NULL,
  	update_dt date DEFAULT NULL
);

INSERT INTO notice_details ( notice_summary, notice_details, notic_beg_dt, notic_end_dt, create_dt, update_dt)
VALUES ('Home Loan Interest rates reduced', 'Home loan interest rates are reduced as per the goverment guidelines. The updated rates will be effective immediately',
'2020-10-14', '2025-11-30', CURRENT_DATE, null);

INSERT INTO notice_details ( notice_summary, notice_details, notic_beg_dt, notic_end_dt, create_dt, update_dt)
VALUES ('Net Banking Offers', 'Customers who will opt for Internet banking while opening a saving account will get a $50 amazon voucher',
'2020-10-14', '2025-12-05', CURRENT_DATE, null);

INSERT INTO notice_details ( notice_summary, notice_details, notic_beg_dt, notic_end_dt, create_dt, update_dt)
VALUES ('Mobile App Downtime', 'The mobile application of the EazyBank will be down from 2AM-5AM on 12/05/2020 due to maintenance activities',
'2020-10-14', '2025-12-01', CURRENT_DATE, null);

INSERT INTO notice_details ( notice_summary, notice_details, notic_beg_dt, notic_end_dt, create_dt, update_dt)
VALUES ('E Auction notice', 'There will be a e-auction on 12/08/2020 on the Bank website for all the stubborn arrears.Interested parties can participate in the e-auction',
'2020-10-14', '2025-12-08', CURRENT_DATE, null);

INSERT INTO notice_details ( notice_summary, notice_details, notic_beg_dt, notic_end_dt, create_dt, update_dt)
VALUES ('Launch of Millennia Cards', 'Millennia Credit Cards are launched for the premium customers of EazyBank. With these cards, you will get 5% cashback for each purchase',
'2020-10-14', '2025-11-28', CURRENT_DATE, null);

INSERT INTO notice_details ( notice_summary, notice_details, notic_beg_dt, notic_end_dt, create_dt, update_dt)
VALUES ('COVID-19 Insurance', 'EazyBank launched an insurance policy which will cover COVID-19 expenses. Please reach out to the branch for more details',
'2020-10-14', '2025-12-31', CURRENT_DATE, null);

CREATE TABLE contact_messages (
  contact_id varchar(50) PRIMARY KEY,
  contact_name varchar(50) NOT NULL,
  contact_email varchar(100) NOT NULL,
  subject varchar(500) NOT NULL,
  message varchar(2000) NOT NULL,
  create_dt date DEFAULT NULL
);

#Authentication and Authorisation

DROP TABLE authorities;

CREATE TABLE authorities (
  id SERIAL PRIMARY KEY,
  customer_id int NOT NULL,
  name varchar(50) NOT NULL,
  FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
);

INSERT INTO authorities (customer_id, name)
 VALUES (1, 'READ');

INSERT INTO authorities (customer_id, name)
 VALUES (1, 'WRITE');

 #Authority vs Role
 UPDATE authorities SET name='ROLE_USER' WHERE id=1;
 UPDATE authorities SET name='ROLE_ADMIN' WHERE id=2;