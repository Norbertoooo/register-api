create table account(
    id bigserial primary key,
    name varchar(150) not null,
    last_name varchar(150) not null,
    token varchar(255) not null,
    password varchar(255) not null,
    birthdate date not null,
    document varchar(255) not null,
    document_type varchar(255) not null,
    create_date date not null,
    score decimal
);