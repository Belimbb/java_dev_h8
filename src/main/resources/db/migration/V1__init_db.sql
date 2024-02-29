--create tables
create table public.worker (
    id bigint primary key,
    name varchar(1000) null check (length(name) > 2),
    birthday date check (birthday > '1900-01-01'),
    wLevel varchar(7) not null check (wLevel in ('Trainee', 'Junior', 'Middle', 'Senior')),
    salary int check (salary > 100 and salary < 100000)
);

create table client (
    id bigint primary key,
    name varchar(1000) null check (length(name) > 2)
);

create table project (
    id bigint primary key,
    client_id bigint,
    start_date date,
    finish_date date
);

create table project_worker (
    project_id bigint,
    worker_id bigint,
    primary key (project_id, worker_id)
);

-- conect tables
alter table project
    add constraint client_fk
    foreign key(client_id) references client(id);


alter table project_worker
    add constraint project_fk
    foreign key(project_id) references project(id);

alter table project_worker
    add constraint worker_fk
    foreign key(worker_id) references worker(id);

-- create sequences
create sequence client_seq start 1;
create sequence worker_seq start 1;
create sequence project_seq start 1;

-- set sequences
alter table client alter column id set default nextval('client_seq');
alter table worker alter column id set default nextval('worker_seq');
alter table project alter column id set default nextval('project_seq');