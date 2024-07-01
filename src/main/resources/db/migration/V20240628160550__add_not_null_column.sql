alter table shop.role
    alter column name set not null,
    alter column permission set not null;
alter table shop.users
    alter column name set not null,
    alter column role_id set not null,
    alter column login set not null,
    alter column password set not null;
alter table shop.types_of_goods
    alter column name set not null;
alter table shop.goods
    alter column name set not null,
    alter column goods_type_id set not null,
    alter column unit_price set not null;
alter table shop.picture_of_goods
    alter column goods_id set not null,
    alter column picture set not null;
alter table shop.reviews
    alter column users_id set not null,
    alter column goods_id set not null,
    alter column description set not null;
alter table shop.orders
    alter column users_id set not null,
    alter column order_date set not null,
    alter column status set not null;
alter table shop.table_goods_purchases
    alter column goods_id set not null,
    alter column amount set not null,
    alter column price set not null;