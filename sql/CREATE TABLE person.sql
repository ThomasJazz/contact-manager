CREATE TABLE person (
    id INT NOT NULL PRIMARY KEY,
    first_name CHAR (50) NOT NULL,
    last_name CHAR (50),
    birthday DATE,
    mobile_number phone_number,
    addresses us_postal_code[],
    email_addresses email[],
    notes CHAR (256),
    create_date_time TIMESTAMP WITHOUT TIME ZONE DEFAULT (NOW() AT TIME ZONE 'utc')
);