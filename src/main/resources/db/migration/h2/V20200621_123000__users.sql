create table users(
    username varchar_ignorecase(50) not null primary key,
    password varchar_ignorecase(500) not null,
    enabled boolean not null);

create table authorities (
    id binary not null primary key,
    username varchar_ignorecase(50) not null,
    authority varchar_ignorecase(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username));

create unique index ix_auth_username on authorities (username,authority);

insert into users (username, password, enabled)
values ('admin', '$2a$10$M4dQlk68Un1J5JbJqN27sOS1Pbo0Cy5i6PNfWb4Do1vKmTl8QV/r2', true);
insert into authorities (id, username, authority) values ('2D1EBC5B7D2741979CF0E84451C5BBB1', 'admin', 'ROLE_ADMIN');