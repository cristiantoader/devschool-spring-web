-- Current pizzas available to make
create table ds_pizza(
    id int primary key,
    name varchar(255),
    price double
);

create sequence if not exists ds_pizza_seq start with 1 increment by 1;

insert into ds_pizza (id, name, price) values (ds_pizza_seq.nextval, 'Festiva', 49.0);
insert into ds_pizza (id, name, price) values (ds_pizza_seq.nextval, 'All Cheese', 36.25);
insert into ds_pizza (id, name, price) values (ds_pizza_seq.nextval, 'Country', 43.75);
insert into ds_pizza (id, name, price) values (ds_pizza_seq.nextval, 'Hot Cheese', 43.75);
insert into ds_pizza (id, name, price) values (ds_pizza_seq.nextval, 'Classic', 40);
insert into ds_pizza (id, name, price) values (ds_pizza_seq.nextval, 'Aloha', 43.75);
insert into ds_pizza (id, name, price) values (ds_pizza_seq.nextval, 'Carnivor', 40.00);

-- One order item out of an order
create table ds_pizza_order_item(
    id int primary key,
    id_pizza int,
    id_pizza_order int,
    discount double
);

-- An order which needs to be picked up
create table ds_pizza_order(
    id int primary key,
    address varchar(255)
);