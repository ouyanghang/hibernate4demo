package com.jamorn.hibernate.extension;

import org.hibernate.cfg.NamingStrategy;
import org.hibernate.internal.util.StringHelper;

import java.io.Serializable;

/**
 * Created by sunyameng on 14-4-3.
 *
 * 自定义的命名策略
 */

public class CustomNamingStrategy implements NamingStrategy,Serializable {
    public static final NamingStrategy INSTANCE=new CustomNamingStrategy();
    @Override
    public String classToTableName(String className) {
        return addUnderscores( StringHelper.unqualify(className) );
    }

    @Override
    public String propertyToColumnName(String propertyName) {
        return null;
    }

    @Override
    public String tableName(String tableName) {
        return null;
    }

    @Override
    public String columnName(String columnName) {
        return null;
    }

    @Override
    public String collectionTableName(String ownerEntity, String ownerEntityTable, String associatedEntity, String associatedEntityTable, String propertyName) {
        return null;
    }

    @Override
    public String joinKeyColumnName(String joinedColumn, String joinedTable) {
        return null;
    }

    @Override
    public String foreignKeyColumnName(String propertyName, String propertyEntityName, String propertyTableName, String referencedColumnName) {
        return null;
    }

    @Override
    public String logicalColumnName(String columnName, String propertyName) {
        return null;
    }

    @Override
    public String logicalCollectionTableName(String tableName, String ownerEntityTable, String associatedEntityTable, String propertyName) {
        return null;
    }

    @Override
    public String logicalCollectionColumnName(String columnName, String propertyName, String referencedColumn) {
        return null;
    }

    protected static String addUnderscores(String name) {
        StringBuffer buf = new StringBuffer( name.replace('.', '_') );
        for (int i=1; i<buf.length()-1; i++) {
            if (
                    Character.isLowerCase( buf.charAt(i-1) ) &&
                            Character.isUpperCase( buf.charAt(i) ) &&
                            Character.isLowerCase( buf.charAt(i+1) )
                    ) {
                buf.insert(i++, '_');
            }
        }
        return buf.toString().toLowerCase();
    }

}
