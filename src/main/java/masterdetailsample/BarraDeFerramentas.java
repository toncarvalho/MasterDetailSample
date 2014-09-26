package masterdetailsample;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import masterdetailsample.eventos.MasterDetailEvent;
import masterdetailsample.eventos.MasterDetailListener;

/**
 * Created by ton on 9/26/14.
 */
public class BarraDeFerramentas implements MasterDetailListener {

    private FormState formState;
    private ToolsMode toolsMode;

    private Button novo = new Button("Novo");
    private Button alterar = new Button("Alterar");
    private Button excluir = new Button("Excluir");
    private Button salvar = new Button("Salvar");
    private Button cancelar = new Button("Cancelar");

    public FormState getFormState() {
        return formState;
    }

    public void setFormState(final FormState formState) {
        this.formState = formState;
    }

    @Override
    public void inicioCadastro(final MasterDetailEvent e) {
        this.formState = FormState.INICIAL;
        if (this.toolsMode.equals(ToolsMode.INICIALIZACAO)) {
            this.novo.disableProperty().setValue(true);
            this.alterar.disableProperty().setValue(false);
            this.excluir.disableProperty().setValue(false);
        } else if (this.toolsMode.equals(ToolsMode.FINALIZACAO)) {
            this.salvar.disableProperty().setValue(false);
            this.cancelar.disableProperty().setValue(false);
        }
    }

    @Override
    public void fimCadastro(final MasterDetailEvent e) {
        this.formState = FormState.INICIAL;
        if (this.toolsMode.equals(ToolsMode.INICIALIZACAO)) {
            this.novo.disableProperty().setValue(true);
            this.alterar.disableProperty().setValue(false);
            this.excluir.disableProperty().setValue(false);
        } else if (this.toolsMode.equals(ToolsMode.FINALIZACAO)) {
            this.salvar.disableProperty().setValue(false);
            this.cancelar.disableProperty().setValue(false);
        }
    }

    @Override
    public void insercaoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.INSERINDO;
        if (this.toolsMode.equals(ToolsMode.INICIALIZACAO)) {
            this.novo.disableProperty().setValue(false);
            this.alterar.disableProperty().setValue(false);
            this.excluir.disableProperty().setValue(false);
        } else if (this.toolsMode.equals(ToolsMode.FINALIZACAO)) {
            this.salvar.disableProperty().setValue(true);
            this.cancelar.disableProperty().setValue(true);
        }
    }

    @Override
    public void alteracaoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.EDITANDO;
        if (this.toolsMode.equals(ToolsMode.INICIALIZACAO)) {
            this.novo.disableProperty().setValue(false);
            this.alterar.disableProperty().setValue(false);
            this.excluir.disableProperty().setValue(false);
        } else if (this.toolsMode.equals(ToolsMode.FINALIZACAO)) {
            this.salvar.disableProperty().setValue(true);
            this.cancelar.disableProperty().setValue(true);
        }
    }

    @Override
    public void exclusaoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.EXCLUINDO;
        if (this.toolsMode.equals(ToolsMode.INICIALIZACAO)) {
            this.novo.disableProperty().setValue(false);
            this.alterar.disableProperty().setValue(false);
            this.excluir.disableProperty().setValue(false);
        } else if (this.toolsMode.equals(ToolsMode.FINALIZACAO)) {
            this.salvar.disableProperty().setValue(false);
            this.cancelar.disableProperty().setValue(false);
        }
    }

    @Override
    public void pesquisaRegistro(final MasterDetailEvent e) {
        this.formState = FormState.PESQUISANDO;
        if (this.toolsMode.equals(ToolsMode.INICIALIZACAO)) {
            this.novo.disableProperty().setValue(false);
            this.alterar.disableProperty().setValue(false);
            this.excluir.disableProperty().setValue(false);
        } else if (this.toolsMode.equals(ToolsMode.FINALIZACAO)) {
            this.salvar.disableProperty().setValue(false);
            this.cancelar.disableProperty().setValue(true);
        }
    }

    @Override
    public void insercaoRegistroDetalhe(final MasterDetailEvent e) {
        this.formState = FormState.INSERINDO_DETALHE;
        if (this.toolsMode.equals(ToolsMode.INICIALIZACAO)) {
            this.novo.disableProperty().setValue(false);
            this.alterar.disableProperty().setValue(false);
            this.excluir.disableProperty().setValue(false);
        } else if (this.toolsMode.equals(ToolsMode.FINALIZACAO)) {
            this.salvar.disableProperty().setValue(true);
            this.cancelar.disableProperty().setValue(true);
        }
    }

    @Override
    public void alteracaoRegistroDetalhe(final MasterDetailEvent e) {
        this.formState = FormState.EDITANDO_DETALHE;
        if (this.toolsMode.equals(ToolsMode.INICIALIZACAO)) {
            this.novo.disableProperty().setValue(false);
            this.alterar.disableProperty().setValue(false);
            this.excluir.disableProperty().setValue(false);
        } else if (this.toolsMode.equals(ToolsMode.FINALIZACAO)) {
            this.salvar.disableProperty().setValue(true);
            this.cancelar.disableProperty().setValue(true);
        }
    }

    @Override
    public void exclusaoRegistroDetalhe(final MasterDetailEvent e) {
        this.formState = FormState.EXCLUINDO_DETALHE;
        if (this.toolsMode.equals(ToolsMode.INICIALIZACAO)) {
            this.novo.disableProperty().setValue(false);
            this.alterar.disableProperty().setValue(false);
            this.excluir.disableProperty().setValue(false);
        } else if (this.toolsMode.equals(ToolsMode.FINALIZACAO)) {
            this.salvar.disableProperty().setValue(false);
            this.cancelar.disableProperty().setValue(true);
        }
    }

    @Override
    public void pesquisaRegistroDetalhe(final MasterDetailEvent e) {
        this.formState = FormState.PESQUISANDO_ITENS_DETALHE;
        if (this.toolsMode.equals(ToolsMode.INICIALIZACAO)) {
            this.novo.disableProperty().setValue(false);
            this.alterar.disableProperty().setValue(false);
            this.excluir.disableProperty().setValue(false);
        } else if (this.toolsMode.equals(ToolsMode.FINALIZACAO)) {
            this.salvar.disableProperty().setValue(false);
            this.cancelar.disableProperty().setValue(true);
        }
    }

    public ToolBar getBarraInicializacao() {
        this.toolsMode = ToolsMode.INICIALIZACAO;
        return new ToolBar(novo, excluir, alterar);
    }

    public ToolBar getBarraFinalizacao() {
        this.toolsMode = ToolsMode.FINALIZACAO;
        return new ToolBar(salvar, cancelar);
    }
}
