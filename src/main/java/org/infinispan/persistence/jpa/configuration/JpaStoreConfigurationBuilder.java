package org.infinispan.persistence.jpa.configuration;

import org.infinispan.commons.util.TypedProperties;
import org.infinispan.configuration.cache.AbstractStoreConfigurationBuilder;
import org.infinispan.configuration.cache.PersistenceConfigurationBuilder;

/**
 *
 * @author <a href="mailto:rtsang@redhat.com">Ray Tsang</a>
 *
 */
public class JpaStoreConfigurationBuilder
      extends AbstractStoreConfigurationBuilder<JpaStoreConfiguration, JpaStoreConfigurationBuilder> {

   private String persistenceUnitName;
   private String entityClass;
   private long batchSize = 100L;
   private boolean storeMetadata = true;

   public JpaStoreConfigurationBuilder(PersistenceConfigurationBuilder builder) {
      super(builder);
   }

   public JpaStoreConfigurationBuilder persistenceUnitName(String persistenceUnitName) {
      this.persistenceUnitName = persistenceUnitName;
      return self();
   }

   public JpaStoreConfigurationBuilder entityClass(String entityClass) {
      this.entityClass = entityClass;
      return self();
   }

   public JpaStoreConfigurationBuilder batchSize(long batchSize) {
      this.batchSize = batchSize;
      return self();
   }

   public JpaStoreConfigurationBuilder storeMetadata(boolean storeMetadata) {
      this.storeMetadata = storeMetadata;
      return self();
   }

   @Override
   public void validate() {
      // how do you validate required attributes?
      super.validate();
   }

   @Override
   public JpaStoreConfiguration create() {
      try {
		return new JpaStoreConfiguration(
		        purgeOnStartup, fetchPersistentState, ignoreModifications,
		        async.create(), singletonStore.create(), preload, shared,
		        TypedProperties.toTypedProperties(properties),
		        persistenceUnitName, Class.forName(entityClass), batchSize, storeMetadata);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      return null;
   }

   @Override
   public JpaStoreConfigurationBuilder read(JpaStoreConfiguration template) {
      persistenceUnitName = template.persistenceUnitName();
      entityClass = template.entityClass().getName();
      batchSize = template.batchSize();
      storeMetadata = template.storeMetadata();

      fetchPersistentState = template.fetchPersistentState();
      ignoreModifications = template.ignoreModifications();
      properties = template.properties();
      purgeOnStartup = template.purgeOnStartup();
      async.read(template.async());
      singletonStore.read(template.singletonStore());
      preload = template.preload();
      shared = template.shared();
      return this;
   }

   @Override
   public JpaStoreConfigurationBuilder self() {
      return this;
   }
}
