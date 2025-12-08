-- 코드를 입력하세요
SELECT ANIMAL_ID,	NAME,	IF(SEX_UPON_INTAKE IN ("Neutered Male", "Neutered Female", "Spayed Female", "Spayed Female"), "O", "X") AS "중성화"
FROM ANIMAL_INS 
ORDER BY 1