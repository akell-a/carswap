CREATE TABLE users
(
  user_id serial NOT NULL,
  name text NOT NULL,
  second_name text,
  password varchar NOT NULL,
  birth_date date,
  role text NOT NULL,
  creation_date date NOT NULL,
  car_id integer,
  CONSTRAINT users_pkey PRIMARY KEY (user_id)
);

CREATE TABLE comments
(
  comment_id serial NOT NULL,
  user_id integer NOT NULL,
  creation_date date NOT NULL,
  text text,
  CONSTRAINT comments_pkey PRIMARY KEY (comment_id),
  CONSTRAINT comments_users_id_fkey FOREIGN KEY (user_id)
      REFERENCES users (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE cars
(
  car_id serial NOT NULL,
  car_name text NOT NULL,
  car_type text NOT NULL,
  user_id integer NOT NULL,
  CONSTRAINT cars_pk PRIMARY KEY (car_id),
  CONSTRAINT cars_user_id_fk FOREIGN KEY (user_id)
      REFERENCES users (user_id)
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE points
(
  point_id serial NOT NULL,
  user_id integer NOT NULL,
  amount integer NOT NULL,
  CONSTRAINT point_pk PRIMARY KEY (point_id),
  CONSTRAINT points_user_id_fk FOREIGN KEY (user_id)
      REFERENCES users (user_id)
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE testdrives
(
  testdrive_id serial NOT NULL,
  car_id integer NOT NULL,
  provider_id integer NOT NULL,
  user_id integer NOT NULL,
  testdrive_date date NOT NULL,
  CONSTRAINT testdives_pk PRIMARY KEY (testdrive_id),
  CONSTRAINT testdrives_user_id_fk FOREIGN KEY (user_id)
      REFERENCES users (user_id)
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT testdrives_car_id_fk FOREIGN KEY (car_id)
      REFERENCES cars (car_id)
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT testdrives_provider_id_fk FOREIGN KEY (provider_id)
      REFERENCES users (user_id)
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

ALTER TABLE users ADD FOREIGN KEY (car_id)
      REFERENCES cars (car_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
