
create table user
(
	id int auto_increment comment 'id'
		primary key,
	name varchar(255) not null comment 'name',
	ACCOUNT_ID varchar(255) not null comment '账户id',
	TOKEN varchar(255) not null comment '登录标识',
	GMT_CREATE bigint not null comment '创建时间',
	GMT_MODIFIED bigint not null comment '修改时间'
);

