with SUB1 as (select MEMBER_ID, count(*) as CNT
from REST_REVIEW
group by MEMBER_ID
order by count(*) desc)
select M.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, "%Y-%m-%d") as REVIEW_DATE
from SUB1 S
join REST_REVIEW R on R.MEMBER_ID = S.MEMBER_ID
join MEMBER_PROFILE M on M.MEMBER_ID = S.MEMBER_ID
where CNT in (select max(CNT) as maxReviewCnt
from SUB1)
order by REVIEW_DATE asc, REVIEW_TEXT asc;