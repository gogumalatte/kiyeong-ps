with recursive hours as (
    select 0 as h
    
    union all
    
    select h + 1
    from hours
    where h < 23
)
select h.h as HOUR, count(a.ANIMAL_ID) as COUNT
from hours h
left join ANIMAL_OUTS a on h.h = hour(a.DATETIME)
group by h.h
order by h.h;