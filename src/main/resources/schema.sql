create table if not exists House_Creator (
    id identity,
    customer_name varchar(50) not null,
    customer_phone varchar(15) not null,
    cc_number varchar(16) not null,
    cc_expiration varchar(5) not null,
    cc_cvv varchar(3) not null,
    placed_at timestamp not null
    );
create table if not exists House (
    id identity,
    name varchar(50) not null,
    house_order bigint not null,
    house_order_key bigint not null,
    created_at timestamp not null
    );
create table if not exists Part_Ref (
    part varchar(4) not null,
    house bigint not null,
    house_key bigint not null
    );
create table if not exists Part (
    id varchar(4) not null,
    name varchar(25) not null,
    type varchar(10) not null
    );
alter table House
    add foreign key (house_order) references House_Creator(id);
alter table Part_Ref
    add foreign key (part) references Part(id);