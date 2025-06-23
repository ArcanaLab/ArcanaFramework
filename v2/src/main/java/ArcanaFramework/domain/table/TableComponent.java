package ArcanaFramework.domain.table;

import ArcanaFramework.core.base.BaseComponent;

public class TableComponent implements BaseComponent {
    private TableEntity tableEntity;

    public TableComponent(TableEntity tableEntity) {
        this.tableEntity = tableEntity;
    }

    @Override
    public TableEntity getEntity() {
        return this.tableEntity;
    }
}
