/* Find all the external calls to declared in GBClass declarations (includes GBClass constructor) */
SELECT FROM (
TRAVERSE in('CALL') FROM 
    (SELECT expand(out("DECLARATION")) FROM Node WHERE id = "com/virtuslab/graphbuddy_playground/reference/GBClass#") 
MAXDEPTH 1
)
WHERE NOT(uri like "%/src/main/scala/com/virtuslab/graphbuddy_playground/reference/GBClass.scala")

SELECT FROM (
TRAVERSE in('CALL') FROM 
    (SELECT expand(out("DECLARATION")) FROM Node WHERE id = "com/virtuslab/graphbuddy_playground/reference/GBClass#" AND kind = "CONSTRUCTOR") 
MAXDEPTH 1
)
WHERE NOT(uri like "%/src/main/scala/com/virtuslab/graphbuddy_playground/reference/GBClass.scala")