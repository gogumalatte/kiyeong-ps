select count(USER_ID) as USERS
from USER_INFO
where isnull(AGE) = true;