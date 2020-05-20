package com.jiejing.dbsync.config;

import com.jiejing.dbsync.subscribe.DBSyncHandlerRegistry;
import com.jiejing.dbsync.subscribe.DBSyncProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBSyncConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public DBSyncHandlerRegistry dbSyncHandlerRegistry() {
        return new DBSyncHandlerRegistry();
    }

    @Bean
    @ConditionalOnMissingBean
    public DBSyncProcessor dbSyncProcessor() {
        return new DBSyncProcessor(dbSyncHandlerRegistry());
    }
}
