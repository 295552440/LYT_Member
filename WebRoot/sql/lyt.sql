create database lyt;
use lyt;
create table lyt_huiyuan(
	id char(36) primary key comment'id,用uuid标识',
	hyname varchar(20) comment'会员姓名',
	hyLevel varchar(6) comment'会员级别',
	hycardId varchar(10) comment'会员卡号',
	phoneNumber varchar(13) comment'电话',
	identifyId varchar(15) comment'身份证号',
	bankcardNumber varchar(20) comment'银行卡账号',
	hyFee decimal(10,2) comment'会员费',
	inforFee decimal(10,2) comment'信息费(邮费)',
	totalMoney decimal(10,2) comment'等于会员费+信息费',
	tjrId char(36) comment'推荐人卡号',
	skrName varchar(20) comment'收款人姓名',
	shouhuoAddress varchar(200) comment'收货地址',
	hyState int(1) default 0 comment'会员审核状态，0待审核，1通过，2未通过，默认0',
	applyTime datetime default CURRENT_TIMESTAMP comment'申请日期'
);

create table lyt_fanli(
	id char(36) primary key comment'id,用uuid标识',
	tjrId char(36) comment'推荐人卡号',
	btjrId char(36) comment'被推荐人卡号',
	tjTime datetime comment'推荐时间',
	fanliState int(1) default 0 comment'返利状态，0未返利，1返利，默认0',
	fanliTime datetime comment'返利时间，等于返利状态标识为返利时的时间'
);

alter table lyt_fanli add constraint FK_Relationship_tj foreign key (tjrId)
      references lyt_huiyuan (id) on delete restrict on update restrict;
alter table lyt_fanli add constraint FK_Relationship_btj foreign key (btjrId)
      references lyt_huiyuan (id) on delete restrict on update restrict;

create table admin(
	id char(36) primary key comment'id,用uuid标识',
	adminName varchar(30) comment'管理员用户名',
	adminPassword varchar(30) comment'管理员用户密码'
);

alter table lyt_huiyuan add  beizhu varchar(500) comment'备注' after applyTime;

alter table lyt_fanli add  fanliMoney decimal(10,2) comment'返利钱数' after fanliState;
alter table lyt_fanli add  fanliType int(1) comment'返利类型' after fanliMoney;