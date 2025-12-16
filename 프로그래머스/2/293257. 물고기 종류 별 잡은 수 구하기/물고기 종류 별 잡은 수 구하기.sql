select count(*) as FISH_COUNT, N.FISH_NAME
from FISH_INFO F
inner join FISH_NAME_INFO N on F.FISH_TYPE = N.FISH_TYPE
group by N.FISH_NAME
order by FISH_COUNT desc