INSERT INTO address (city, country, street, street_number)
VALUES ('Opole', 'Polska', 'Bajkowa', 'c');
INSERT INTO address (city, country, street, street_number)
VALUES ('Wrocław', 'Polska', 'Bajkowa1', '1c');
INSERT INTO address (city, country, street, street_number)
VALUES ('Kluczbork', 'Polska', 'Bajkowa2', '2c');
INSERT INTO address (city, country, street, street_number)
VALUES ('Warszwa', 'Polska', 'Bajkowa3', '3c');
INSERT INTO address (city, country, street, street_number)
VALUES ('Bydgoszcz', 'Polska', 'Bajkowa4', '4c');

INSERT INTO permission_level (description, name, priviliges)
VALUES ('Osoba zajmująca się systemami TI', 'administrator', 'admin');
INSERT INTO permission_level (description, name, priviliges)
VALUES ('Użytkownik podstawowy', 'użytkownik', 'user');
INSERT INTO permission_level (description, name, priviliges)
VALUES ('Użytkownik rozszeżony', 'super użytkownik', 'suser');

INSERT INTO department (description, long_name, short_name)
values ('Dział Kwatermistrzowski', 'Dział Kwatermistrzowski', 'DKW');
INSERT INTO department (description, long_name, short_name)
values ('Dział zajmujący się sprawami informatycznymi', 'Dział Informatyzacji i łączności', 'DIL');
INSERT INTO department (description, long_name, short_name)
values ('Dział zajmujący się sprawami finanosowymi', 'Dział Finansowy', 'DF');

INSERT INTO employees (birth_date, created_date, email, first_name, lastname, pesel, photo_id, sex, address_id,
                       department_id, permission_level_id)
VALUES (now(), now(), 'tomek@sw.pl', 'Tomek', 'Smereczyński', '55053017675', 'link', 'male', 1, 1, 1);
INSERT INTO employees (birth_date, email, first_name, lastname, pesel, photo_link, sex, address_id, department_id,
                       permission_level_id)
VALUES (now(), now(), 'tomek@sw.pl1', 'Tomek1', 'Smereczyński1', '65012314266', 'link1', 'female', 2, 2, 2);
INSERT INTO employees (birth_date, email, first_name, lastname, pesel, photo_link, sex, address_id, department_id,
                       permission_level_id)
VALUES (now(), now(), 'tomek@sw.pl2', 'Tomek2', 'Smereczyński2', '98101599833', 'link2', 'female', 2, 1, 2);
