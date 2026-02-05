with SUB as (select PARENT_ID as ID, count(*) as CHILD_COUNT
from ECOLI_DATA
group by PARENT_ID
having PARENT_ID is not null)
select E.ID, ifnull(S.CHILD_COUNT, 0) as CHILD_COUNT
from ECOLI_DATA E
left join SUB S on E.ID = S.ID
order by E.ID asc;