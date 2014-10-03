package masterdetailsample.components;

import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import masterdetailsample.eventos.masterdetail.DetailEventListener;
import masterdetailsample.eventos.masterdetail.MasterDetailEvent;
import masterdetailsample.types.FormState;

/**
 * Created by ton on 9/29/14.
 */
public class BarraDeStatusDetalhe extends HBox implements DetailEventListener {

    private Label label = new Label();
    private FormState formState;

    public BarraDeStatusDetalhe() {
        this.getChildren().add(new Separator());
        this.getChildren().add(label);
        this.getChildren().add(new Separator());
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
        this.formState = FormState.EXIBINDO_REGISTRO_SELECIONADO;
        this.label.textProperty().setValue(" Status: " + FormState.EXIBINDO_REGISTRO_SELECIONADO.name());
    }

    @Override
    public void reiniciaPesquisa(final MasterDetailEvent event) {
        this.formState = FormState.INICIAL;
        this.label.textProperty().setValue(" Status: " + FormState.INICIAL.name());
    }

    @Override
    public void selecaoDeItenDetalhe(final MasterDetailEvent event) {
        this.formState = FormState.DETALHE_SELECIONADO;
        this.label.textProperty().setValue(" Status: " + FormState.DETALHE_SELECIONADO.name());
    }

    @Override
    public void inicioCadastroDetalhe(final MasterDetailEvent event) {
        this.formState = FormState.INICIO_CADASTRO_DETALHE;
        this.label.textProperty().setValue(" Status: " + FormState.INICIO_CADASTRO_DETALHE.name());
    }

    public FormState getFormState() {
        return formState;
    }

    public void setFormState(final FormState formState) {
        this.formState = formState;
    }
}
