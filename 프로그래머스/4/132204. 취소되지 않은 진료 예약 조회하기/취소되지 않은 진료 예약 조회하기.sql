with TEMP as (
    select A.APNT_NO, A.PT_NO, A.MCDP_CD, D.DR_NAME, A.APNT_YMD
    from APPOINTMENT A
    left join DOCTOR D on A.MDDR_ID = D.DR_ID
    where A.MCDP_CD = 'CS' and date_format(A.APNT_YMD, '%Y-%m-%d') = '2022-04-13' and APNT_CNCL_YN = 'N')
select T.APNT_NO, P.PT_NAME, T.PT_NO, T.MCDP_CD, T.DR_NAME, T.APNT_YMD 
from TEMP T
left join PATIENT P on T.PT_NO = P.PT_NO
order by T.APNT_YMD asc;