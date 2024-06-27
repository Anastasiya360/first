create table shop.orders
(
    id         serial
        constraint orders_pk
            primary key,
    users_id   integer,
    constraint orders_user_id_fk
        foreign key (users_id) references shop.users (id),
    order_date date,
    status     varchar
);
create index orders_users_id_ix on shop.orders (users_id);
create unique index orders_status_ux on shop.orders (status);