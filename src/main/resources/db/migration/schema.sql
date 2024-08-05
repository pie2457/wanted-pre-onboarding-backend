create table company
(
    id      int auto_increment not null comment '회사 시퀀스' primary key,
    name    varchar(128)       not null comment '회사 이름',
    country varchar(64)        not null comment '국가',
    region  varchar(64)        not null comment '지역'
) comment '회사';

create table recruitment_notice
(
    id           int auto_increment comment '채용공고 시퀀스' primary key,
    company_id   int          not null comment '회사 id',
    position     varchar(256) not null comment '채용 포지션',
    content      longtext     not null comment '채용 내용',
    compensation int          not null comment '채용 보상금 (원)'
) comment '채용 공고';

create table recruitment_notice_tech_stack_mapping
(
    recruitment_notice_id int not null comment '채용 공고 시퀀스',
    tech_stack_id         int not null comment '기술 스택 시퀀스',
    primary key (recruitment_notice_id, tech_stack_id)
) comment '채용 공고, 기술 스택 매핑 테이블';

create table tech_stack
(
    id   int auto_increment comment '기술 스택 시퀀스' primary key,
    name varchar(100) not null comment '기술 이름'
) comment '기술 스택';

create table user_account
(
    id    int auto_increment comment '사용자 시퀀스' primary key,
    name  varchar(10)  not null comment '사용자 이름',
    phone varchar(16)  not null comment '사용자 전화번호',
    email varchar(100) not null comment '사용자 이메일'
) comment '사용자';

create table company_application_history
(
    account_id            int not null comment '사용자 시퀀스',
    recruitment_notice_id int not null comment '채용 공고 시퀀스',
    primary key (account_id, recruitment_notice_id)
) comment '사용자 공고 지원 내역';
