CREATE SCHEMA IF NOT EXISTS fly_tct;

USE fly_tct;

DROP TABLE IF EXISTS cities, `roles`, users, items, `orders`, order_items;

CREATE TABLE `cities`
(
    `id`   INT PRIMARY KEY AUTO_INCREMENT,
    `name` varchar(255) NOT NULL
);

CREATE TABLE `roles`
(
    `id`   INT PRIMARY KEY AUTO_INCREMENT,
    `name` varchar(255) NOT NULL
);

CREATE TABLE users
(
    `id`         INT PRIMARY KEY AUTO_INCREMENT,
    `email`      varchar(255) NOT NULL,
    `first_name` varchar(255) NOT NULL,
    `last_name`  varchar(255) NOT NULL,
    `password` varchar (255) NOT NULL,
    `role_id`    INT          NOT NULL,
    CONSTRAINT `fk_role_id`
        FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE
);

CREATE TABLE items
(
    `id`                INT PRIMARY KEY AUTO_INCREMENT,
    `city_sender_id`    INT NOT NULL,
    `city_recipient_id` INT NOT NULL,
    `max_weight`        DOUBLE       NOT NULL,
    `max_length`        DOUBLE       NOT NULL,
    `max_width`         DOUBLE       NOT NULL,
    `max_height`        DOUBLE       NOT NULL,
    `price`             DOUBLE       NOT NULL,
    `status`            varchar(255) NOT NULL,
    `created_at`        DATETIME     NOT NULL,
    CONSTRAINT `fk_city_sender_id`
        FOREIGN KEY (`city_sender_id`) REFERENCES `cities` (`id`) ON DELETE CASCADE,
    CONSTRAINT `fk_city_recipient_id`
        FOREIGN KEY (`city_recipient_id`) REFERENCES `cities` (`id`) ON DELETE CASCADE
);

CREATE TABLE orders
(
    `id`         INT PRIMARY KEY AUTO_INCREMENT,
    `user_id`    INT NOT NULL,
    `status`     varchar(255) NOT NULL,
    `created_at` DATETIME     NOT NULL,
    CONSTRAINT `fk_user_id`
        FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
);

CREATE TABLE order_items
(
    `id`         INT PRIMARY KEY AUTO_INCREMENT,
    `order_id`   INT NOT NULL,
    `item_id` INT NOT NULL,
    `distance` DOUBLE NOT NULL,
    CONSTRAINT `fk_order_id`
        FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE CASCADE,
    CONSTRAINT `fk_product_id`
        FOREIGN KEY (`item_id`) REFERENCES `items` (`id`) ON DELETE CASCADE
);