-- DROP
DROP TABLE user_account;

CREATE TABLE user_account (
    user_account_id SERIAL PRIMARY KEY,
    first_name VARCHAR (50) NOT NULL,
    last_name VARCHAR (50),
    birthday DATE,
    mobile_number phone_number,
    home_address VARCHAR(128),--us_postal_code,
    email_address email,
    notes VARCHAR (256),
    create_date_time TIMESTAMP WITHOUT TIME ZONE DEFAULT (NOW() AT TIME ZONE 'utc')
);