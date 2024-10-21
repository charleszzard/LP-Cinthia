package TrabalhoEmGrupo;

public class Cliente {
   
    private static int senhaDeAtendimento = 0;
    private static int geradorDeSenha = 1;

   
    private int senhaDoCliente;
    private String nome;

 
    public Cliente(String nome) {
        this.nome = nome;
        this.senhaDoCliente = geradorDeSenha;
        geradorDeSenha++;
    }

   
    public int getSenhaDoCliente() {
        return senhaDoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public String toString() {
        return "Nome: " + nome + ", Senha: " + senhaDoCliente;
    }

    
    public static int proximo() {
        senhaDeAtendimento++;
        return senhaDeAtendimento;
    }

    public static int getSenhaDeAtendimento() {
        return senhaDeAtendimento;
    }
}
