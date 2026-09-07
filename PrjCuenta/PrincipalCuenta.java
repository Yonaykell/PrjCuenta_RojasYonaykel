import java.util.Scanner;
import java.util.ArrayList;
public class PrincipalCuenta{
    private static ArrayList<Cuenta> listaCuentas;
    public static void main(String[] args){    
        int opcion = 0;
        Scanner scan = new Scanner(System.in);
        do{
            mostrarMenu();
            try{
                opcion = scan.nextInt();
                if(opcion != 10){
                    switchCase(opcion);
                }
            }
            catch(Exception error){
                System.out.println("Debes digitar un numero entero");
            }
            
        }while(opcion != 10);
        scan.close();
        System.out.println("Fin del programa");
    }
    private static void mostrarMenu(){
        System.out.println("====Menu====\n");
        System.out.print("1. Crear cuenta\n2. Conocer la cantidad cuentas creadas\n3. Listar cuentas\n");
        System.out.print("4. Seleccionar cuenta actual\n5. Asignar nombre de la cuenta habiente\n");
        System.out.print("6. Depositar\n7.Retirar\n8.Consultar saldo\n9. Consultar estado de cuenta\n10.Salir\n");
        System.out.println("Opcion: ");
    }
    private static void switchCase(int opcion){
        switch (opcion){
            case 1: 
                crearCuenta();
                break;
            case 2:
                conocerCuentasCreadas();
                break;
            case 3:
                break;
        }
    }
    //Opcion 1
    private static void crearCuenta(){
        double saldo;
        String nombreCuentaHabiente = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("==Crear Cuenta==");
        System.out.print("Saldo incial: ");
        System.out.println("\n");
        try{
            saldo = scan.nextDouble();
        }
        catch(Exception error){
            System.out.println("Se debe de ingresar un valor numerico para el saldo inicial");
            scan.next("Enter para regresar");
            scan.close();
            return;
        }
        System.out.print("Nombre de la cuenta habiente (opcional/enter): ");
        nombreCuentaHabiente = scan.nextLine().trim();
        Cuenta nuevaCuenta;
        
        if (nombreCuentaHabiente.equals("")){
            nuevaCuenta = new Cuenta(saldo);
        }
        else{
            nuevaCuenta = new Cuenta(nombreCuentaHabiente, saldo);
        }
        listaCuentas.add(nuevaCuenta);
        System.out.println("Cuenta creada exitosamente");
        scan.close();
        return;
    } 
    //Opcion 2
    private static void conocerCuentasCreadas(){
        System.out.println("Cuentas creadas:\n" + Cuenta.getCantCuentasCreadas());
    }
    
}
