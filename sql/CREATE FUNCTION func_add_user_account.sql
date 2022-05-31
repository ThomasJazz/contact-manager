CREATE OR REPLACE FUNCTION func_add_user_account (
    _first_name CHAR (50), 
    _last_name CHAR (50),
    _birthday DATE,
    _mobile_number phone_number,
    _home_address CHAR (128),--us_postal_code,
    _email_address email,
    _notes CHAR(256)
)
RETURNS integer
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
        _home_address,
        _email_address,
        _notes
    );
    RETURN(SELECT user_account_id FROM user_account ORDER BY user_account_id DESC LIMIT 1);
END;
$$;