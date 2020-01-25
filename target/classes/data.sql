drop table if exists users;
drop table if exists orders;
drop table if exists tours;

create table users (
  PRIMARY KEY (user_id),
  user_id     bigint auto_increment NOT NULL,
  first_name  VARCHAR(100) NOT NULL,
  last_name   VARCHAR(100) NOT NULL,
  email       VARCHAR(100) NOT NULL,
  password    VARCHAR(100) NOT NULL,
  active      boolean not null,
  birthday    date not null,
  role       VARCHAR(25) NOT NULL

);

insert into users
values (1,'Vasya','Pupkin','VP@mail','$2a$10$AvVEW4wYqxCi8rfJBr4c8e2CCSejb/.4J51RqkkvienhptrtLXzWa',true,to_date('24.10.1983','dd.mm.yyyy'), 'ROLE_USER');
insert into users
values (2,'Petya','Tuzikov','PT@mail','$2a$10$ZkuQ4c9obrkx9FRvDqHOweux73bx8JAtu1GVv0xCdtYERdlerScqi',true,to_date('05.03.1992','dd.mm.yyyy'), 'ROLE_USER');
insert into users
values (3,'Oleg','Leg','OL@mail','$2a$10$bNoaZbK5CRTV5UkAHxeVVuZP8m5Tq3muOT0fIW9X.gINIFqG3.IRK',false,to_date('11.06.1990','dd.mm.yyyy'), 'ROLE_USER');
insert into users
values (4,'Admin','Admin','admin','$2a$10$cer.RBiMc.FoxZI.nkaE0OvjZd48jencwoj84Gd4YlnsSWm1PM3Ui',true,to_date('25.04.1990','dd.mm.yyyy'), 'ROLE_ADMIN');

create table orders (
  PRIMARY KEY (order_id),
  order_id     bigint auto_increment NOT NULL,
  user_id      bigint NOT NULL,
  tour_id      bigint NOT NULL,
  confirmed    boolean not null,
  time_key     date not null
);

insert into orders
values (1,1,1,true,to_date('31.12.2019','dd.mm.yyyy'));
insert into orders
values (2,1,2,false,to_date('31.12.2019','dd.mm.yyyy'));
insert into orders
values (3,2,1,true,to_date('05.01.2019','dd.mm.yyyy'));

create table tours (
  PRIMARY KEY (tour_id),
  tour_id     bigint auto_increment NOT NULL,
  name         VARCHAR(100) NOT NULL,
  description  VARCHAR(255) NOT NULL,
  location     VARCHAR(100) NOT NULL,
  start_date   date not null,
  end_date     date not null,
  count_limit  int not null
);

insert into tours
values (1,'Tokyo','Gorod','Japan',to_date('11.01.2020','dd.mm.yyyy'),to_date('20.01.2020','dd.mm.yyyy'),1);
insert into tours
values (2,'Paris','Gorod','France',to_date('25.02.2021','dd.mm.yyyy'),to_date('05.03.2021','dd.mm.yyyy'),3);
insert into tours
values (3,'London','Gorod','England',to_date('09.01.2021','dd.mm.yyyy'),to_date('20.01.2021','dd.mm.yyyy'),1);