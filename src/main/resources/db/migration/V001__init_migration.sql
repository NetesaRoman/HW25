-- Создание схемы
CREATE SCHEMA IF NOT EXISTS my_store;

-- Создание последовательности;
CREATE SEQUENCE IF NOT EXISTS my_store.my_store_id_seq;

-- Создание таблицы;
CREATE TABLE IF NOT EXISTS my_store.order
(
    id integer NOT NULL DEFAULT nextval('my_store.my_store_id_seq') PRIMARY KEY,
    creation_date    date,
    price            double precision
    );


