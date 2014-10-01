package masterdetailsample.components;

import javafx.application.Platform;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import masterdetailsample.eventos.masterdetail.MasterDetailEvent;
import masterdetailsample.eventos.masterdetail.MasterDetailEventListener;
import masterdetailsample.model.Contato;
import masterdetailsample.model.Pessoa;

/**
 * Created by ton on 9/30/14.
 */
public class GridSubFormulario implements MasterDetailEventListener {

    private TableView<Contato> table;

    @Override
    public void inicioCadastro(final MasterDetailEvent e) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                table.itemsProperty().setValue(null);
            }
        });
    }

    @Override
    public void gravacaoRegistro(final MasterDetailEvent e) {

    }

    @Override
    public void cancelamentoRegistro(final MasterDetailEvent e) {

    }

    @Override
    public void insercaoRegistro(final MasterDetailEvent e) {

    }

    @Override
    public void alteracaoRegistro(final MasterDetailEvent e) {

    }

    @Override
    public void exclusaoRegistro(final MasterDetailEvent e) {

    }

    @Override
    public void pesquisaRegistro(final MasterDetailEvent e) {

    }

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
