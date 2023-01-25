
CREATE TABLE IF NOT EXISTS my_store.product
(
    id serial NOT NULL PRIMARY KEY ,
    fk_order_id integer constraint data_source_fk_connection_id_fkey references my_store.order,
    price      double precision,
    price2      double precision,
    name text
    );



