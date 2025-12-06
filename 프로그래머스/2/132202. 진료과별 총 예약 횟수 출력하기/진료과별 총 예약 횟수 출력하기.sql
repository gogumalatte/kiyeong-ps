select MCDP_CD as 진료과코드, count(*) as 5월예약건수
from APPOINTMENT
where APNT_YMD >= '2022-5-1' and APNT_YMD < '2022-6-1'
group by MCDP_CD
order by 5월예약건수 asc, 진료과코드 asc;