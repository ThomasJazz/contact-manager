CREATE DOMAIN phone_number AS TEXT 
CHECK (
    VALUE ~ '^[0-9]{10}$'
);

-- https://www.postgresql.org/docs/current/sql-createdomain.html