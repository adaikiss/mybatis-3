package org.apache.ibatis.executor.parameter.impl;

import org.apache.ibatis.executor.parameter.RowBoundsHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * Created by hulingwei on 2015/8/5.
 */
public class MySqlRowBoundsHandler implements RowBoundsHandler {
    @Override
    public String handle(String sql, RowBounds rowBounds) {
        if(rowBounds == null || rowBounds == RowBounds.DEFAULT){
            return sql;
        }
        return new StringBuilder(sql.length() + 25).append(sql).append(" LIMIT ").append(rowBounds.getLimit()).append(" OFFSET ").append(rowBounds.getOffset()).toString();
    }
}
