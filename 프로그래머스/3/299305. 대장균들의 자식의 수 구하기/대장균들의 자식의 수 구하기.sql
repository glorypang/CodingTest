SELECT A.ID, COUNT(B.PARENT_ID) AS CHILD_COUNT
FROM ECOLI_DATA AS A
LEFT OUTER JOIN ECOLI_DATA AS B
  ON A.ID = B.PARENT_ID
GROUP BY A.ID;