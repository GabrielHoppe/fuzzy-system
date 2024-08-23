import java.util.Locale;
import java.util.Scanner;
public class App {
    private Scanner in;
    private BarSystem barSystem;

    public App(){
        barSystem = new BarSystem();
        in = new Scanner(System.in);
        in.useLocale(Locale.ENGLISH); //usar . como decimal
    }

    public void executar(){
        int input;
        do{
        display();
        System.out.print("Digite uma opcao");
        input = in.nextInt();
        in.nextLine();

        switch (input) {
            case 1:
                novoCliente();
            break;
        
            case 2:
                removerCliente();
            break;

            case 3:
                listaDeClientes();
            break;

            case 4:
                verificarSeClienteEstaNoBar();
            break;

            case 5:
                nClientes();
            break;

            case 6:
                generoDiff();
            break;

            default:
            break;
        }
        }while(input != 7);
    }

    private void display(){
        String opcoes = "[1] Novo cliente\n[2] Saida de cliente\n[3] Lista de clientes no bar\n[4] Verificar se cliente esta no bar\n[5] Numero de clientes no bar\n[6] Distribuição de genero no bar\n[7] Sair";
        System.out.println(opcoes);
    }

    private void novoCliente(){
        String nome,cpf,genero;
        int idade;
        boolean ok;

        
        System.out.println("Novo cliente");
        System.out.println("Digite o nome");
        nome = in.nextLine();
        System.out.println("Digite o Cpf");
        cpf = in.nextLine();
        System.out.println("Digite o genero");
        genero = in.nextLine();
        System.out.println("Digite a idade");
        idade = in.nextInt();

        ok = barSystem.adicionaCliente(nome,cpf,genero,idade);

        if (ok==false){
            System.out.println("Cliente não registrado!");
        }
    }

    private void removerCliente(){
        String cpf;
        boolean ok;

        System.out.println("Saida de cliente");
        System.out.println("Digite o Cpf");
        cpf = in.nextLine();

        ok = barSystem.removeCliente(cpf);

        if (ok ==false){
            System.out.println("Cliente não encontrado!");
        }
    }

    private void listaDeClientes(){
        System.out.println(barSystem.toString());
    }

    private void verificarSeClienteEstaNoBar(){
        String cpf;
        Cliente cliente;

        System.out.println("Verificar se cliente esta no bar");
        System.out.println("Digite o Cpf");
        cpf = in.nextLine();

        cliente = barSystem.validaCpf(cpf);

        if (cliente == null){
            System.out.println("Cliente não encontrado!");
        }else{
            System.out.println(cliente.toString());
        }

    }

    private void nClientes(){
        System.out.println(barSystem.numClientes());
    }

    private void generoDiff(){
        System.out.println(barSystem.generoDiff());
    }


}
