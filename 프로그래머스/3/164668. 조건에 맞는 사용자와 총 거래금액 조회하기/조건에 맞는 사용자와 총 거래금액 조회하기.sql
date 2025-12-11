select U.USER_ID, U.NICKNAME, sum(B.PRICE) as TOTAL_SALES
from USED_GOODS_BOARD B
inner join USED_GOODS_USER U on B.WRITER_ID = U.USER_ID
where B.STATUS = "DONE"
group by B.WRITER_ID
having sum(B.PRICE) >= 700000
order by TOTAL_SALES asc;