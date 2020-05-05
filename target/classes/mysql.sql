CREATE DATABASE rpalog;
USE rpalog;
-- 创建运行记录表
CREATE TABLE rpalog(
`rpalog_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '运行记录ID',
`company` VARCHAR(120) NOT NULL COMMENT '公司名称',
`name` VARCHAR(255) NOT NULL COMMENT 'RPA名称',
`start_time` TIMESTAMP NOT NULL COMMENT '运行开始时间',
`end_time` TIMESTAMP NOT NULL COMMENT '运行结束时间',
`run_time` TIME not NULL COMMENT '运行时长',
`result` VARCHAR(20) NOT NULL COMMENT '运行结果',
PRIMARY KEY(rpalog_id),
KEY idx_starttime(start_time),
KEY idx_endtime(end_time)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='RPA运行记录表';

-- 创建RPA明细表
CREATE TABLE rpa(
`rpa_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '明细ID',
`company` VARCHAR(120) NOT NULL COMMENT '公司名称',
`name` VARCHAR(255) NOT NULL COMMENT 'RPA名称',
PRIMARY KEY(rpa_id)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='RPA明细表';

-- 创建RPA运行计划表
CREATE TABLE rparunplan(
`rparunplan_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '运行计划ID',
`runplan_week` VARCHAR(120) NOT NULL COMMENT '运行计划周期',
`runplan_time` VARCHAR(120) NOT NULL COMMENT '运行计划时间',
PRIMARY KEY(rparunplan_id)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='RPA运行计划表';

-- 插入数据
INSERT INTO rpa(company,name) VALUES
('DICS','DICS_jianhang_rujin'),
('DICN','DICS_jianhang_rujin'),
('DICW','DICS_zhonghang_rujin');

INSERT INTO rparunplan(runplan_week,runplan_time,rpa_id) VALUES
('星期一,星期二,星期三,星期四,星期五,星期六,星期日,','12:00:00,13:00:00,15:00:00,17:00:00,19:00:00,');

INSERT INTO rpalog(company,name,start_time,end_time,run_time,result) VALUES
('DICS','DICS_jianhang_rujin','2020-05-02 21:30:00','2020-05-02 21:32:00','00:02:00','OK'),
('DICS','DICS_zhonghang_rujin','2020-05-02 21:40:00','2020-05-02 21:42:00','00:02:00','OK'),
('DICN','DICN_jianhang_rujin','2020-05-02 21:30:00','2020-05-02 21:32:00','00:02:00','OK'),
('DICW','DICS_jianhang_rujin','2020-05-02 21:30:00','2020-05-02 21:32:00','00:02:00','OK'),
('DICS','DICS_jianhang_rujin','2020-05-01 21:30:00','2020-05-01 21:32:00','00:02:00','error')