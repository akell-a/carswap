CREATE TABLE users
(
  id serial NOT NULL,
  name text NOT NULL,
  second_name text,
  role text NOT NULL,
  creation_date date NOT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (id)
)

CREATE TABLE comments
(
  id serial NOT NULL,
  users_id integer NOT NULL,
  creation_date date NOT NULL,
  text text,
  CONSTRAINT comments_pkey PRIMARY KEY (id),
  CONSTRAINT comments_users_id_fkey FOREIGN KEY (users_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)