# infinispan-cachestore-customjpa

Since JPA cache store is only supported in Library mode on JBoss Data Grid, I have created a customer cache store which can be used in client-server mode on JBoss Data Grid.

Below are the procedures to deploy this cache store.
1. Build the source code: mvn install -DskipTests=true
2. Download JBoss Data Grid 6.6 Server and JBoss EAP 6.4 Server
3. Unzip both JDG 6.6 and EAP 6.4
4. Copy the following modules from EAP 6.4 to JDG 6.6: asm.asm, org.antlr, org.apache.commons.collections, org.dom4j, org.jaxen
5. Install and start the database such as MySQL
6. Install the JDBC driver, e.g. mysql jdbc driver, as a module in JDG 6.6
7. Start JDG 
8. run addUser.sh to add a user in ApplicationRealm with REST role
9. Test gettting data with URL http://localhost:8080/test/cacheStore
