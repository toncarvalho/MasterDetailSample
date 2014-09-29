package masterdetailsample.components;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import masterdetailsample.eventos.MasterDetailEvent;
import masterdetailsample.eventos.MasterDetailListener;
import masterdetailsample.types.FormState;

/**
 * Created by ton on 9/26/14.
 */
public class BarraDeFerramentasFinal implements MasterDetailListener {

    private FormState formState;

    public Button salvar = new Button("Salvar");
    public Button cancelar = new Button("Cancelar");
    private ToolBar barra;

    public FormState getFormState() {
        return formState;
    }

    public void setFormState(final FormState formState) {
        this.formState = formState;
    }

    @Override
    public void inicioCadastro(final MasterDetailEvent e) {
        this.formState = FormState.INICIAL;

        this.salvar.disableProperty().setValue(true);
        this.cancelar.disableProperty().setValue(true);
    }

    @Override
    public void gravacaoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.PROCESSANDO;
        this.salvar.disableProperty().setValue(false);
        this.cancelar.disableProperty().setValue(false);
    }

    @Override
    public void insercaoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.INSERINDO;
        this.salvar.disableProperty().setValue(true);
        this.cancelar.disableProperty().setValue(true);
    }

    @Override
    public void alteracaoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.EDITANDO;
        this.salvar.disableProperty().setValue(true);
        this.cancelar.disableProperty().setValue(true);
    }

    @Override
    public void exclusaoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.EXCLUINDO;
        this.salvar.disableProperty().setValue(false);
        this.cancelar.disableProperty().setValue(true);
    }

    @Override
    public void pesquisaRegistro(final MasterDetailEvent e) {
        this.formState = FormState.PESQUISANDO;

        this.salvar.disableProperty().setValue(false);
        this.cancelar.disableProperty().setValue(true);
    }

    @Override
    public void insercaoRegistroDetalhe(final MasterDetailEvent e) {
        this.formState = FormState.INSERINDO_DETALHE;

        this.salvar.disableProperty().setValue(true);
        this.cancelar.disableProperty().setValue(true);
    }

    @Override
    public void alteracaoRegistroDetalhe(final MasterDetailEvent e) {
        this.formState = FormState.EDITANDO_DETALHE;

        this.salvar.disableProperty().setValue(true);
        this.cancelar.disableProperty().setValue(true);
    }

    @Override
    public void exclusaoRegistroDetalhe(final MasterDetailEvent e) {
        this.formState = FormState.EXCLUINDO_DETALHE;
        this.salvar.disableProperty().setValue(false);
        this.cancelar.disableProperty().setValue(true);
    }

    @Override
    public void pesquisaRegistroDetalhe(final MasterDetailEvent e) {
        this.formState = FormState.PESQUISANDO_ITENS_DETALHE;

        this.salvar.disableProperty().setValue(false);
        this.cancelar.disableProperty().setValue(true);
    }

    @Override
    public void gravacaoRegistroDetalhe(final MasterDetailEvent e) {
        this.formState = FormState.PROCESSANDO;
        this.salvar.disableProperty().setValue(false);
        this.cancelar.disableProperty().setValue(true);
    }

    @Override
    public void cancelamentoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.PROCESSANDO;
        this.salvar.disableProperty().setValue(false);
        this.cancelar.disableProperty().setValue(false);
    }

    @Override
    public void cancelamentoRegistroDetalhe(final MasterDetailEvent e) {
        this.formState = FormState.PROCESSANDO;
        this.salvar.disableProperty().setValue(false);
        this.cancelar.disableProperty().setValue(false);
    }

    public ToolBar createBarraFinalizacao() {

        this.barra = new ToolBar(salvar, cancelar);

        return this.barra;
    }
}
