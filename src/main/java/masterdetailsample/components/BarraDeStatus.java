package masterdetailsample.components;

import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import masterdetailsample.eventos.masterdetail.MasterDetailEvent;
import masterdetailsample.eventos.masterdetail.MasterDetailEventListener;
import masterdetailsample.types.FormState;

/**
 * Created by ton on 9/29/14.
 */
public class BarraDeStatus extends HBox implements MasterDetailEventListener {

    private Label label = new Label();

    public BarraDeStatus() {
        this.getChildren().add(new Separator());
        this.getChildren().add(label);
        this.getChildren().add(new Separator());
    }

    @Override
    public void inicioCadastro(final MasterDetailEvent e) {

        this.label.textProperty().setValue(" Status: " + FormState.INICIAL.name());
    }

    @Override
    public void gravacaoRegistro(final MasterDetailEvent e) {
        this.label.textProperty().setValue(" Status: " + FormState.PROCESSANDO.name());
    }

    @Override
    public void cancelamentoRegistro(final MasterDetailEvent e) {
        this.label.textProperty().setValue(" Status: " + FormState.PROCESSANDO.name());
    }

    @Override
    public void insercaoRegistro(final MasterDetailEvent e) {
        this.label.textProperty().setValue(" Status: " + FormState.INSERINDO.name());
    }

    @Override
    public void alteracaoRegistro(final MasterDetailEvent e) {
        this.label.textProperty().setValue(" Status: " + FormState.EDITANDO.name());
    }

    @Override
    public void exclusaoRegistro(final MasterDetailEvent e) {
        this.label.textProperty().setValue(" Status: " + FormState.EXCLUINDO.name());
    }

    @Override
    public void pesquisaRegistro(final MasterDetailEvent e) {
        this.label.textProperty().setValue(" Status: " + FormState.PESQUISANDO.name());
    }

    @Override
    public void insercaoRegistroDetalhe(final MasterDetailEvent e) {
        this.label.textProperty().setValue(" Status: " + FormState.INSERINDO_DETALHE.name());
    }

    @Override
    public void alteracaoRegistroDetalhe(final MasterDetailEvent e) {
        this.label.textProperty().setValue(" Status: " + FormState.EDITANDO_DETALHE.name());
    }

    @Override
    public void exclusaoRegistroDetalhe(final MasterDetailEvent e) {
        this.label.textProperty().setValue(" Status: " + FormState.EXCLUINDO_DETALHE.name());
    }

    @Override
    public void pesquisaRegistroDetalhe(final MasterDetailEvent e) {
        this.label.textProperty().setValue(" Status: " + FormState.PESQUISANDO_ITENS_DETALHE.name());
    }

    @Override
    public void gravacaoRegistroDetalhe(final MasterDetailEvent e) {
        this.label.textProperty().setValue(" Status: " + FormState.PROCESSANDO_DETALHE.name());
    }

    @Override
    public void cancelamentoRegistroDetalhe(final MasterDetailEvent e) {
        this.label.textProperty().setValue(" Status: " + FormState.INICIAL.name());
    }



    @Override
    public void selecaoDeIten(final MasterDetailEvent event) {

    }

    @Override
    public void reiniciaPesquisa(final MasterDetailEvent event) {

    }
}
