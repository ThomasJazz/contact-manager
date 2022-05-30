DROP PROCEDURE sp_add_user_account;


CREATE OR REPLACE PROCEDURE sp_add_user_account (
    _first_name CHAR (50), 
    _last_name CHAR (50),
    _birthday DATE,
    _mobile_number phone_number,
    _address TEXT,--us_postal_code,
    _email_address email,
    _notes CHAR(256)
)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO user_account
    (
        first_name, 
        last_name, 
        birthday, 
        mobile_number, 
        home_address, 
        email_address, 
        notes
    )
    VALUES 
    (
        _first_name, 
        _last_name, 
        _birthday, 
        _mobile_number,
        _address,
        _email_address,
        _notes
    )
    RETURNING id;
END;
$$;