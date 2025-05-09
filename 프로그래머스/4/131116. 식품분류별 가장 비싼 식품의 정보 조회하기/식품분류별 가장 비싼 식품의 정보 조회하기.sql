SELECT A.CATEGORY, B.mx AS MAX_PRICE, A.PRODUCT_NAME
FROM FOOD_PRODUCT A JOIN (SELECT CATEGORY, MAX(PRICE) AS mx
                        FROM FOOD_PRODUCT 
                        WHERE CATEGORY IN ( '과자', '국', '김치', '식용유')
                        GROUP BY CATEGORY) B
ON A.CATEGORY = B.CATEGORY AND A.PRICE = B.mx
ORDER BY MAX_PRICE DESC


# SELECT category, MAX(PRICE) AS mx
#                         FROM FOOD_PRODUCT 
#                         WHERE CATEGORY IN ( '과자', '국', '김치', '식용유')
#                         GROUP BY CATEGORY
    
