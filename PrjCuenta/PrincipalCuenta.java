import java.util.Scanner;
import java.lang.String;
public class PrincipalCuenta{
    public static void main(String args){    
        String opcion = "";
        Scanner scan = new Scanner(System.in);
        do{
            mostrarMenu();
            opcion = "10";
            
            
        
        }while(opcion != "10");
    }
    private static void mostrarMenu(){
        System.out.println("====Menu====\n");
        System.out.print("1. Crear cuenta\n2. Conocer la cantidad cuentas creadas\n3. Listar cuentas\n");
        System.out.print("4. Seleccionar cuenta actual\n5. Asignar nombre de la cuenta habiente\n");
        System.out.print("6. Depositar\n7.Retirar\n8.Consultar saldo\n9. Consultar estado de cuenta\n10.Salir\n");
        System.out.println("Opcion: ");
    }

    
}
