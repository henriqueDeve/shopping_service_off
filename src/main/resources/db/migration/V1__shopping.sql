create schema if not exists shopping;

create table shopping.shop (
id bigserial primary key,
user_id varchar(100) not null,
date_shop timestamp not null,
total float not null
);

create table shopping.item (
shop_id bigserial REFERENCES shopping.shop(id),
product_id varchar(100) not null,
price float not null
);