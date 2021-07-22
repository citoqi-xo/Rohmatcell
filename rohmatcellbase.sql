/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     12/30/2013 9:26:52 PM                        */
/*==============================================================*/


drop table if exists JABATAN;

drop table if exists MEMBER;

drop table if exists PEMBELIAN_SALDO;

drop table if exists PENJUALAN;

drop table if exists PENJUALAN_MEMBER;

drop table if exists PETUGAS;

drop table if exists PULSA;

drop table if exists RELATIONSHIP_6;

drop table if exists RELATIONSHIP_8;

drop table if exists SALDO;

/*==============================================================*/
/* Table: JABATAN                                               */
/*==============================================================*/
create table JABATAN
(
   ID_JABATAN           char(4) not null,
   NAMA_JABATAN         varchar(45),
   primary key (ID_JABATAN)
);

/*==============================================================*/
/* Table: MEMBER                                                */
/*==============================================================*/
create table MEMBER
(
   NO_HP_MEMBER         varchar(12) not null,
   NAMA_MEMBER          varchar(45),
   NAMA_KONTER          varchar(45),
   PIN_MEM              varchar(6),
   primary key (NO_HP_MEMBER)
);

/*==============================================================*/
/* Table: PEMBELIAN_SALDO                                       */
/*==============================================================*/
create table PEMBELIAN_SALDO
(
   ID_PEMBELIAN         char(4) not null,
   NO_HP_MEMBER         varchar(12),
   NOMINAL_PEMBELIAN    varchar(6),
   TANGGAL_PEMBELIAN    date,
   primary key (ID_PEMBELIAN)
);

/*==============================================================*/
/* Table: PENJUALAN                                             */
/*==============================================================*/
create table PENJUALAN
(
   ID_PENJUALAN         int not null,
   ID_PETUGAS           varchar(12),
   ID_PULSA             varchar(7) not null,
   NOMINAL_JUAL         varchar(6),
   NO_HP                varchar(12),
   TANGGAL              date,
   WAKTU_PENJUALAN      time,
   primary key (ID_PENJUALAN)
);

/*==============================================================*/
/* Table: PENJUALAN_MEMBER                                      */
/*==============================================================*/
create table PENJUALAN_MEMBER
(
   ID_JUAL_MEMBER       int not null,
   NOMINAL_JUAL_MEMBER  varchar(6),
   NOMOR_HP             varchar(12),
   TANGGAL_JUAL         date,
   WAKTU_JUAL           time,
   HARGA_DEFAULT_MEMBER varchar(6),
   primary key (ID_JUAL_MEMBER)
);

/*==============================================================*/
/* Table: PETUGAS                                               */
/*==============================================================*/
create table PETUGAS
(
   ID_PETUGAS           varchar(12) not null,
   ID_JABATAN           char(4),
   NAMA_PETUGAS         varchar(45),
   PIN                  varchar(6),
   primary key (ID_PETUGAS)
);

/*==============================================================*/
/* Table: PULSA                                                 */
/*==============================================================*/
create table PULSA
(
   OPERATOR             varchar(12),
   ID_PULSA             varchar(7) not null,
   ID_SALDO             varchar(12),
   HARGA_DEFAULT        varchar(6),
   HARGA_JUAL           varchar(6),
   HARGA_MEMBER         varchar(6),
   primary key (ID_PULSA)
);

/*==============================================================*/
/* Table: RELATIONSHIP_6                                        */
/*==============================================================*/
create table RELATIONSHIP_6
(
   NO_HP_MEMBER         varchar(12) not null,
   ID_JUAL_MEMBER       int not null,
   primary key (NO_HP_MEMBER, ID_JUAL_MEMBER)
);

/*==============================================================*/
/* Table: RELATIONSHIP_8                                        */
/*==============================================================*/
create table RELATIONSHIP_8
(
   ID_JUAL_MEMBER       int not null,
   ID_PULSA             varchar(7) not null,
   primary key (ID_JUAL_MEMBER, ID_PULSA)
);

/*==============================================================*/
/* Table: SALDO                                                 */
/*==============================================================*/
create table SALDO
(
   ID_SALDO             varchar(12) not null,
   JUMLAHSALDO          varchar(7),
   primary key (ID_SALDO)
);

alter table PEMBELIAN_SALDO add constraint FK_RELATIONSHIP_7 foreign key (NO_HP_MEMBER)
      references MEMBER (NO_HP_MEMBER) on delete restrict on update restrict;

alter table PENJUALAN add constraint FK_MEMILIKI foreign key (ID_PULSA)
      references PULSA (ID_PULSA) on delete restrict on update restrict;

alter table PENJUALAN add constraint FK_RELATIONSHIP_11 foreign key (ID_PETUGAS)
      references PETUGAS (ID_PETUGAS) on delete restrict on update restrict;

alter table PETUGAS add constraint FK_RELATIONSHIP_5 foreign key (ID_JABATAN)
      references JABATAN (ID_JABATAN) on delete restrict on update restrict;

alter table PULSA add constraint FK_RELATIONSHIP_12 foreign key (ID_SALDO)
      references SALDO (ID_SALDO) on delete restrict on update restrict;

alter table RELATIONSHIP_6 add constraint FK_RELATIONSHIP_6 foreign key (NO_HP_MEMBER)
      references MEMBER (NO_HP_MEMBER) on delete restrict on update restrict;

alter table RELATIONSHIP_6 add constraint FK_RELATIONSHIP_8 foreign key (ID_JUAL_MEMBER)
      references PENJUALAN_MEMBER (ID_JUAL_MEMBER) on delete restrict on update restrict;

alter table RELATIONSHIP_8 add constraint FK_RELATIONSHIP_10 foreign key (ID_PULSA)
      references PULSA (ID_PULSA) on delete restrict on update restrict;

alter table RELATIONSHIP_8 add constraint FK_RELATIONSHIP_9 foreign key (ID_JUAL_MEMBER)
      references PENJUALAN_MEMBER (ID_JUAL_MEMBER) on delete restrict on update restrict;

