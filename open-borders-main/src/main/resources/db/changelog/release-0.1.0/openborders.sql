drop sequence if exists message_seq_id;
drop sequence if exists country_seq_id;
drop sequence if exists user_seq_id;
drop sequence if exists user_wanted_countries_seq_id;
drop table if exists messages;
drop table if exists users;
drop table if exists countries;
drop table if exists user_wanted_countries;

create sequence message_seq_id start with 1 INCREMENT BY 1;
create sequence country_seq_id start with 1 INCREMENT BY 1;
create sequence user_seq_id start with 1 INCREMENT BY 1;
create sequence user_wanted_countries_seq_id start with 1 INCREMENT BY 1;

create table messages (
    id bigint not null,
    message text not null,
    user_id int not null,
    is_from bool not null default false,
    sent_at timestamp not null default now(),
    constraint PK_MESSAGES_ID primary key (id)
);

create table users (
    id bigint not null,
    email text not null,
    pwd text not null,
    constraint PK_USERS_ID primary key (id)
);

create table user_wanted_countries (
    id bigint not null,
    user_id bigint not null,
    name text not null,
    is_available bool not null default false,
    constraint PK_USER_COUNTRIES_ID primary key (id)
);

create table countries (
    id bigint not null,
    name text not null,
    is_available bool not null default false,
    constraint PK_COUNTRIES_ID primary key (id)
);

insert into countries (id, name) values ( country_seq_id.nextval, 'Австралия' );
insert into countries (id, name) values ( country_seq_id.nextval, 'Великобритания' );
insert into countries (id, name) values ( country_seq_id.nextval, 'Индия' );
insert into countries (id, name) values ( country_seq_id.nextval, 'Куба' );
insert into countries (id, name) values ( country_seq_id.nextval, 'Турция' );
insert into countries (id, name) values ( country_seq_id.nextval, 'Болгария' );
insert into countries (id, name) values ( country_seq_id.nextval, 'Дания' );
insert into countries (id, name) values ( country_seq_id.nextval, 'Италия' );
insert into countries (id, name) values ( country_seq_id.nextval, 'Канада' );

insert into users values ( -1, 'test@gmail.com', 'pwd' )
