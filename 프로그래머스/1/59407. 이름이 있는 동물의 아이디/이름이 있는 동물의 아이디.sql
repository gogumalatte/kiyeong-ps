SELECT ANIMAL_ID
from ANIMAL_INS
where isnull(NAME) = false
order by ANIMAL_ID asc;