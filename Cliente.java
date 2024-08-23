public class Cliente {

    private String cpf, genero, nome;
    private int idade;
    //construtor
    public Cliente(String nome, String cpf, String genero, int idade){
        this.nome = nome;
        this.cpf = cpf;
        this.genero = genero;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getGenero() {
        return genero;
    }

    public int getIdade() {
        return idade;
    }

    public String toString(){
        String info;
        info = nome+"\n"+cpf+"\n"+genero+"\n"+idade;
        return info;
    }

}
