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
    public void insercaoRegistroDetalhe(final MasterDetailEvent e) {

    }

    @Override
    public void alteracaoRegistroDetalhe(final MasterDetailEvent e) {

    }

    @Override
    public void exclusaoRegistroDetalhe(final MasterDetailEvent e) {

    }

    @Override
    public void pesquisaRegistroDetalhe(final MasterDetailEvent e) {

    }

    @Override
    public void gravacaoRegistroDetalhe(final MasterDetailEvent e) {

    }

    @Override
    public void cancelamentoRegistroDetalhe(final MasterDetailEvent e) {

    }

    @Override
    public void selecaoDeIten(final MasterDetailEvent event) {

    }

    @Override
    public void reiniciaPesquisa(final MasterDetailEvent event) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                table.getSelectionModel().clearSelection();
                table.itemsProperty().setValue(null);
            }
        });
    }

    @Override
    public void selecaoDeItenDetalhe(final MasterDetailEvent event) {

    }

    @Override
    public void inicioCadastroDetalhe(final MasterDetailEvent event) {

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
