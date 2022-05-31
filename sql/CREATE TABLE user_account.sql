-- DROP
DROP TABLE user_account;

CREATE TABLE user_account (
    user_id SERIAL PRIMARY KEY,
    first_name CHAR (50) NOT NULL,
    last_name CHAR (50),
    birthday DATE,
    mobile_number phone_number,
    home_address CHAR(128),--us_postal_code,
    email_address email,
    notes CHAR (256),
    create_date_time TIMESTAMP WITHOUT TIME ZONE DEFAULT (NOW() AT TIME ZONE 'utc')
);