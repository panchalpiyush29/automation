CREATE SEQUENCE dogs_id_seq;
CREATE TABLE dogs (
  id INTEGER NOT NULL DEFAULT nextval('dogs_id_seq') PRIMARY KEY,
  name VARCHAR NOT NULL UNIQUE,
  age INTEGER NOT NULL
);
ALTER SEQUENCE dogs_id_seq OWNED BY dogs.id;
CREATE INDEX dogs_name_index ON dogs USING BTREE (name);