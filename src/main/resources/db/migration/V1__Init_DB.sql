create sequence hibernate_sequence start 1 increment 1;

create table clients (
    id int8 not null,
    name varchar(20) not null,
    phone varchar(12) not null,
    surname varchar(20) not null,
    primary key (id)
);

create table doctors (
    id int8 not null,
    name varchar(20) not null,
    primary key (id)
);

create table notes (
    id int8 not null,
    title varchar(255),
    doctor_id int8,
    pet_id int8,
    primary key (id)
);

create table pets (
    id int8 not null,
    name varchar(20) not null,
    client_id int8,
    pet_type_id int8,
    primary key (id)
);

create table pet_types (
    id int8 not null,
    name varchar(20) not null,
    primary key (id)
);

alter table if exists clients
    add constraint phone_uk
    unique (phone);

alter table if exists notes
    add constraint note_doctor_fk
    foreign key (doctor_id) references doctors;

alter table if exists notes
    add constraint note_pet_fk
    foreign key (pet_id) references pets;

alter table if exists pets
    add constraint pet_client_fk
    foreign key (client_id) references clients;

alter table if exists pets
    add constraint pet_pet_type_fk
    foreign key (pet_type_id) references pet_types;