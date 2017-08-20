create database product CHARSET 'UTF8' COLLATE 'utf8_unicode_ci';

use product;

create table product
(
	id varchar(20) not null,
    name nvarchar(100) not null,
    info nvarchar(100) not null,
    price int not null,
    
    primary key (id)
);

create table user
(
	username varchar(50) not null,
    pass mediumtext not null,
    name nvarchar(100) not null,
    address nvarchar(200) not null,
    email nvarchar(100) not null,
    phone text not null,
    
    primary key (username)
);

create table role
(
	id varchar(20) not null,
    username varchar(50) not null,
    role varchar(50) not null,
    
    primary key(id)
);

insert into product values ("001", "Sản phẩm 1", "Đây là thông tin sản phẩm 1", 20000),
							("002", "Sản phẩm 2", "Đây là thông tin sản phẩm  2", 20000),
                            ("003", "Sản phẩm 3", "Đây là thông tin sản phẩm  3", 20000);
                            
insert into user values ("user1", "1234", "Nguyễn Văn User1" , "Địa chỉ user1", "user1@gmail.com", "0987654321"),
						("user2", "1234", "Nguyễn Văn User2", "Địa chỉ user2", "user2@gmail.com", "0123456789"),
						("admin1", "1234", "Nguyễn Văn Admin1", "Địa chỉ admin1", "admin1@gmail.com", "0123321123"),
                        ("admin2", "1234", "Nguyễn Văn Admin2", "Địa chỉ admin2", "admin2@gmail.com", "0987987987");
                        
insert into role values ("U1", "user1", "USER"), ("U2", "user2", "USER"), ("A1", "admin1", "ADMIN"), ("A2", "admin2", "ADMIN");