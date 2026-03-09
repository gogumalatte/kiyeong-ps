select distinct D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
from DEVELOPERS D
join SKILLCODES S on D.SKILL_CODE & S.CODE > 0
where S.CATEGORY = 'Front End'
order by D.ID asc;