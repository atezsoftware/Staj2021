package com.atez.inventory.manager.repository;

public class SqlQueries {

    public static String getUserInventoryReportSql(){
        StringBuilder sqlBuilder = new StringBuilder("SELECT u.id, u.first_name, u.last_name, i.name, i.serail_number, ct.name ");
        sqlBuilder.append("FROM inventory i, users u, user_inventory ui, category_type ct ")
                .append("WHERE u.keycloak_id = ? ")
                .append("AND u.id = ui.user_id ")
                .append("AND ui.inventory_id = i.id ")
                .append("AND ui.inventory_id = i.id ")
                .append("ORDER BY u.first_name");
        return sqlBuilder.toString();
    }

    private SqlQueries() {
    }
}
