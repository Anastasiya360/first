create table shop.table_goods_purchases
(
    order_id integer,
    constraint table_goods_purchases_order_id_fk
        foreign key (order_id) references shop.orders(id),
    goods_id integer,
    constraint table_goods_purchases_goods_id_fk
        foreign key (goods_id) references shop.goods(id),
    amount   integer,
    price    real
);
create index table_goods_purchases_order_id_ix on shop.table_goods_purchases (order_id);
create index table_goods_purchases_goods_id_ix on shop.table_goods_purchases (goods_id);