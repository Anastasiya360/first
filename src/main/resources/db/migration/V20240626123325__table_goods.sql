create table shop.goods
(
    id            serial
        constraint goods_pk
            primary key,
    name          varchar,
    goods_type_id integer,
    constraint goods_type_id_fk
        foreign key (goods_type_id) references shop.types_of_goods (id),
    unit_price    real,
    description   varchar
);
create index goods_goods_type_id_ix on shop.goods (goods_type_id);