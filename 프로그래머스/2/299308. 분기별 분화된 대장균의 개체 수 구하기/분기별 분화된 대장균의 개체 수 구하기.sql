select concat(Quarter(DIFFERENTIATION_DATE), 'Q') as QUARTER, count(*) as ECOLI_COUNT
from ECOLI_DATA
group by concat(Quarter(DIFFERENTIATION_DATE), 'Q')
order by QUARTER;