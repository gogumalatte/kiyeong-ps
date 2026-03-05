select ID
from ECOLI_DATA
where PARENT_ID in
                (select id
                from ECOLI_DATA
                where PARENT_ID in 
                                (select id
                                from ECOLI_DATA
                                where PARENT_ID is null))
order by ID;