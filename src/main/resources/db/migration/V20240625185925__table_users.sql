create table shop.users
(
    id       serial
        constraint users_pk
            primary key,
    name     varchar,
    surname  varchar,
    role_id  integer,
    constraint users_role_id_fk
        foreign key (role_id) references shop.role (id),
    birthday date,
    login    varchar,
    password varchar,
    phone    varchar
);
create index users_role_id_ix on shop.users (role_id);
create unique index users_login_ux on shop.users (login);