DROP FUNCTION func_add_user_account;
DROP TABLE user_account;
DROP DOMAIN phone_number;
DROP DOMAIN us_postal_code;

-- CREATE DOMAIN phone_number AS TEXT 
-- CHECK (
--     VALUE ~ '^\s*(?:\+?(\d{1,3}))?[-. (]*(\d{3})[-. )]*(\d{3})[-. ]*(\d{4})(?: *x(\d+))?\s*$'
-- );

CREATE DOMAIN phone_number AS VARCHAR(20) CHECK(VALUE ~ '^[0-9]{10}$');

-- https://www.postgresql.org/docs/current/sql-createdomain.html