drop table if exists developers;
drop type if exists sex;
create type sex as enum('MALE', 'FEMALE');
create table developers(
    id_developer int,
    name varchar(255),
    age int,
    sex sex,
    salary int,
    it_company_id int
);

drop table if exists skills;
create table skills (
    id_skills int,
    programing_language varchar(255),
    level varchar(255)
);

drop table if exists projects;
create table projects(
    id_project int,
    name varchar(255),
    start_date date,
    end_date date
);

drop table if exists companies;
create table companies(
    id_it_company int,
    name varchar(255),
    worth int
);

drop table if exists customers;
create table customers(
    id_customer int,
    name varchar(255),
    country varchar(255)
);

drop table if exists developers_projects;
create table developers_projects(
    developer_ID int,
    project_ID int
);

drop table if exists developers_skills;
create table developers_skills(
    developer_ID int,
    skill_ID int
);

drop table if exists companies_projects;
create table companies_projects(
    company_ID int,
    project_ID int
);

drop table if exists customers_projects;
create table customers_projects(
    customer_ID int,
    project_ID int
);

insert into developers(id_developer, name, age, sex, salary, it_company_id) values (1, 'Vasa', 22, 'MALE', 2300, 1);
insert into developers(id_developer, name, age, sex, salary, it_company_id) values (2, 'Olha', 24, 'FEMALE', 2500, 1);
insert into developers(id_developer, name, age, sex, salary, it_company_id) values (3, 'Ilona', 20, 'FEMALE', 2000, 2);
insert into developers(id_developer, name, age, sex, salary, it_company_id) values (4, 'Kola', 21, 'MALE', 1700, 2);
insert into developers(id_developer, name, age, sex, salary, it_company_id) values (5, 'Roma', 28, 'MALE', 2950, 3);


insert into skills(id_skills, programing_language, level)  values (1, 'Java', 'Junior');
insert into skills(id_skills, programing_language, level)  values (2, 'Java', 'Middle');
insert into skills(id_skills, programing_language, level)  values (3, 'Java', 'Senior');
insert into skills(id_skills, programing_language, level)  values (4, 'C#', 'Junior');
insert into skills(id_skills, programing_language, level)  values (5, 'C#', 'Middle');
insert into skills(id_skills, programing_language, level)  values (6, 'C#', 'Senior');
insert into skills(id_skills, programing_language, level)  values (7, 'C++', 'Junior');
insert into skills(id_skills, programing_language, level)  values (8, 'C++', 'Middle');
insert into skills(id_skills, programing_language, level)  values (9, 'C++', 'Senior');
insert into skills(id_skills, programing_language, level)  values (10, 'JavaScript', 'Junior');
insert into skills(id_skills, programing_language, level)  values (11, 'JavaScript', 'Middle');
insert into skills(id_skills, programing_language, level)  values (12, 'JavaScript', 'Senior');


insert into projects(id_project, name, start_date, end_date) values (1, 'Viber', '01-01-2017', '01-01-2021');
insert into projects(id_project, name, start_date, end_date) values (2, 'Telegram', '01-01-2018', '01-01-2022');
insert into projects(id_project, name, start_date, end_date) values (3, 'IpLex.Zakony', '01-07-2017', '10-10-2021');
insert into projects(id_project, name, start_date, end_date) values (4, 'Skype', '21-11-2018', '11-05-2020');


insert into companies(id_it_company, name, worth) values (1, 'Epam', 230000000);
insert into companies(id_it_company, name, worth) values (2, 'SoftServe', 430000000);
insert into companies(id_it_company, name, worth) values (3, 'GlobalLogic', 230000000);

insert into customers(id_customer, name, country) values (1, 'Sasha', 'USA');
insert into customers(id_customer, name, country) values (2, 'Bob', 'UK');
insert into customers(id_customer, name, country) values (3, 'Bill', 'Germany');

insert into developers_projects(developer_id, project_id) values (1, 1);
insert into developers_projects(developer_id, project_id) values (1, 2);
insert into developers_projects(developer_id, project_id) values (2, 1);
insert into developers_projects(developer_id, project_id) values (2, 2);
insert into developers_projects(developer_id, project_id) values (3, 3);
insert into developers_projects(developer_id, project_id) values (3, 4);
insert into developers_projects(developer_id, project_id) values (4, 4);

insert into developers_skills(developer_id, skill_id) values (1, 2);
insert into developers_skills(developer_id, skill_id) values (1, 5);
insert into developers_skills(developer_id, skill_id) values (2, 1);
insert into developers_skills(developer_id, skill_id) values (2, 8);
insert into developers_skills(developer_id, skill_id) values (3, 1);
insert into developers_skills(developer_id, skill_id) values (3, 10);
insert into developers_skills(developer_id, skill_id) values (4, 12);
insert into developers_skills(developer_id, skill_id) values (5, 10);
insert into developers_skills(developer_id, skill_id) values (5, 9);

insert into companies_projects(company_id, project_id) values (1, 1);
insert into companies_projects(company_id, project_id) values (1, 3);
insert into companies_projects(company_id, project_id) values (2, 1);
insert into companies_projects(company_id, project_id) values (2, 2);
insert into companies_projects(company_id, project_id) values (3, 2);
insert into companies_projects(company_id, project_id) values (3, 3);
insert into companies_projects(company_id, project_id) values (3, 4);

insert into customers_projects(customer_id, project_id) values (1, 1);
insert into customers_projects(customer_id, project_id) values (1, 2);
insert into customers_projects(customer_id, project_id) values (2, 1);
insert into customers_projects(customer_id, project_id) values (2, 2);
insert into customers_projects(customer_id, project_id) values (3, 3);
insert into customers_projects(customer_id, project_id) values (3, 4);