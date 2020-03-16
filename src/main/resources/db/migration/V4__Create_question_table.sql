create table question
(
	id int auto_increment,
	title varchar(255) null,
	description text null,
	creator int null ,
	gmt_create bigint null,
	gmt_modified bigint null,
	comment_count int default 0 null,
	view_count int default 0 null,
	like_count int default 0 null,
	tag varchar(255) null,
	constraint question_pk
		primary key (id)
)
comment '发布问题';

