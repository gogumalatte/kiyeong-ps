select count(*) as FISH_COUNT
from FISH_INFO I
left join FISH_NAME_INFO N on I.FISH_TYPE = N.FISH_TYPE
where N.FISH_NAME = 'BASS' or N.FISH_NAME = 'SNAPPER'