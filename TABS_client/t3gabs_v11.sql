DROP DATABASE IF EXISTS t_abs;
CREATE DATABASE t_abs CHARACTER SET utf8;
USE t_abs;

#省份表1
DROP TABLE IF EXISTS province;
CREATE TABLE province(
        province_id int PRIMARY KEY AUTO_INCREMENT,              #省份编号
        province_name varchar(20) NOT NULL UNIQUE,               #省份名称
        province_simple_name varchar(10) NOT NULL UNIQUE ,       #省份简称
        province_spell_name  varchar(20)   NOT NULL              #省份拼音
);

insert into province (province_id, province_name, province_simple_name, province_spell_name) values (1,'北京市','京','beijing');
insert into province (province_id, province_name, province_simple_name, province_spell_name) values (2,'上海市','沪','shanghai');
insert into province (province_id, province_name, province_simple_name, province_spell_name) values (3,'河北省','冀','hebei');
insert into province (province_id, province_name, province_simple_name, province_spell_name) values (4,'河南省','豫','henan');



#城市表2
DROP TABLE IF EXISTS city;
CREATE TABLE city(
        city_id int PRIMARY KEY AUTO_INCREMENT, #城市编号
        city_name varchar(20) NOT NULL UNIQUE,	#城市名称
        province_id int NOT NULL,     			#所属省份
        city_spell_name varchar(20) NOT NULL    #城市拼音
);

insert into city (city_id, city_name, province_id, city_spell_name) values (1,'北京市', 1, 'beijing');
insert into city (city_id, city_name, province_id, city_spell_name) values (2,'上海市', 2, 'shanghai');
insert into city (city_id, city_name, province_id, city_spell_name) values (3,'邯郸市', 3, 'handan');
insert into city (city_id, city_name, province_id, city_spell_name) values (4,'秦皇岛市', 3, 'qinhuangdao');
insert into city (city_id, city_name, province_id, city_spell_name) values (5,'洛阳市', 4, 'luoyang');
insert into city (city_id, city_name, province_id, city_spell_name) values (6,'南阳市', 4, 'nanyang');


#营业网点表3
DROP TABLE IF EXISTS branch;
CREATE TABLE branch(
        branch_id int PRIMARY KEY AUTO_INCREMENT,	#网点编号
        branch_name   varchar(20) NOT NULL,			#网点名称
        city_id int NOT NULL,  						#网点所在城市编号
        branch_telephone varchar(20),  				#网点电话
        branch_fax varchar(20),   					#网点传真 
        branch_address varchar(200),   				#网点地址
        branch_state char(1) NOT NULL DEFAULT 'O' 	#网点状态 : 'O':open  'C':close 'S':suspend 
) ENGINE=InnoDB;

insert into branch (branch_name, city_id, branch_telephone, branch_fax, branch_address, branch_state) values ('北京市首都机场营业网点1',1,'111111111','1111111','北京市朝阳区首都机场营业网点1','O');
insert into branch (branch_name, city_id, branch_telephone, branch_fax, branch_address, branch_state) values ('北京市首都机场营业网点2',1,'111111111','1111111','北京市朝阳区首都机场营业网点2','O');
insert into branch (branch_name, city_id, branch_telephone, branch_fax, branch_address, branch_state) values ('北京市首都机场营业网点3',1,'111111111','1111111','北京市朝阳区首都机场营业网点3','O');

insert into branch (branch_name, city_id, branch_telephone, branch_fax, branch_address, branch_state) values ('上海市虹桥机场营业网点1',2,'111111111','1111111','上海市长宁区虹桥路2550号网点1','O');
insert into branch (branch_name, city_id, branch_telephone, branch_fax, branch_address, branch_state) values ('上海市虹桥机场营业网点2',2,'111111111','1111111','上海市长宁区虹桥路2550号网点2','O');
insert into branch (branch_name, city_id, branch_telephone, branch_fax, branch_address, branch_state) values ('上海市虹桥机场营业网点3',2,'111111111','1111111','上海市长宁区虹桥路2550号网点3','O');

insert into branch (branch_name, city_id, branch_telephone, branch_fax, branch_address, branch_state) values ('邯郸市邯郸机场营业网点1',3,'111111111','1111111','邯郸市磁县网点1','O');
insert into branch (branch_name, city_id, branch_telephone, branch_fax, branch_address, branch_state) values ('邯郸市邯郸机场营业网点2',3,'111111111','1111111','邯郸市磁县网点2','O');

insert into branch (branch_name, city_id, branch_telephone, branch_fax, branch_address, branch_state) values ('秦皇岛山海关机场营业网点1',4,'111111111','1111111','秦皇岛山海关机场营业网点1','O');
insert into branch (branch_name, city_id, branch_telephone, branch_fax, branch_address, branch_state) values ('秦皇岛山海关机场营业网点2',4,'111111111','1111111','秦皇岛山海关机场营业网点2','O');

insert into branch (branch_name, city_id, branch_telephone, branch_fax, branch_address, branch_state) values ('洛阳北郊机场营业网点1',5,'111111111','1111111','河南省洛阳市北郊邙山之上网点1','O');
insert into branch (branch_name, city_id, branch_telephone, branch_fax, branch_address, branch_state) values ('洛阳北郊机场营业网点2',5,'111111111','1111111','河南省洛阳市北郊邙山之上网点2','O');
insert into branch (branch_name, city_id, branch_telephone, branch_fax, branch_address, branch_state) values ('洛阳北郊机场营业网点3',5,'111111111','1111111','河南省洛阳市北郊邙山之上网点3','O');

insert into branch (branch_name, city_id, branch_telephone, branch_fax, branch_address, branch_state) values ('南阳姜营机场营业网点1',6,'111111111','1111111','南阳市光武东路网点1','O');
insert into branch (branch_name, city_id, branch_telephone, branch_fax, branch_address, branch_state) values ('南阳姜营机场营业网点2',6,'111111111','1111111','南阳市光武东路网点2','O');
insert into branch (branch_name, city_id, branch_telephone, branch_fax, branch_address, branch_state) values ('南阳姜营机场营业网点3',6,'111111111','1111111','南阳市光武东路网点3','O');


#用户表4
DROP TABLE IF EXISTS user;
CREATE TABLE user(
        user_id int PRIMARY KEY AUTO_INCREMENT,    		#用户编号
        user_login_name  varchar(20) NOT NULL UNIQUE, 	#用户登录名
        user_password char(32) ,  						#用户密码MD5码
        user_name  varchar(20) NOT NULL,  				#用户真实姓名
        user_telephone varchar(20), 					#用户电话
		user_certif_type varchar(20), 					#用户证件类型
		user_certif_num varchar(40), 					#用户证件号码
        user_email varchar(100), 						#用户邮箱
        user_creation_date datetime NOT NULL ,  		#用户创建时间
        user_last_login_time datetime NOT NULL  		#用户最后一次登录时间
) ENGINE=InnoDB;



#乘客表5
DROP TABLE IF EXISTS passenger;
CREATE TABLE passenger(
        psg_id int PRIMARY KEY AUTO_INCREMENT, 	#乘客编号
        psg_name  varchar(20) NOT NULL,  		#乘客姓名
        psg_certif_type varchar(20) NOT NULL,  	#乘客证件类型
        psg_certif_num varchar(40) NOT NULL,  	#乘客证件号码
		psg_email varchar(50) NOT NULL, 		#乘客email
		psg_phone varchar(20) NOT NULL 			#乘客手机号
)ENGINE=InnoDB;


#飞机表6
DROP TABLE IF EXISTS plane;
CREATE TABLE plane(
        plane_id int PRIMARY KEY AUTO_INCREMENT, 	#飞机编号（业务无关唯一编号）
        plane_num varchar(10) NOT NULL UNIQUE,  	#飞机机身编号（中国民航唯一编号）
        plane_model varchar(40) NOT NULL, 			#飞机机型
        plane_manufacturer varchar(40) 			#飞机制造厂商
) ENGINE=InnoDB;

insert into plane (plane_num, plane_model, plane_manufacturer) values ('B-6666','波音747','波音公司');
insert into plane (plane_num, plane_model, plane_manufacturer) values ('B-7777','波音777','波音公司');
insert into plane (plane_num, plane_model, plane_manufacturer) values ('B-8888','麦道82','麦道公司');
insert into plane (plane_num, plane_model, plane_manufacturer) values ('B-9999','麦道11','麦道公司');


#机场表7
DROP TABLE IF EXISTS airport;
CREATE TABLE airport(
        airport_id int PRIMARY KEY AUTO_INCREMENT,  #机场编号
        airport_name  varchar(20) ,  				#机场名称：首都机场
        province_id int NOT NULL, 					#机场所属省份
        city_id int NOT NULL, 						#机场所属城市
        airport_full_name varchar(20) NOT NULL 		#机场全名：北京-首都机场
);

insert into airport (airport_name, province_id, city_id, airport_full_name) values ('首都机场',1,1,'北京-首都机场');
insert into airport (airport_name, province_id, city_id, airport_full_name) values ('虹桥机场',2,2,'上海-虹桥机场');
insert into airport (airport_name, province_id, city_id, airport_full_name) values ('邯郸机场',3,3,'河北-邯郸机场');
insert into airport (airport_name, province_id, city_id, airport_full_name) values ('秦皇岛机场',3,4,'河北-秦皇岛机场');
insert into airport (airport_name, province_id, city_id, airport_full_name) values ('洛阳北郊机场',4,5,'河南-洛阳北郊机场');
insert into airport (airport_name, province_id, city_id, airport_full_name) values ('南阳姜营机场',4,6,'河南-南阳姜营机场');



#航线表8
DROP TABLE IF EXISTS route;
CREATE TABLE route(
        route_id int PRIMARY KEY AUTO_INCREMENT, 	#航线编号
        from_airport_id int NOT NULL, 				#航线出发机场编号
        to_airport_id int NOT NULL, 				#航线到达机场编号
        route_distance int NOT NULL 				#航线距离
) ;

insert into route (from_airport_id, to_airport_id, route_distance) values (1,2,1262);
insert into route (from_airport_id, to_airport_id, route_distance) values (2,1,1262);
insert into route (from_airport_id, to_airport_id, route_distance) values (1,5,677);
insert into route (from_airport_id, to_airport_id, route_distance) values (1,2,677);


#航班计划表9
DROP TABLE IF EXISTS flight_plan;
CREATE TABLE flight_plan(
        fp_id int PRIMARY KEY AUTO_INCREMENT, 		#航班计划编号
        flight_num varchar(10) NOT NULL, 			#航班编号:TL1202
        fp_start_date date NOT NULL, 				#航班计划开始日期
        fp_end_date date NOT NULL, 					#航班计划结束日期
        route_id int NOT NULL, 						#执行航线编号
        fp_departure_time varchar(10) NOT NULL,  	#起飞时刻:'23:10'
        fp_arrival_time varchar(10)  NOT NULL    	#到达时刻:'N01:25' (N代表下一天)
) ENGINE=InnoDB;


insert into flight_plan (flight_num,fp_start_date,fp_end_date,route_id,fp_departure_time,fp_arrival_time) values ('TL1202','2010-01-01','2014-12-31',1,'10:30', '12:50');
insert into flight_plan (flight_num,fp_start_date,fp_end_date,route_id,fp_departure_time,fp_arrival_time) values ('TL1203','2010-01-01','2014-12-31',2,'14:30', '16:50');


#航班表10
DROP TABLE IF EXISTS flight;
CREATE TABLE flight(
        flight_id varchar(20) PRIMARY KEY ,   	#航班编号 'F201008251202' 'F-年-月-日-航班号'
        flight_num varchar(10) NOT NULL,   		#航班号 'TL1202'
        fl_departure_date datetime NOT NULL,   	#航班起飞时刻
        fl_arrival_date datetime NOT NULL,    	#航班到达时刻
        route_id int  NOT NULL,  				#执行航线编号
        plane_id int  NOT NULL, 				#执行飞机编号
        seats_remain int  NOT NULL,    			#剩余座位数
        current_price double NOT NULL,  		#当前价格
        tax1_price double NOT NULL,      		#机场税
        tax2_price double NOT NULL    			#燃油税
) ENGINE=InnoDB;


insert into flight (flight_id, flight_num, fl_departure_date,fl_arrival_date,route_id,plane_id,seats_remain, current_price, tax1_price, tax2_price) values ('F201311111202','TL1202','2013-11-10 10:30:00.0', '2013-11-10 12:50:00.0', 1, 1, 20, 970.0, 30.0, 120.0);
insert into flight (flight_id, flight_num, fl_departure_date,fl_arrival_date,route_id,plane_id,seats_remain, current_price, tax1_price, tax2_price) values ('F201311121202','TL1202','2013-11-10 10:30:00.0', '2013-11-10 12:50:00.0', 1, 1, 20, 970.0, 30.0, 120.0);
insert into flight (flight_id, flight_num, fl_departure_date,fl_arrival_date,route_id,plane_id,seats_remain, current_price, tax1_price, tax2_price) values ('F201311131202','TL1202','2013-11-10 10:30:00.0', '2013-11-10 12:50:00.0', 1, 1, 20, 970.0, 30.0, 120.0);
insert into flight (flight_id, flight_num, fl_departure_date,fl_arrival_date,route_id,plane_id,seats_remain, current_price, tax1_price, tax2_price) values ('F201311141202','TL1202','2013-11-10 10:30:00.0', '2013-11-10 12:50:00.0', 1, 1, 20, 970.0, 30.0, 120.0);
insert into flight (flight_id, flight_num, fl_departure_date,fl_arrival_date,route_id,plane_id,seats_remain, current_price, tax1_price, tax2_price) values ('F201311151202','TL1202','2013-11-10 10:30:00.0', '2013-11-10 12:50:00.0', 1, 1, 20, 970.0, 30.0, 120.0);
insert into flight (flight_id, flight_num, fl_departure_date,fl_arrival_date,route_id,plane_id,seats_remain, current_price, tax1_price, tax2_price) values ('F201311111203','TL1203','2013-11-10 14:30:00.0', '2013-11-10 16:50:00.0', 2, 1, 20, 970.0, 30.0, 120.0);
insert into flight (flight_id, flight_num, fl_departure_date,fl_arrival_date,route_id,plane_id,seats_remain, current_price, tax1_price, tax2_price) values ('F201311121203','TL1203','2013-11-10 14:30:00.0', '2013-11-10 16:50:00.0', 2, 2, 20, 970.0, 30.0, 120.0);
insert into flight (flight_id, flight_num, fl_departure_date,fl_arrival_date,route_id,plane_id,seats_remain, current_price, tax1_price, tax2_price) values ('F201311131203','TL1203','2013-11-10 14:30:00.0', '2013-11-10 16:50:00.0', 2, 2, 20, 970.0, 30.0, 120.0);
insert into flight (flight_id, flight_num, fl_departure_date,fl_arrival_date,route_id,plane_id,seats_remain, current_price, tax1_price, tax2_price) values ('F201311141203','TL1203','2013-11-10 14:30:00.0', '2013-11-10 16:50:00.0', 2, 2, 20, 970.0, 30.0, 120.0);
insert into flight (flight_id, flight_num, fl_departure_date,fl_arrival_date,route_id,plane_id,seats_remain, current_price, tax1_price, tax2_price) values ('F201311151203','TL1203','2013-11-10 14:30:00.0', '2013-11-10 16:50:00.0', 2, 2, 20, 970.0, 30.0, 120.0);

#机票订单 11
DROP TABLE IF EXISTS ticket_order;
CREATE TABLE ticket_order(
        order_id BIGINT PRIMARY KEY , 	#订单编号 毫秒数
        user_id int NOT NULL, 			#用户编号
        order_money double NOT NULL , 	#订单金额
        order_date datetime NOT NULL,	#预订日期
        order_state char(1), 			#订单状态 ‘等待支付（E）’，‘取消（C）’，‘失效（D）’，‘已支付（P）’
 		flight_id varchar(20) NOT NULL  #航班编号
) ENGINE=InnoDB;


#机票表 12
DROP TABLE IF EXISTS ticket;
CREATE TABLE ticket(
        ticket_id BIGINT PRIMARY KEY,   		#机票编号 毫秒数
        order_id BIGINT ,
        flight_num varchar(10) NOT NULL,    	#航班号
        route_id int NOT NULL,    				#航线编号
        
        departure_datetime datetime NOT NULL,   #起飞时间
        arrival_datatime  datetime NOT NULL,    #到达时间
        psg_id int,								#乘客id
        ticket_date datetime NOT NULL,        	#出票日期时间
        ticket_price double NOT NULL,          	#机票价格
        tax1_price  double NOT NULL,          	#机场税
        tax2_price  double NOT NULL,           	#燃油税
        total_price   double NOT NULL           #机票总价格
) ENGINE=InnoDB;
     

#资讯表 13
DROP TABLE IF EXISTS information;
CREATE TABLE information(
		info_id	int	PRIMARY KEY  AUTO_INCREMENT,#咨询id
		info_title	varchar(100) NOT NULL ,     #咨询名称
		info_content	text , 					#咨询内容
		info_time	datetime 					#发布咨询时间
) ENGINE=InnoDB;
