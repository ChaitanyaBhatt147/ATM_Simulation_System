show databases;

use bankmanagementsystem;

create table login (formno varchar(20),CardNumber varchar(20),pinnumber varchar(20));

create table signup (formno varchar(20),name varchar(30),father_name varchar(30),dob varchar(20),gender varchar(20),email varchar(40),marital varchar(20),address varchar(50),city varchar(30),state varchar(30),pincode varchar(30));

create table signuptwo (formno varchar(20),religion varchar(30),category varchar(30),income varchar(20),eductional_qulification varchar(20),occupation varchar(40),panCard_no varchar(20),aadherCard_no varchar(50),senior_citizen varchar(30),exixting_account varchar(30));

create table signupthree (formno varchar(20),Account_Type varchar(30),card_Number varchar(30),PIN_Number varchar(20),atmCard varchar(20),internetBanking varchar(40),mobileBanking varchar(20),alert varchar(50),ChequeBook varchar(30),e_Stement varchar(30));

create table bank (pin varchar(10),date varchar(50),type varchar(20),amount varchar(20));

show tables;

select * from login;

select * from signup;

select * from signuptwo;

select * from signupthree;

select * from bank;

truncate login;

truncate signup;

truncate signuptwo;

truncate signupthree;

truncate bank;

drop table login;

drop table signup;

drop table signuptwo;

drop table signupthree;

drop table bank;