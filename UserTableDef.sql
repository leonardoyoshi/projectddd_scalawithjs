create database UserTableDef;

use UserTableDef;

create table User(
id_user int(5) auto_increment,
name varchar(60),
Cpfcnpj varchar(30),
age int(2),
adress varchar(70),
constraint pk_id_user primary key(id_user)
);

create table product(
id_product int(5) auto_increment,
name_product varchar(80),
price decimal(8,2),
category varchar(30),
constraint pk_id_product primary key (id_product)
);
