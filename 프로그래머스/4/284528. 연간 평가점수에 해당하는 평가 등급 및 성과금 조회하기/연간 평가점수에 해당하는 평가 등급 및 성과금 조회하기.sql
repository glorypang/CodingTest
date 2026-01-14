-- 코드를 작성해주세요
    SELECT A.EMP_NO, A.EMP_NAME,   
    (CASE
            WHEN AVG(C.SCORE) >= 96 THEN "S"
            WHEN AVG(C.SCORE) >= 90 THEN "A"
            WHEN AVG(C.SCORE) >= 80 THEN 'B'
            ELSE "C"
        END) AS GRADE,
        A.SAL * (CASE
            WHEN AVG(C.SCORE) >= 96 THEN 0.2
            WHEN AVG(C.SCORE) >= 90 THEN 0.15
            WHEN AVG(C.SCORE) >= 80 THEN 0.1
            ELSE 0.0
        END) AS BONUS
    FROM HR_EMPLOYEES A
    JOIN HR_GRADE C ON A.EMP_NO = C.EMP_NO
    GROUP BY A.EMP_NO
    ORDER BY 1
