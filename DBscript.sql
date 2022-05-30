CREATE TABLE 
	customer (
		customer_id serial PRIMARY KEY NOT NULL,
		name VARCHAR(255) NOT NULL,
		email VARCHAR(255) UNIQUE NOT NULL,
		phone CHAR(13) NOT NULL,
		CONSTRAINT chk_phone CHECK (phone not like '%[^0-9]%'),
		age SMALLINT DEFAULT 99 CHECK (age>=18), 
		address VARCHAR(255),
		city VARCHAR(255),
		postal_code INT CHECK (postal_code>0),
		country VARCHAR(255),
		consent_status BOOLEAN NOT NULL,
		is_profile_active BOOLEAN NOT NULL,
		date_profile_created timestamp DEFAULT CURRENT_timestamp,
		date_profile_deactivated timestamp,
		reason_for_deactivation VARCHAR(255),
		notes TEXT);

 --Insert values in particular columns:
INSERT INTO 
	customer (customer_id, name, email, phone, age, address, city, postal_code, country, consent_status, is_profile_active) 		 			 
VALUES 
(1, 'Mark', 'mark@abv.bg', +359888444561, 25, 'Bulgaria', 'Sofia', 359, 'BG', true, true), 
(2, 'Alice', 'alice@jit.bg', +359878448561, 26, 'Greece', 'Athens', 478, 'Greece', false, true),
(3, 'Bob', 'bob@fsdg.bg', +359878447561, 46, 'Bulgaria', 'Sliven', 368, 'Bulgaria', true, false),
(4, 'Charlie', 'charlie@gmail.bg', +359678444561, 64, 'Bulgaria', 'Ruse', 258, 'Bulgaria', true, true);

--Insert only with mandatory fields:
INSERT INTO 
	customer (customer_id, name, email, phone, consent_status, is_profile_active) 	 	
VALUES 
(5, 'Mike', 'mike@abv.bg', +359888944561, true, true), 
(6, 'Nicol', 'nicol@gmail.com', +356578944561, true, true);

--Insert with all fields:
INSERT INTO 
	customer 
VALUES 
(7, 'Mark', 'maddssrk@av.bg', +3598444561, 30, 'Bulgaria, Sofia, Gorublqne', 
 'Sofia', 359, 'Bulgaria', true, true, DEFAULT,DEFAULT, NULL,
 'Note: Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
 Lorem Ipsum has been the industrys standard dummy text ever since the 1500s,
 when an unknown printer took a galley of type and scrambled it to make a type
 specimen book. It has survived not only five centuries, but also the leap into
 electronic typesetting, remaining essentially unchanged. It was popularised in 
 the 1960s with the release of Letraset sheets containing Lorem Ipsum passages,
 and more recently with desktop publishing software like Aldus PageMaker 
 including versions of Lorem Ipsum'), 
 
 (8, 'Majjrk', 'madfjtyjssrk@abv.bg', +3592244561, 45, 'Bulgaria, Sofia, Mladost', 
 'Sofia', 359, 'Bulgaria', true, true, DEFAULT,DEFAULT, NULL,
 'Note: Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
 Lorem Ipsum has been the industrys standard dummy text ever since the 1500s,
 when an unknown printer took a galley of type and scrambled it to make a type
 specimen book. It has survived not only five centuries, but also the leap into
 electronic typesetting, remaining essentially unchanged. It was popularised in 
 the 1960s with the release of Letraset sheets containing Lorem Ipsum passages,
 and more recently with desktop publishing software like Aldus PageMaker 
 including versions of Lorem Ipsum');
 
 INSERT INTO 
	customer (customer_id, name, email, phone, age, city, postal_code, country, consent_status, is_profile_active) 		 			 
VALUES 
(9, 'Irk', 'mrk@abv.bg', +359888444561, 25,  'Sofia', 359, 'BG', true, true), 
(10, 'Ace', '5alice@jit.bg', +359888444561, 26,  'Athens', 478, 'Greece', false, true),
(11, 'Cjob', 'dbob@fsdg.bg', +359888444561, 46,  'Sliven', 368, 'Bulgaria', true, false),
(12, 'Caie', 'c2harlie@gmail.bg', +359888444561, 64, 'Ruse', 258, 'Bulgaria', true, true);
 
 
 -------------------------------------------


 --1:1 relationship between customers and customers_addresses tables:
CREATE TABLE 
	customer_address (
		address_id SERIAL PRIMARY KEY NOT NULL,
		customer_id INT NOT NULL,
		address VARCHAR(255),
		city VARCHAR(255) NOT NULL, 
		province VARCHAR(255),
		state_UK VARCHAR(255),
		postal_code INT CHECK (postal_code > 0),
		country VARCHAR(255) NOT NULL,
		CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
		);


--INSERT some of the fields:
INSERT INTO 
	customer_address (customer_id, address, city, state_UK, postal_code, country) 	 	
VALUES 
	(3, '200 Westminster Bridge Road, London, SE1 7UT, United Kingdom', 'London', 'UK', 5211, 'United Kingdom'),
	(1, 'St Katharines Way, London, E1W 1LD, United Kingdom', 'London', 'UK', 5211, 'United Kingdom'),
	(5, '11 Blackfriars Street, Manchester, M3 5AL, United Kingdom', 'Manchester', 'UK', 8911, 'United Kingdom'),
	(6, '1 Morrison Link, Edinburgh, EH3 8DN, United Kingdom', 'Edinburgh', 'UK', 1211, 'United Kingdom'),
	(2, '3-5 Portland Street, Manchester, M1 6DP, United Kingdom', 'Manchester', 'UK', 5295, 'United Kingdom'),
	(4, 'Great Colmore Street, Birmingham, B15 2AP, United Kingdom', 'Birmingham', 'UK', 3737, 'United Kingdom');