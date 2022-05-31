CREATE OR REPLACE FUNCTION func_add_contact (
    _user_account_id INT,
    _first_name CHAR (50), 
    _last_name CHAR (50),
    _birthday DATE,
    _mobile_number phone_number,
    _home_address CHAR (128),--us_postal_code,
    _email_address email,
    _notes CHAR(256)
)
RETURNS INTEGER
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO contact
    (
        user_account_id,
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
        _user_account_id,
        _first_name, 
        _last_name, 
        _birthday, 
        _mobile_number,
        _home_address,
        _email_address,
        _notes
    );
    RETURN(SELECT contact_id FROM contact ORDER BY contact_id DESC LIMIT 1);
END;
$$;