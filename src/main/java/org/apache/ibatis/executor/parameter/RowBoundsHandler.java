package org.apache.ibatis.executor.parameter;

import org.apache.ibatis.session.RowBounds;

/**
 * Handle rowBounds parameter, eg, add limit & offset segment for mysql.
 * Created by hulingwei on 2015/8/4.
 */
public interface RowBoundsHandler {
    /**
     * @param sql
     * @param rowBounds
     * @return handled sql
     */
    String handle(String sql, RowBounds rowBounds);
}
