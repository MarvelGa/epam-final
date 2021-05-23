USE fly_tct;

INSERT INTO roles VALUES(1, 'admin');
INSERT INTO roles VALUES(2, 'user');
INSERT INTO roles VALUES(3, 'guest');

insert into users (email, first_name, last_name, password, role_id) values ('admin88@gmail.com', 'Ivan', 'Ivanov', '202cb962ac59075b964b07152d234b70', 1);
