package Model.Mahasiswa;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ModelTable extends AbstractTableModel {
    private final List<Mahasiswa> list;
    private final String[] columnNames = {"ID", "Nama", "NIM"};

    public ModelTable(List<Mahasiswa> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mahasiswa m = list.get(rowIndex);
        switch (columnIndex) {
            case 0: return m.getId();
            case 1: return m.getNama();
            case 2: return m.getNim();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; // Supaya tidak bisa diedit langsung dari tabel
    }
}
