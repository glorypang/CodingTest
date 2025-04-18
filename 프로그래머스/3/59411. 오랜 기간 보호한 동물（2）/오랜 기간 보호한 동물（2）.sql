-- 코드를 입력하세요
SELECT B.ANIMAL_ID, B.NAME
FROM ANIMAL_INS A RIGHT OUTER JOIN ANIMAL_OUTS B
ON B.ANIMAL_ID = A.ANIMAL_ID
ORDER BY DATEDIFF(B.DATETIME, A.DATETIME) DESC
LIMIT 2