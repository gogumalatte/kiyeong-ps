with CALC_TABLE as (
    select
        case
            when (SKILL_CODE & (select sum(CODE) from SKILLCODES where CATEGORY = 'Front End')) > 0 and
            (SKILL_CODE & (select CODE from SKILLCODES where NAME = 'Python')) > 0
                then 'A'
            when (SKILL_CODE & (select CODE from SKILLCODES where NAME = 'C#')) > 0
                then 'B'
            when (SKILL_CODE & (select sum(CODE) from SKILLCODES where CATEGORY = 'Front End')) > 0
                then 'C'
        end as GRADE,
        ID, 
        EMAIL
    from DEVELOPERS
)
select GRADE, ID, EMAIL
from CALC_TABLE
where GRADE is not null
order by GRADE asc, ID asc;