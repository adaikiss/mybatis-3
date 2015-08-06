/**
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
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
