package com.jiejing.dbsync.subscribe;

import com.jiejing.dbsync.event.payload.RowBatchChanged;

import java.util.List;
import java.util.Set;

public interface IDBSyncHandler {

    /**
     * Generate the subscribe labels
     * @return the subscribe labels
     */
    Set<String> subscribeLabels();

    /**
     * Entry method when a change is detected
     * @param payload the payload of the DML change
     */
    void onChange(RowBatchChanged payload);

    default void onChange(RowBatchChanged payload, List oldRows, List newRows) {

    }
}
