-- 코드를 입력하세요
SELECT DISTINCT A.CART_ID
FROM CART_PRODUCTS A
INNER JOIN CART_PRODUCTS B
ON A.CART_ID = B.CART_ID
WHERE A.NAME = 'Milk' AND B.NAME = 'Yogurt'
ORDER BY A.CART_ID