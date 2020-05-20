package com.github.bailaohe.dbsync.config;

import com.github.bailaohe.dbsync.subscribe.DBSyncHandlerRegistry;
import com.github.bailaohe.dbsync.subscribe.DBSyncProcessor;
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
