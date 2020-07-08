/* Find some node, you can copy node id by right clicking on the visible node */
SELECT FROM Node WHERE id = "com/virtuslab/graphbuddy_playground/reference/GBClass#GBInnerPrivateClass#"

/* Search for all nodes directed into A class */
SELECT expand(in()) FROM Node WHERE id = "com/virtuslab/graphbuddy_playground/demo/A#"

/* Traverse all the calls edges from CallChain.methdod() with some max depth */
TRAVERSE out('CALL') FROM 
    (SELECT FROM Node WHERE id = "com/virtuslab/graphbuddy_playground/demo/CallChain.methodD().") 
MAXDEPTH 3



