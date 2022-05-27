package com.wagnerww.cleanarch.repository.jpa.postgre.eventstore;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.wagnerww.cleanarch.quarkus.domain.eventstore.EventStore;
import com.wagnerww.cleanarch.quarkus.domain.eventstore.EventStoreRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@Named
@ApplicationScoped
public class EventStoreRepositoryImpl implements 
  PanacheRepositoryBase<EventStoreJpaEntity, String>, EventStoreRepository {

  @Inject
  EntityManager em;

  //@Inject
  //private ProductJpaMapper mapper;


  @Override
  @Transactional
  public void create(EventStore anEventStore) {

    EventStoreJpaEntity model = EventStoreJpaMapper.fromDomain(anEventStore);
    em.persist(model);
        
  }

  @Override
  public void activateOrDeactivate(EventStore eventStore) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void sync(EventStore eventStore) {
    // TODO Auto-generated method stub
    
  }

  
}
