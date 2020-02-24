SELECT Блюда.Название AS Блюда
FROM (Диеты JOIN tbl_Диеты_MM_Блюда USING(IdDiet)) JOIN Блюда USING(IdFood)
WHERE Диеты.Название = "Белковая"