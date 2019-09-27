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

create table TB_NIKL_WORD
(
    DATA_ID       int auto_increment comment '데이터ID'
        primary key,
    DATA_NM       varchar(50)  null comment '데이터 명',
    DATA_UNIT     varchar(20)  null comment '구성단위',
    ORGN_YN       varchar(20)  null comment '고유어 여부',
    ROMALPA       varchar(50)  null comment '로마자',
    ROMALPA_WORD  varchar(50)  null comment '로마자 글자',
    ROMALPA_SOUND varchar(50)  null comment '로마자 소리',
    ORGN_WORD     varchar(100) null comment '원어',
    ORGN_WORD2    varchar(100) null comment '어원',
    DATA_SOUND    varchar(100) null comment '발음',
    DATA_USE      varchar(100) null comment '활용',
    SRCH_TYPE     varchar(20)  null comment '검색용 이형태',
    DATA_PATSPH   varchar(100) null comment '품사',
    MEAN_NO       varchar(20)  null comment '의미 번호',
    DATA_MEAN     text         null comment '뜻 풀이',
    DATA_REGION   varchar(200) null comment '방언지역',
    DATA_FRM      varchar(200) null comment '문형',
    DATA_RULE     text         null comment '문법',
    DATA_EX       text         null comment '용례',
    DATA_SPCLT    varchar(100) null comment '전문분야',
    RELD_WORD     text         null comment '관련어휘',
    PROVB         text         null comment '속담',
    IDIOM         varchar(100) null comment '관용구',
    TARGET_WORD   varchar(100) null comment '대역어',
    CLS_INFO      text         null comment '생물 분류군 정보',
    HIST_INFO     text         null comment '역사정보',
    HNDY_INFO     text         null comment '수어정보',
    EXCPT_INFO    text         null comment '규범정보',
    MULTI_INFO    text         null comment '다중 매체 정보'
);

