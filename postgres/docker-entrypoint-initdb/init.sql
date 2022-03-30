CREATE DATABASE currencyratesdb;

\connect currencyratesdb;

CREATE ROLE currency_rate WITH
	LOGIN
	NOSUPERUSER
	NOCREATEDB
	NOCREATEROLE
	INHERIT
	NOREPLICATION
	CONNECTION LIMIT -1
	PASSWORD 'currency_rate_password';

CREATE SCHEMA currency_rate
    AUTHORIZATION currency_rate;
	
	
CREATE SEQUENCE currency_rate.entity_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE currency_rate.entity_seq
    OWNER TO currency_rate;

CREATE TABLE currency_rate.currency_rates
(
    id bigint NOT NULL,
    rate DOUBLE PRECISION NOT NULL,
    fetchedOn DATE NOT NULL,
    createdOn timestamp with time zone
);

ALTER TABLE currency_rate.currency_rates
    OWNER to currency_rate;
