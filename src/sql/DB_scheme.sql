CREATE TABLE users
(
  id serial NOT NULL,
  name text NOT NULL,
  second_name text,
  birth_date date NOT NULL,
  role text NOT NULL,
  creation_date date NOT NULL,
  car_id integer,
  CONSTRAINT users_pkey PRIMARY KEY (id),
  CONSTRAINT FOREIGN KEY (car_id)
      REFERENCES cars (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

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
);

CREATE TABLE cars
(
  id serial NOT NULL,
  car_name text NOT NULL,
  car_type text NOT NULL,
  user_id integer NOT NULL,
  CONSTRAINT cars_pk PRIMARY KEY (id),
  CONSTRAINT cars_user_id_fk FOREIGN KEY (user_id)
      REFERENCES users (id)
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE points
(
  user_id integer NOT NULL,
  amount integer NOT NULL,
  CONSTRAINT points_user_id_fk FOREIGN KEY (user_id)
      REFERENCES users (id)
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE testdrives
(
  id serial NOT NULL,
  car_id integer NOT NULL,
  provider_id integer NOT NULL,
  user_id integer NOT NULL,
  testdrive_date date NOT NULL,
  CONSTRAINT testdives_pk PRIMARY KEY (id),
  CONSTRAINT testdrives_user_id_fk FOREIGN KEY (user_id)
      REFERENCES users (id)
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT testdrives_car_id_fk FOREIGN KEY (car_id)
      REFERENCES cars (id)
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT testdrives_provider_id_fk FOREIGN KEY (provider_id)
      REFERENCES users (id)
      ON UPDATE NO ACTION ON DELETE NO ACTION
)