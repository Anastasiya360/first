create table shop.picture_of_goods
(
    id       serial
        constraint picture_of_goods_pk
            primary key,
    goods_id integer,
    constraint picture_of_goods_goods_id_fk
        foreign key (goods_id) references shop.goods (id),
    picture  varchar
);
create index picture_of_goods_goods_id_ix on shop.picture_of_goods (goods_id);