package masterdetailsample.components;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import masterdetailsample.eventos.MasterDetailEvent;
import masterdetailsample.eventos.MasterDetailListener;
import masterdetailsample.types.FormState;

/**
 * Created by ton on 9/26/14.
 */
public class BarraDeFerramentasInicial implements MasterDetailListener {

    private FormState formState;

    public Button novo = new Button("Novo");
    public Button alterar = new Button("Alterar");
    public Button excluir = new Button("Excluir");

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
        this.novo.disableProperty().setValue(true);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);
    }

    @Override
    public void gravacaoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.PROCESSANDO;
        this.novo.disableProperty().setValue(false);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);
    }

    @Override
    public void cancelamentoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.PROCESSANDO;
        this.novo.disableProperty().setValue(false);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);
    }

    @Override
    public void insercaoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.INSERINDO;
        this.novo.disableProperty().setValue(false);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);
    }

    @Override
    public void alteracaoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.EDITANDO;
        this.novo.disableProperty().setValue(false);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);
    }

    @Override
    public void exclusaoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.EXCLUINDO;
        this.novo.disableProperty().setValue(false);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);
    }

    @Override
    public void pesquisaRegistro(final MasterDetailEvent e) {
        this.formState = FormState.PESQUISANDO;
        this.novo.disableProperty().setValue(false);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);
    }

    @Override
    public void insercaoRegistroDetalhe(final MasterDetailEvent e) {
        this.formState = FormState.INSERINDO_DETALHE;
        this.novo.disableProperty().setValue(false);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);
    }

    @Override
    public void alteracaoRegistroDetalhe(final MasterDetailEvent e) {
        this.formState = FormState.EDITANDO_DETALHE;
        this.novo.disableProperty().setValue(false);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);
    }

    @Override
    public void exclusaoRegistroDetalhe(final MasterDetailEvent e) {
        this.formState = FormState.EXCLUINDO_DETALHE;
        this.novo.disableProperty().setValue(false);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);
    }

    @Override
    public void pesquisaRegistroDetalhe(final MasterDetailEvent e) {
        this.formState = FormState.PESQUISANDO_ITENS_DETALHE;
        this.novo.disableProperty().setValue(false);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);
    }

    @Override
    public void gravacaoRegistroDetalhe(final MasterDetailEvent e) {
        this.formState = FormState.PROCESSANDO;
        this.novo.disableProperty().setValue(false);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);
    }

    @Override
    public void cancelamentoRegistroDetalhe(final MasterDetailEvent e) {
        this.formState = FormState.PROCESSANDO;
        this.novo.disableProperty().setValue(false);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);
    }

    public ToolBar createBarraInicializacao() {
        this.barra = new ToolBar(novo, alterar, excluir);
        return this.barra;
    }
}
