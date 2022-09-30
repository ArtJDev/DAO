create table customers (
                           id bigint not null auto_increment primary key,
                           name varchar(20),
                           surname varchar(30),
                           age smallint,
                           phone_number varchar(16)
);

create table orders (
                        id bigint not null auto_increment primary key,
                        date date,
                        customer_id bigint,
                        product_name varchar(50),
                        amount double precision,
                        foreign key (customer_id) references customers (id)
);