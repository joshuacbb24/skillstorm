/* crud operations
	c - create (insert)
    r - read (select)
    u - update (update)
    d - delete (delete)
*/
select * from author;

-- insert data
insert into author (first_name, last_name) values ('Josh','Cobb');
insert into author (first_name, last_name) values ('Jane','Austin');

-- updating data
update author set first_name = 'Joshua' where author_id = 1;

-- deleting data
delete from author where author_id < 2;