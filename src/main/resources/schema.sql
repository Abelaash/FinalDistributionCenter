create table if not exists Item (
  id identity,
  name varchar(100) not null,
  brand varchar(100) not null,
  year_Of_Creation int not null,
  quantity int not null,
  price double not null,
  created_at timestamp not null
);

create table if not exists Distribution_Centre (
  id identity,
  name varchar(100) not null,
  latitude float not null,
  longitude float not null
);