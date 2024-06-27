create table shop.types_of_goods
(
    id   serial
        constraint types_of_goods_pk
            primary key,
    name varchar
);
create unique index types_of_goods_name_ux on shop.types_of_goods (name);