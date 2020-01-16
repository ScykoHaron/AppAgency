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
values (1,'Vasya','Pupkin','VP@mail','$2y$12$r2a.lvWGDQvaejgdUTf4C.NmD1FuVkPw5CR.Bmiv8K1RTwtVHVUyS',true,to_date('24.10.1983','dd.mm.yyyy'), 'USER');
insert into users
values (2,'Petya','Tuzikov','PT@mail','$2y$12$dHnezQTHf4gX54zDV64WOudr3sx5rGq6GIEka3SychdvNiQzk7szW',true,to_date('05.03.1992','dd.mm.yyyy'), 'USER');
insert into users
values (3,'Oleg','Leg','OL@mail','$2y$12$3048Gz5gYwBeEDzVVKNR/.FGBYJ2BM0MDfdfL79WWY6wQ6HHnhUZK',false,to_date('11.06.1990','dd.mm.yyyy'), 'USER');
insert into users
values (4,'Admin','Admin','admin','$2y$12$1lZ6rw50dXEfZOlVtBrRPOgihw1YQMiaqm1vB.JEL3OcziYOglLeq',true,to_date('25.04.1990','dd.mm.yyyy'), 'ADMIN');

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
values (1,'Tokyo','Gorod','Japan',to_date('11.01.2020','dd.mm.yyyy'),to_date('20.01.2020','dd.mm.yyyy'),3);
insert into tours
values (2,'Paris','Gorod','France',to_date('25.02.2020','dd.mm.yyyy'),to_date('05.03.2020','dd.mm.yyyy'),1);
insert into tours
values (3,'London','Gorod','England',to_date('09.01.2020','dd.mm.yyyy'),to_date('20.01.2020','dd.mm.yyyy'),1);