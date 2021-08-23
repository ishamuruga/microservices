package com.superstar.api.deposit.config;



import com.superstar.retail.account.aggregate.AccountAggregate;

import org.axonframework.config.Configurer;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {
     @Bean
     EventSourcingRepository<AccountAggregate> accountAggregateEventSourcingRepository(EventStore eventStore){
         EventSourcingRepository<AccountAggregate> repository = EventSourcingRepository.builder(AccountAggregate.class).eventStore(eventStore).build();
         return repository;
     }

    //@Bean
    //public void configureEventHandler(Configurer configurer) {


        
        //configurer.registerEventHandler(config -> new MyEventHandlingComponent());

        // or, when the handling component contains several message handler types:
        //configurer.registerMessageHandler(config -> new MyEventHandlingComponent());

        // or, directly on the EventProcessingConfigurer:
        //configurer.eventProcessing()
        //          .registerEventHandler(config -> new MyEventHandlingComponent());
    //}
}
