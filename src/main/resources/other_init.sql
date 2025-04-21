CREATE table users
(
    id         serial primary key,
    username   varchar(128) unique,
    firstname  varchar(128),
    lastname   varchar(128),
    birth_date date,
    role       varchar(128)
);

CREATE TABLE company (
    id serial primary key ,
    name varchar(128) NOT NULL UNIQUE
);

CREATE table users
(
    id         serial primary key,
    username   varchar(128) unique,
    firstname  varchar(128),
    lastname   varchar(128),
    birth_date date,
    role       varchar(128),
    company_id int references company(id)
);

select *
from pg_extension;

show max_connections;

drop table users;

create sequence lol_seq_name owned by users.id;