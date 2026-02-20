select D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
from DEVELOPERS D
where exists (
    select 1
    from SKILLCODES S
    where S.NAME in ("Python", "C#")
    and (D.SKILL_CODE & S.CODE) = CODE
)
order by D.ID asc;