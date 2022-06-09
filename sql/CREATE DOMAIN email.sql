-- https://dba.stackexchange.com/questions/68266/what-is-the-best-way-to-store-an-email-homeAddress-in-postgresql

CREATE EXTENSION citext;
CREATE DOMAIN email AS citext
CHECK (
    value ~ '^[a-zA-Z0-9.!#$%&''*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$' 
);