CREATE TABLE contact (
    contact_id SERIAL PRIMARY KEY,
    user_account_id INT NOT NULL,
    first_name CHAR (50) NOT NULL,
    last_name CHAR (50),
    birthday DATE,
    mobile_number phone_number,
    home_address CHAR(128),
    email_address email,
    notes CHAR (256),
    create_date_time TIMESTAMP WITHOUT TIME ZONE DEFAULT (NOW() AT TIME ZONE 'utc'),
    CONSTRAINT fk_user_account
        FOREIGN KEY(user_account_id)
            REFERENCES user_account(user_account_id)
);

CREATE TABLE user_account (
    user_account_id SERIAL PRIMARY KEY,
    first_name CHAR (50) NOT NULL,
    last_name CHAR (50),
    birthday DATE,
    mobile_number phone_number,
    home_address CHAR(128),
    email_address email,
    notes CHAR (256),
    create_date_time TIMESTAMP WITHOUT TIME ZONE DEFAULT (NOW() AT TIME ZONE 'utc')
);