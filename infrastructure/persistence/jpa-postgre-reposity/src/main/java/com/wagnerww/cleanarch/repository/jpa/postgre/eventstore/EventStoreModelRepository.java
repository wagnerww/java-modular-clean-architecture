package com.wagnerww.cleanarch.repository.jpa.postgre.eventstore;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

public abstract interface EventStoreModelRepository extends 
PanacheRepositoryBase<EventStoreJpaEntity, String> {

}
