-- select * from departments where department_id = 100
update departments set 
 department_name = 'Keuangan', 
 manager_id = null, 
 location_id = 1000 
where department_id = 100;