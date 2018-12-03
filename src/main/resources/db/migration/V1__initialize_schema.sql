-- Current pizzas available to make
create table ds_pizza(
    id int primary key,
    name varchar(255),
    price double
);

insert into ds_pizza (id, name, price) values (1, 'Festiva', 49.0);
insert into ds_pizza (id, name, price) values (2, 'All Cheese', 36.25);
insert into ds_pizza (id, name, price) values (3, 'Country', 43.75);
insert into ds_pizza (id, name, price) values (4, 'Hot Cheese', 43.75);
insert into ds_pizza (id, name, price) values (5, 'Classic', 40);
insert into ds_pizza (id, name, price) values (6, 'Aloha', 43.75);
insert into ds_pizza (id, name, price) values (7, 'Carnivor', 40.00);

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