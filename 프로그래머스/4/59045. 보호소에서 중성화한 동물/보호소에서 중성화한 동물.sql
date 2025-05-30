SELECT A.ANIMAL_ID, A.ANIMAL_TYPE, A.NAME
FROM ANIMAL_OUTS A
WHERE ANIMAL_ID IN (SELECT ANIMAL_ID
                FROM ANIMAL_INS
                WHERE SEX_UPON_INTAKE LIKE "Intact%")
 AND SEX_UPON_OUTCOME IN ('Neutered Male' , 'Spayed Female')