package masterdetailsample.components;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import masterdetailsample.eventos.masterdetail.MasterDetailEvent;
import masterdetailsample.eventos.masterdetail.MasterDetailEventListener;
import masterdetailsample.eventos.masterdetail.MasterDetailEventSource;
import masterdetailsample.types.FormState;

/**
 * Created by ton on 9/26/14.
 */
public class BarraDeFerramentasInicial implements MasterDetailEventListener {

    private final MasterDetailEventSource masterDetailSource;
    private FormState formState;

    public Button novo = new Button("Novo");
    public Button alterar = new Button("Alterar");
    public Button excluir = new Button("Excluir");

    private ToolBar barra;

    public BarraDeFerramentasInicial(final MasterDetailEventSource masterDetailSource) {
        this.masterDetailSource = masterDetailSource;
    }

    public FormState getFormState() {
        return formState;
    }

    public void setFormState(final FormState formState) {
        this.formState = formState;
    }

    @Override
    public void inicioCadastro(final MasterDetailEvent e) {

        this.formState = FormState.INICIAL;
        this.novo.disableProperty().set(false);
        this.alterar.disableProperty().set(true);
        this.excluir.disableProperty().set(true);
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
        this.novo.disableProperty().set(true);
        this.alterar.disableProperty().set(true);
        this.excluir.disableProperty().set(true);
    }

    @Override
    public void alteracaoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.EDITANDO;
        this.novo.disableProperty().set(true);
        this.alterar.disableProperty().set(true);
        this.excluir.disableProperty().set(true);
    }

    @Override
    public void exclusaoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.EXCLUINDO;
        this.novo.disableProperty().set(true);
        this.alterar.disableProperty().set(true);
        this.excluir.disableProperty().set(true);
    }

    @Override
    public void pesquisaRegistro(final MasterDetailEvent e) {
        this.formState = FormState.PESQUISANDO;
        this.novo.disableProperty().set(false);
        this.alterar.disableProperty().set(true);
        this.excluir.disableProperty().set(true);
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
        this.novo.disableProperty().set(false);
        this.alterar.disableProperty().set(true);
        this.excluir.disableProperty().set(true);
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

    @Override
    public void selecaoDeIten(final MasterDetailEvent event) {
        this.formState = FormState.EXIBINDO_REGISTRO_SELECIONADO;
        this.novo.disableProperty().set(false);
        this.alterar.disableProperty().set(false);
        this.excluir.disableProperty().set(false);
    }

    @Override
    public void reiniciaPesquisa(final MasterDetailEvent event) {

    }

    public ToolBar createBarraInicializacao() {
        this.barra = new ToolBar(novo, alterar, excluir);

        return this.barra;
    }
}
