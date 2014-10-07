package masterdetailsample.screens;

import javafx.application.Platform;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import masterdetailsample.eventos.masterdetail.MasterDetailEvent;
import masterdetailsample.eventos.masterdetail.MasterEventListener;
import masterdetailsample.model.Pessoa;

/**
 * Created by ton on 9/30/14.
 */
public class Grid implements MasterEventListener {

    private TableView table;

    @Override
    public void startFormListener(final MasterDetailEvent e) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                table.itemsProperty().setValue(null);
            }
        });
    }

    @Override
    public void persistListener(final MasterDetailEvent e) {

    }

    @Override
    public void cancelListener(final MasterDetailEvent e) {

    }

    @Override
    public void insertListener(final MasterDetailEvent e) {

    }

    @Override
    public void changeItemListener(final MasterDetailEvent e) {

    }

    @Override
    public void deleteListener(final MasterDetailEvent e) {

    }

    @Override
    public void searchListener(final MasterDetailEvent e) {

    }

    @Override
    public void selectListener(final MasterDetailEvent event) {

    }

    @Override
    public void restartSearchListener(final MasterDetailEvent event) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                table.getSelectionModel().clearSelection();
                table.itemsProperty().setValue(null);
            }
        });
    }

    public Grid() {

        TableColumn nome = new TableColumn("Nome");
        nome.setMinWidth(100);
        nome.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("nome"));

        TableColumn fone = new TableColumn("Fone");
        fone.setMinWidth(110);
        fone.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("fone"));

        TableColumn email = new TableColumn("Email");
        email.setMinWidth(200);
        email.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("email"));

        table = new javafx.scene.control.TableView();
        table.getColumns().addAll(nome, fone, email);

        table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public TableView getTable() {
        return table;
    }
}
