SELECT A.NAME, A.DATETIME
FROM ANIMAL_INS A 
WHERE ANIMAL_ID NOT IN (
    SELECT ANIMAL_ID
    FROM ANIMAL_OUTS
)
ORDER BY A.DATETIME
LIMIT 3