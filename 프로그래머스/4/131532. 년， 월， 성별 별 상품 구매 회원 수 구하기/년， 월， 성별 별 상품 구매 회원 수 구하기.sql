select year(O.SALES_DATE) as YEAR, month(O.SALES_DATE) as MONTH, I.GENDER, count(distinct O.USER_ID) as USERS
from ONLINE_SALE O
left join USER_INFO I on O.USER_ID = I.USER_ID
group by year(O.SALES_DATE), month(O.SALES_DATE), I.GENDER
having I.GENDER is not null
order by YEAR, MONTH, GENDER;