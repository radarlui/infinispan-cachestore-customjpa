# infinispan-cachestore-customjpa

Since JPA cache store is only supported in Library mode on JBoss Data Grid, I have created a custom cache store which can be used in client-server mode on JBoss Data Grid.

Below are the procedures to deploy this cache store. <BR>
1. Download and unzip JBoss Data Grid 6.6 maven repository <BR>
2. Modify ~/.m2/settings.xml to include the local JDG 6.6 maven repository <BR>
3. Build the source code: mvn install -DskipTests=true <BR>
4. Download JBoss Data Grid 6.6 Server and JBoss EAP 6.4 Server <BR>
5. Unzip both JDG 6.6 and EAP 6.4 <BR>
6. Copy the following modules from EAP 6.4 to JDG 6.6: asm.asm, org.antlr, org.apache.commons.collections, org.dom4j, org.jaxen <BR>
7. Install and start the database such as MySQL <BR>
8. Install the JDBC driver, e.g. mysql jdbc driver, as a module in JDG 6.6 <BR>
9. Copy clustered.xml into JDG/standalone/configuration <BR>
9. Start JDG by running JDG/bin/clustered.sh  <BR>
10. run addUser.sh to add a user in ApplicationRealm with REST role <BR>
11. Test gettting data with URL http://localhost:8080/test/cacheStore <BR>

Notes on what has changed in source code: <BR>
- Added javax.persistence.spi.PersistenceProvider and org.infinispan.persistence.spi.AdvancedLoadWriteStore to META-INF/services <BR>
- Added jboss-deployment-structure.xml and persistence.xml to META-INF/ <BR>
- Modified JpaStore to create own EntityManagerFactory <BR>
- Modified JpaStoreConfigurationBuilder to change type of entityClass from Class to String <BR>
- Added Person entity class for testing <BR>
