USE fly_tct1;

INSERT INTO roles VALUES(1, 'admin');
INSERT INTO roles VALUES(2, 'user');
INSERT INTO roles VALUES(3, 'guest');

insert into users (email, first_name, last_name, password, role_id) values ('admin88@gmail.com', 'Ivan', 'Ivanov', '202cb962ac59075b964b07152d234b70', 1);

INSERT INTO cities (name) VALUES ('Kyiv');
INSERT INTO cities (name) VALUES ('Kharkiv');
INSERT INTO cities (name) VALUES ('Lviv');
INSERT INTO cities (name) VALUES ('Dnipro');

INSERT INTO distance (city_from_id, city_to_id, distance) VALUES (1, 2, 479);
INSERT INTO distance (city_from_id, city_to_id, distance) VALUES (1, 3, 534);
INSERT INTO distance (city_from_id, city_to_id, distance) VALUES (1, 4, 486);

INSERT INTO distance (city_from_id, city_to_id, distance) VALUES (2, 1, 479);
INSERT INTO distance (city_from_id, city_to_id, distance) VALUES (2, 3, 1013);
INSERT INTO distance (city_from_id, city_to_id, distance) VALUES (2, 4, 221);

INSERT INTO distance (city_from_id, city_to_id, distance) VALUES (3, 1, 534);
INSERT INTO distance (city_from_id, city_to_id, distance) VALUES (3, 2, 1013);
INSERT INTO distance (city_from_id, city_to_id, distance) VALUES (3, 4, 805);

INSERT INTO distance (city_from_id, city_to_id, distance) VALUES (4, 1, 486);
INSERT INTO distance (city_from_id, city_to_id, distance) VALUES (4, 2, 221);
INSERT INTO distance (city_from_id, city_to_id, distance) VALUES (4, 3, 805);
