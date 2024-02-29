--add workers
insert into public.worker (name, birthday, wLevel, salary) values ('Aleks', '1990-01-12', 'Trainee', 500), ('Oleg', '1945-03-1', 'Junior', 800);
insert into worker (name, birthday, wLevel, salary) values ('Pasha', '2004-11-23', 'Middle', 20000), ('Masha', '2000-08-14', 'Trainee', 1200);
insert into worker (name, birthday, wLevel, salary) values ('Bogdan', '1987-03-22', 'Senior', 50000), ('Vadim', '1998-07-11', 'Junior', 950);
insert into worker (name, birthday, wLevel, salary) values ('Lida', '2001-12-03', 'Middle', 30000), ('Artyom', '1974-09-18', 'Senior', 65000);
insert into worker (name, birthday, wLevel, salary) values ('Oksana', '1989-06-21', 'Middle', 30000), ('Lena', '1967-05-04', 'Trainee', 750);

--add clients
insert into client (name) values ('Nazar'), ('Maksim'), ('Zhenya'), ('Vitalina'), ('Dasha'), ('Natasha'), ('Aleksey'), ('Igor'), ('Kiril'), ('Pavlik');

--add projects
insert into project (client_id, start_date, finish_date) values (1, '2000-02-11', '2001-03-25'), (1, '2008-04-06', '2008-09-14');
insert into project (client_id, start_date, finish_date) values (3, '1999-12-31', '2002-05-23'), (4, '2001-05-28', '2010-10-10');
insert into project (client_id, start_date, finish_date) values (5, '1985-12-23', '1988-01-24'), (1, '2000-09-05', '2005-02-23');
insert into project (client_id, start_date, finish_date) values (7, '1934-02-12', '1940-07-11'), (4, '1963-08-19', '1965-06-21');
insert into project (client_id, start_date, finish_date) values (5, '2010-12-30', '2014-11-22'), (5, '2020-10-03', '2020-12-13');

--add project workers
insert into project_worker values (1, 4), (1, 3), (2, 1), (2, 9), (2, 6), (3, 1), (3, 4), (4, 5), (5, 7);
insert into project_worker values (5, 8), (6, 10), (7, 2), (7, 8), (7, 9), (8, 1), (9, 10), (9, 4), (10, 3);