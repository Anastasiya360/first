create schema shop;
create table shop.role
(
    id         serial
        constraint role_pk
            primary key,
    name       varchar,
    permission varchar
);
create unique index role_name_ux on shop.role (name);