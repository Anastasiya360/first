create table shop.reviews
(
    id          serial
        constraint reviews_pk
            primary key,
    users_id    integer,
    constraint reviews_users_id_fk
        foreign key (users_id) references shop.users (id),
    goods_id    integer,
    constraint reviews_goods_id_fk
        foreign key (goods_id) references shop.goods (id),
    description varchar
);
create index reviews_users_id_ix on shop.reviews (users_id);
create index reviews_goods_id_ix on shop.reviews (goods_id);
create unique index reviews_users_id_ux on shop.reviews (users_id);
