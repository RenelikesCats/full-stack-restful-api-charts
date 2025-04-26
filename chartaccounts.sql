set names utf8mb4;
set charset utf8mb4;
create database if not exists charts2023 charset utf8mb4;
use charts2023;

create table accounts (
  id int unsigned not null auto_increment primary key,
  familienaam varchar(50) not null,
  voornaam varchar(50) not null,
  emailAdres varchar(100) not null unique,
  paswoord varchar(100) not null,
  authority varchar(50) not null
);

insert into accounts (familienaam,voornaam,emailAdres,paswoord,authority) values
 ('admin','admin','admin.admin@charts.be','{bcrypt}$2a$12$rvWmp8155isrO06F5dPnCewLBnirK/mMu0V/ildcgCtBE.IrR4AKu', 'admin');
 