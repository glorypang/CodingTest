-- 코드를 입력하세요
WITH LIST AS(SELECT *, RANK() OVER(PARTITION BY CATEGORY ORDER BY PRICE DESC) AS ranked
FROM FOOD_PRODUCT
where category in ('과자', '국', '김치', '식용유'))

select CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
from list
where ranked = 1
ORDER BY 2 desc