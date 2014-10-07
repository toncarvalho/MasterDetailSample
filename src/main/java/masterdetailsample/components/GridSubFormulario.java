package masterdetailsample.components;

import javafx.application.Platform;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import masterdetailsample.eventos.masterdetail.DetailEventListener;
import masterdetailsample.eventos.masterdetail.MasterDetailEvent;
import masterdetailsample.model.Contato;
import masterdetailsample.model.Pessoa;

/**
 * Created by ton on 9/30/14.
 */
public class GridSubFormulario implements DetailEventListener {

    private TableView<Contato> table;

    @Override
    public void insertDetailListener(final MasterDetailEvent e) {

    }

    @Override
    public void changeDetailListener(final MasterDetailEvent e) {

    }

    @Override
    public void deleteDetailListener(final MasterDetailEvent e) {

    }

    @Override
    public void searchDetailListener(final MasterDetailEvent e) {

    }

    @Override
    public void persistDetailListener(final MasterDetailEvent e) {

    }

    @Override
    public void cancelDetailListener(final MasterDetailEvent e) {

    }

    @Override
    public void selectDetailListener(final MasterDetailEvent event) {

    }

    @Override
    public void restartSearchInDetails(final MasterDetailEvent event) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                table.getSelectionModel().clearSelection();
                table.itemsProperty().setValue(null);
            }
        });
    }

    @Override
    public void selectMasterItemListener(final MasterDetailEvent event) {

    }

    @Override
    public void startNewDetailListener(final MasterDetailEvent event) {

    }

    public GridSubFormulario() {

        TableColumn nome = new TableColumn("Nome");
        nome.setMinWidth(100);
        nome.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("nome"));

        TableColumn fone = new TableColumn("Fone");
        fone.setMinWidth(110);
        fone.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("fone"));

        table = new TableView();
        table.getColumns().addAll(nome, fone);

        table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public TableView getTable() {
        return table;
    }
}
