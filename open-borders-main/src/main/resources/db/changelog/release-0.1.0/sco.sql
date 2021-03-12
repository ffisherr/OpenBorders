create sequence message_seq_id start with 1 INCREMENT BY 1;

drop table if exists messages;

create table messages (
    id bigint not null,
    message text not null,
    user_id int not null,
    is_from bool not null default false,
    sent_at timestamp not null default now(),
    constraint PK_MESSAGES_ID primary key (id)
);

drop table if exists users;

create table users (
    id integer not null,
    email text not null,
    pwd text not null,
    constraint PK_USERS_ID primary key (id)
);

drop table if exists countries;

create table countries (
    id integer not null,
    name text not null,
    is_available bool not null default false,
    constraint PK_COUNTRIES_ID primary key (id)
);
--
-- temp
-- insert into messages values ( -1, 'Hi', 1, true, '2021-03-10 9:59');
-- insert into messages values ( -2, 'Hello somone', 1, false, '2021-03-10 10:00');
