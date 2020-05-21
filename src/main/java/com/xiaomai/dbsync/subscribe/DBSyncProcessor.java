package com.xiaomai.dbsync.subscribe;

import com.xiaomai.dbsync.event.payload.RowBatchChanged;
import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by baihe on 2017/8/24.
 */
@AllArgsConstructor
public class DBSyncProcessor {

    private DBSyncHandlerRegistry handlerRegistry;

    public void processDBSync(String interest, RowBatchChanged payload) {
        processDBSync(interest, payload, ImmutableList.of(), ImmutableList.of());
    }

    public void processDBSync(String interest, RowBatchChanged payload, List oldRows, List newRows) {

        if (handlerRegistry.containsKey(interest)) {
            List<IDBSyncHandler> handlers = handlerRegistry.get(interest);

            if (CollectionUtils.isEmpty(oldRows) && CollectionUtils.isEmpty(newRows)) {
                handlers.forEach(handler -> handler.onChange(payload));
            } else {
                handlers.forEach(handler -> handler.onChange(payload, oldRows, newRows));
            }
        }
    }
}
