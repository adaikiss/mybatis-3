package org.apache.ibatis.executor.parameter.impl;

import org.apache.ibatis.executor.parameter.RowBoundsHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * Created by hulingwei on 2015/8/5.
 */
public class OracleRowBoundsHandler implements RowBoundsHandler {
    @Override
    public String handle(String sql, RowBounds rowBounds) {
        if(rowBounds == null || rowBounds == RowBounds.DEFAULT){
            return sql;
        }
        return new StringBuilder(98 + sql.length()).append("select * from (select rownum as __rn, __p.* from (").append(sql)
                .append(") __p where rownum < ").append(rowBounds.getLimit() + rowBounds.getOffset()).append(") where __rn >= ").append(rowBounds.getOffset()).toString();
    }
}
