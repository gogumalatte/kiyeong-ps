select D.DEPT_ID, D.DEPT_NAME_EN, round(avg(SAL), 0) as AVG_SAL
from HR_DEPARTMENT D
inner join HR_EMPLOYEES E on D.DEPT_ID = E.DEPT_ID
group by D.DEPT_ID
order by AVG_SAL desc;