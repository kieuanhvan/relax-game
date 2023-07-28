-- drop database healthy_fruits_shop 

 
CREATE DATABASE healthy_fruits_shop_ASM;

use healthy_fruits_shop_ASM ;

 
CREATE TABLE accounts 
( 
id int auto_increment primary key,
 username  varchar (50) not null unique, 
password   varchar (50) NULL,
 email   varchar (50) NULL, 
 fullname   nvarchar (50) NULL, 
  photo   varchar (50) NULL, 
 admin   bit  NOT NULL, 
  activated   bit  NOT NULL
) ;

CREATE TABLE  categories ( 
id int auto_increment primary key,
 name   varchar (50)  
);
 
CREATE TABLE  products ( 
 id   int  auto_increment primary key, 
 createdate   date  NULL, 
 image   text NULL, 
 name   varchar (50) NULL, 
 price   float  NULL, 
 description text null,
  available   bit  NULL, 
 categoryid   int,
 foreign key (categoryid) references categories(id) 
) ;

CREATE TABLE  orders ( 
 id   int  auto_increment primary key, 
 address   varchar (50) NULL, 
 createdate   date  NULL, 
 id_user   int ,
  foreign key (id_user) references accounts(id)
);
 
CREATE TABLE  orderdetails ( 
 id   int  auto_increment primary key, 
 price   float  NULL, 
 quantity   int  NULL, 
 orderid   int  ,
 productid   int , 
  foreign key (orderid) references orders(id), 
   foreign key (productid) references products(id) 
) ;
 drop table Cart_Session;
create table Cart_Session(
id   int  auto_increment primary key, 
 price   float  NULL, 
 quantity   int  NULL, 
  createdate   date  NULL, 
  updatedate date Null,
 productid   int ,
 id_user   int , 
  foreign key (productid) references products(id) ,
foreign key (id_user) references accounts(id)
);

-- Insert vào bảng accounts
INSERT INTO accounts (username, activated, admin, email, fullname, password, photo)
VALUES 
    ('user1', 1, 0, 'user1@example.com', N'Nguyễn Văn A', 'password1', 'photo1.jpg'),
    ('user2', 1, 0, 'user2@example.com', N'Trần Thị B', 'password2', 'photo2.jpg'),
    ('user3', 1, 0, 'user3@example.com', N'Phạm Văn C', 'password3', 'photo3.jpg'),
    ('user4', 1, 0, 'user4@example.com', N'Lê Thị D', 'password4', 'photo4.jpg'),
    ('user5', 1, 0, 'user5@example.com', N'Nguyễn Văn E', 'password5', 'photo5.jpg'),
    ('user6', 1, 0, 'user6@example.com', N'Trần Thị F', 'password6', 'photo6.jpg'),
    ('user7', 1, 0, 'user7@example.com', N'Phạm Văn G', 'password7', 'photo7.jpg'),
    ('user8', 1, 0, 'user8@example.com', N'Lê Thị H', 'password8', 'photo8.jpg'),
    ('user9', 1, 0, 'user9@example.com', N'Nguyễn Văn I', 'password9', 'photo9.jpg'),
    ('user10', 1, 0, 'user10@example.com', N'Trần Thị K', 'password10', 'photo10.jpg');
INSERT INTO accounts (username, activated, admin, email, fullname, password, photo)
VALUES ('lai', 1, 1, 'user10@example.com', N'Trần Thị K', '123', 'photo10.jpg');
-- Insert vào bảng categories
INSERT INTO categories ( name)
VALUES 
    (  N'Category 1'),
    ( N'Category 2'),
    ( N'Category 3'),
    ( N'Category 4'),
    ( N'Category 5'),
    ( N'Category 6'),
    ( N'Category 7'),
    ( N'Category 8'),
( N'Category 9'),
    ( N'Category 10');

-- Insert vào bảng products
INSERT INTO products (available, createdate, image, name, price, categoryid)
VALUES 
    (1, '2023-05-23', 'image1.jpg', N'Product 1', 350.0, 1),
    (1, '2023-05-23', 'image2.jpg', N'Product 2', 400.0, 1),
    (1, '2023-05-23', 'image3.jpg', N'Product 3', 320.0, 3),
    (1, '2023-05-23', 'image4.jpg', N'Product 4', 450.0, 4),
    (1, '2023-05-23', 'image5.jpg', N'Product 5', 500.0, 5),
    (1, '2023-05-23', 'image6.jpg', N'Product 6', 370.0, 1),
    (1, '2023-05-23', 'image7.jpg', N'Product 7', 480.0, 7),
    (1, '2023-05-23', 'image8.jpg', N'Product 8', 410.0, 8),
    (1, '2023-05-23', 'image9.jpg', N'Product 9', 390.0, 9),
    (1, '2023-05-23', 'image10.jpg', N'Product 10', 420.0, 10);
delete from healthy_fruits_shop_asm.products where id <11;
-- Insert vào bảng orders
INSERT INTO orders (address, createdate, id_user)
VALUES 
    ('Quận 1, TP. Hồ Chí Minh', '2023-05-23', 1),
    ('Quận 2, TP. Hồ Chí Minh', '2023-05-23', 2),
    ('Quận 3, TP. Hồ Chí Minh', '2023-05-23', 3),
    ('Quận 4, TP. Hồ Chí Minh', '2023-05-23', 4),
    ('Quận 5, TP. Hồ Chí Minh', '2023-05-23', 5),
    ('Quận 6, TP. Hồ Chí Minh', '2023-05-23', 6),
    ('Quận 7, TP. Hồ Chí Minh', '2023-05-23', 7),
    ('Quận 8, TP. Hồ Chí Minh', '2023-05-23', 8),
    ('Quận 9, TP. Hồ Chí Minh', '2023-05-23', 9),
    ('Quận 10, TP. Hồ Chí Minh', '2023-05-23', 10);

-- Insert vào bảng orderdetails
INSERT INTO orderdetails (price, quantity, orderid, productid)
VALUES 
    (350.0, 1, 1, 1),
    (400.0, 2, 2, 2),
    (320.0, 3, 3, 3),
    (450.0, 4, 4, 4),
    (500.0, 5, 5, 5),
    (370.0, 1, 6, 6),
    (480.0, 2, 7, 7),
    (410.0, 3, 8, 8),
    (390.0, 4, 9, 9),
    (420.0, 5, 10, 10);

select * from accounts ;
select * from Cart_Session ;
select * from categories ;

select * from products ;

select * from orders ;

select * from orderdetails ;

INSERT INTO products (  available, createdate, image, name, price, categoryid)
VALUES 
    (1, '2023-05-11', 'image2.jpg', N'Product 22', 350.30, 1)