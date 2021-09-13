create table customer (
                          id bigint not null auto_increment,
                          date_of_birth date,
                          email varchar(255),
                          gender varchar(255),
                          name varchar(255),
                          password varchar(255),
                          phone_number varchar(255),
                          surname varchar(255),
                          user_name varchar(255),
                          person_id bigint,
                          primary key (id)
) engine=InnoDB;

create table employee (
                          id bigint not null auto_increment,
                          about varchar(255),
                          company_name varchar(255),
                          date_of_birth date,
                          email varchar(255),
                          gender varchar(255),
                          name varchar(255),
                          password varchar(255),
                          phone_number varchar(255),
                          price integer,
                          specialist varchar(255),
                          surname varchar(255),
                          user_name varchar(255),
                          person_id bigint,
                          primary key (id)
) engine=InnoDB;

create table event (
                       id bigint not null auto_increment,
                       date date,
                       description varchar(255),
                       price integer,
                       serial_number binary(255),
                       type varchar(255),
                       customer_id bigint,
                       primary key (id)
) engine=InnoDB;

create table event_employees (
                                 event_id bigint not null,
                                 employees_id bigint not null
) engine=InnoDB;

create table person (
                        id bigint not null auto_increment,
                        password varchar(255),
                        role varchar(255),
                        user_name varchar(255),
                        primary key (id)
) engine=InnoDB;

create table portfolio (
                           id bigint not null auto_increment,
                           name varchar(255),
                           url varchar(255),
                           employee_id bigint,
                           primary key (id)
) engine=InnoDB;

alter table customer
    add constraint UKie7rkxg6fmtxx1aes55ox9yxd unique (person_id);

alter table customer
    add constraint UK_qfrm64q1g4do60ini1wv5crno unique (user_name);

alter table employee
    add constraint UK6rpeoojvw6pbporri8w66n164 unique (person_id);

alter table employee
    add constraint UK_o885fqgb71dmn4hp0p6rs4ms4 unique (user_name);

alter table person
    add constraint UK_e76i3q6dk7y68q7vpkobc71tx unique (user_name);

alter table customer
    add constraint FKnvxfigj5o3te7ig37cq7qo0bc
        foreign key (person_id)
            references person (id);

alter table employee
    add constraint FKfm68kmqett1iydj8xgfb6two8
        foreign key (person_id)
            references person (id);

alter table event
    add constraint FKjnpnunfdwdeowuemq97etk5yg
        foreign key (customer_id)
            references customer (id);

alter table event_employees
    add constraint FKoxb81s02hvuf5e9f2yl0cvu1j
        foreign key (employees_id)
            references employee (id);

alter table event_employees
    add constraint FKpo90q6v9rra6j549vpbhav675
        foreign key (event_id)
            references event (id);

alter table portfolio
    add constraint FK16x10r2t9mdgjiuv5bjyxv7yd
        foreign key (employee_id)
            references employee (id);
