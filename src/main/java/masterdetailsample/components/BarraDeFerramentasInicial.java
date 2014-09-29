package masterdetailsample.components;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import masterdetailsample.eventos.MasterDetailEvent;
import masterdetailsample.eventos.MasterDetailListener;
import masterdetailsample.eventos.MasterDetailSource;
import masterdetailsample.types.FormState;

/**
 * Created by ton on 9/26/14.
 */
public class BarraDeFerramentasInicial implements MasterDetailListener {

    private final MasterDetailSource masterDetailSource;
    private FormState formState;

    public Button novo = new Button("Novo");
    public Button alterar = new Button("Alterar");
    public Button excluir = new Button("Excluir");

    private ToolBar barra;

    public BarraDeFerramentasInicial(final MasterDetailSource masterDetailSource) {
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
        this.novo.disableProperty().setValue(false);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);
        System.out.println(" executando: inicioCadastro  na barra INICIAL");
    }

    @Override
    public void gravacaoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.PROCESSANDO;
        this.novo.disableProperty().setValue(false);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);
        System.out.println(" executando: gravacaoRegistro  na barra INICIAL");
    }

    @Override
    public void cancelamentoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.PROCESSANDO;
        this.novo.disableProperty().setValue(false);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);
        System.out.println(" executando: cancelamentoRegistro  na barra INICIAL");
    }

    @Override
    public void insercaoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.INSERINDO;
        this.novo.disableProperty().set(true);
        this.alterar.disableProperty().set(true);
        this.excluir.disableProperty().set(true);
        System.out.println(" executando: insercaoRegistro  na barra INICIAL");
    }

    @Override
    public void alteracaoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.EDITANDO;
        this.novo.disableProperty().set(true);
        this.alterar.disableProperty().set(true);
        this.excluir.disableProperty().set(true);
        System.out.println(" executando: alteracaoRegistro  na barra INICIAL");
    }

    @Override
    public void exclusaoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.EXCLUINDO;
        this.novo.disableProperty().set(true);
        this.alterar.disableProperty().set(true);
        this.excluir.disableProperty().set(true);
        System.out.println(" executando: exclusaoRegistro  na barra INICIAL");
    }

    @Override
    public void pesquisaRegistro(final MasterDetailEvent e) {
        this.formState = FormState.PESQUISANDO;
        this.novo.disableProperty().setValue(false);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);

        System.out.println(" executando: pesquisaRegistro  na barra INICIAL");
    }

    @Override
    public void insercaoRegistroDetalhe(final MasterDetailEvent e) {
        this.formState = FormState.INSERINDO_DETALHE;
        this.novo.disableProperty().setValue(false);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);
        System.out.println(" executando: insercaoRegistroDetalhe  na barra INICIAL");
    }

    @Override
    public void alteracaoRegistroDetalhe(final MasterDetailEvent e) {
        this.formState = FormState.EDITANDO_DETALHE;
        this.novo.disableProperty().setValue(false);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);
        System.out.println(" executando: alteracaoRegistroDetalhe  na barra INICIAL");
    }

    @Override
    public void exclusaoRegistroDetalhe(final MasterDetailEvent e) {
        this.formState = FormState.EXCLUINDO_DETALHE;
        this.novo.disableProperty().setValue(false);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);

        System.out.println(" executando: exclusaoRegistroDetalhe  na barra INICIAL");
    }

    @Override
    public void pesquisaRegistroDetalhe(final MasterDetailEvent e) {
        this.formState = FormState.PESQUISANDO_ITENS_DETALHE;
        this.novo.disableProperty().setValue(false);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);
        System.out.println(" executando: pesquisaRegistroDetalhe  na barra INICIAL");
    }

    @Override
    public void gravacaoRegistroDetalhe(final MasterDetailEvent e) {
        this.formState = FormState.PROCESSANDO;
        this.novo.disableProperty().setValue(false);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);

        System.out.println(" executando: gravacaoRegistroDetalhe  na barra INICIAL");
    }

    @Override
    public void cancelamentoRegistroDetalhe(final MasterDetailEvent e) {
        this.formState = FormState.PROCESSANDO;
        this.novo.disableProperty().setValue(false);
        this.alterar.disableProperty().setValue(false);
        this.excluir.disableProperty().setValue(false);

        System.out.println(" executando: cancelamentoRegistroDetalhe  na barra INICIAL");
    }

    public ToolBar createBarraInicializacao() {
        this.barra = new ToolBar(novo, alterar, excluir);

        novo.setOnAction(event -> {
            masterDetailSource.insercaoRegistro(this.barra);
        });

        alterar.setOnAction(event -> {
            masterDetailSource.alteracaoRegistro(this.barra);
        });

        excluir.setOnAction(event -> {
            masterDetailSource.exclusaoRegistro(this.barra);
        });
        return this.barra;
    }
}
