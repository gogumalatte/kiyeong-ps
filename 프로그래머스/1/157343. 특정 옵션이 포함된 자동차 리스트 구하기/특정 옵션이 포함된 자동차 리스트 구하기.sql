select *
from CAR_RENTAL_COMPANY_CAR
where options regexp '네비게이션'
order by car_id desc;