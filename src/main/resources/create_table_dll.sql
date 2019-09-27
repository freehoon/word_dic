create table TB_AIR_WORD
(
    DATA_ID   int auto_increment comment '데이터 ID'
        primary key,
    DATA_KR   varchar(20) null comment '국문',
    DATA_EN   varchar(20) null comment '영문',
    DATA_CN   varchar(20) null comment '중문',
    DATA_DESC text        null comment '설명'
);

create table TB_CATALOG_WORD
(
    DATA_ID      int auto_increment comment '데이터 ID'
        primary key,
    DATA_CLS     varchar(100) null comment '데이터 분류 체계',
    DATA_NM      varchar(50)  null comment '데이터명',
    DATA_DESC    text         null comment '개요',
    RECSROOM_IMG varchar(100) null comment '관련이미지',
    DATA_CONS    varchar(100) null comment '요소',
    DATA_JI      varchar(100) null comment '지점',
    OBS_MISS     varchar(100) null comment '관측시간',
    SAVE_TRM     varchar(50)  null comment '보유기간',
    CREATE_CYCL  varchar(50)  null comment '생산주기',
    DATA_FORM    varchar(50)  null comment '제공형식',
    DATA_PATH    varchar(100) null comment '제공경로',
    USE_METHOD   varchar(100) null comment '이용방법',
    DATA_QLT     varchar(50)  null comment '자료품질'
);

create table TB_GOES_WORD
(
    DATA_ID   int auto_increment comment '데이터ID'
        primary key,
    DATA_NM   varchar(100) null comment '용어',
    DATA_DESC text         null comment '설명'
);

create table TB_LTG_WORD
(
    DATA_ID   int auto_increment comment '데이터ID'
        primary key,
    ABBR      varchar(20) null comment '영어 약어명',
    DATA_KR   varchar(20) null comment '한글명',
    DATA_EN   varchar(20) null comment '영문명',
    DATA_DESC text        null comment '용어정의',
    DATA_CLS  varchar(20) null comment '주제영역'
);

create table TB_LTG_WORD
(
    DATA_ID   int auto_increment comment '데이터ID'
        primary key,
    ABBR      varchar(20) null comment '영어 약어명',
    DATA_KR   varchar(20) null comment '한글명',
    DATA_EN   varchar(20) null comment '영문명',
    DATA_DESC text        null comment '용어정의',
    DATA_CLS  varchar(20) null comment '주제영역'
);

