/* find all references to org.jgrapht library in your project */
/* this can help to e.g. eliminate or update some outdated library in your project */
SELECT FROM E WHERE in IN (SELECT FROM Node WHERE id LIKE "%org\/jgrapht%")