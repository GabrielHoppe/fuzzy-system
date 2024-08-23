import java.util.ArrayList;
public class BarSystem{
    
    private ArrayList<Cliente> listaClientes;

    //construtor
    public BarSystem(){
        listaClientes = new ArrayList<Cliente>();
    }

    public boolean adicionaCliente(String nome, String cpf, String genero, int idade){

        if (validaCpf(cpf) == null){
            Cliente novoCliente = new Cliente(nome, cpf, genero, idade);
            listaClientes.add(novoCliente);
            return true;
        }

        return false;
    }

    public boolean removeCliente(String cpf){

         for (int i = 0; i < listaClientes.size(); i++) {
            if (cpf.equals(listaClientes.get(i).getCpf())){
                listaClientes.remove(i);
                return true;
            }
                
        }

  
        return false;
    }

    public String toString(){
        String lista = "Lista de pessoas no bar\n";

        for (int i = 0; i < listaClientes.size(); i++) {
            lista += listaClientes.get(i).toString() + "\n";
        }
        return lista;
    }

    public String numClientes(){
        int clientesNum = listaClientes.size();
        return Integer.toString(clientesNum) + "Clientes no bar";
    }

    public String generoDiff(){
        int nMulheres=0;
        boolean maior=false;
        double percent;
        String result;


        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getGenero().equalsIgnoreCase("mulher")){
                nMulheres++;
            }
        }
            percent= ((double)nMulheres/(double)listaClientes.size())*100;

            

            if (percent<50){
                percent = 100-percent;
                maior=true;
            }

            result = String.format("%.2f", percent);

            if (result == null){
                return "Ninguem no bar!";
            }

            if (maior==false){
                return result + "Dos clientes no bar são mulheres";
            }
            if (maior==true){
                return result + "Dos clientes no bar são homens";
            }

        return "ERR";
    }


    public Cliente validaCpf(String cpf){
        for (int i = 0; i < listaClientes.size(); i++) {
            if (cpf.equals(listaClientes.get(i).getCpf())){
                return listaClientes.get(i);
            }
        }
        return null;
    }
}