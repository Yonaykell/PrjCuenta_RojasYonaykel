import java.util.Scanner;
import java.util.ArrayList;

public class PrincipalCuenta{
    private static ArrayList<Cuenta> listaCuentas;
    private static Cuenta cuentaActual;

    public static void main(String[] args){    
        listaCuentas = new ArrayList<>();
        int opcion = 0;
        Scanner scan = new Scanner(System.in);

        do{
            mostrarMenu();
            try{
                opcion = scan.nextInt();
                if(opcion != 10){
                    switchCase(opcion, scan);
                }
            }
            catch(Exception error){
                System.out.println("\nPor favor, procure digitar valores y/o opciones validas\n(Enter)");
                scan.nextLine(); //Aca se limpia la entrada invalida
                scan.nextLine();//Aca se espera a que usuario lea
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

    private static void switchCase(int opcion, Scanner scan){
        //scan.nextLine(); // Limpio la entrada de residuos
        switch (opcion){
            case 1: 
                crearCuenta(scan);
                return;
            case 2:
                conocerCuentasCreadas(scan);
                return;
            case 3:
                listarCuentas(scan);
                return;
            case 4:
                seleccionarCuentaActual(scan);
                return;
            case 5:
                //scan.nextLine();
                asignarNombreCuentaHabiente(scan);
                return;
            case 6:
                depositar(scan);
                return;
            case 7:
                retirar(scan);
                return;
            case 8:
                consultarSaldo(scan);
                return;
            case 9:
                consultarEstadoCuenta(scan);
                return;
        }
    }

    //Opcion 1
    private static void crearCuenta(Scanner scan){
        double saldo;
        String nombreCuentaHabiente = " ";
        System.out.println("==Crear Cuenta==");
        System.out.print("Saldo incial: ");

        try{
            saldo = scan.nextDouble();
            scan.nextLine(); //Esto deberia consumir el enter (\n) que el nextDouble no agarra. NO borrar.
        }
        catch(Exception error){
            System.out.println("Se debe de ingresar un valor numerico para el saldo inicial");
            throw error;
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
        return;
    } 

    //Opcion 2
    private static void conocerCuentasCreadas(Scanner scan){
        System.out.println("Cuentas creadas:\n" + Cuenta.getCantCuentasCreadas());
        System.out.println("Enter para regresar...");
        scan.nextLine();
        return;
    }

    //Opcion 3
    private static void listarCuentas(Scanner scan){
        scan.nextLine(); //limpiar
        if (listaCuentas.size() == 0){
            System.out.println("===============\nNo hay cuentas registradas...");
        }
        else{
            int idCuenta = 0;
            System.out.println("==Estado de las cuentas==");
    
            for (Cuenta cuenta : listaCuentas){
                System.out.println("-----------------------------------");
                System.out.println("Numero de cuenta: " + (idCuenta + 1));
                System.out.println(cuenta.toString());
                System.out.println("-----------------------------------\n//\\\\");
                idCuenta ++;
            }
        }
        System.out.println("Enter para regresar...");
        scan.nextLine();
        return;
    }

    //Opcion 4
    private static void seleccionarCuentaActual(Scanner scan){
        scan.nextLine(); //limpiar
        System.out.print("Por favor, indique el numero de cuenta: ");
        try{
            cuentaActual = listaCuentas.get(scan.nextInt() -1);
            scan.nextLine(); // Limpio
        }
        catch(Exception error){
            System.out.println("El numero de cuenta no existe...");
            throw error;
        }
        System.out.println("\nCuenta seleccionada exitosamente\nEnter para regresar...");
        scan.nextLine(); //Espero enter
        return;
    }
    //Opcion 5
    private static void asignarNombreCuentaHabiente(Scanner scan){
        try{
            cuentaActual.getSaldo();
            scan.nextLine();
            System.out.println("Nombre: ");
            cuentaActual.setNombreCuentaHabiente(scan.nextLine().trim());
        }
        catch(Exception error){
            System.out.println("No hay cuenta seleccionada\nPor favor seleccione una cuenta antes de insertar un nombre");
            throw error;
        }
    
        System.out.println("\nNombre asignado correctamente\nEnter para regresar...");
        scan.nextLine(); // Espero enter
        return;
    }
    //Opcion 6
    private static void depositar(Scanner scan){
        try{
            double saldo = cuentaActual.getSaldo();//Esta linea obtiene saldo y valida que cuentaActual no sea null
            scan.nextLine(); // Limpio
            System.out.println("Saldo previo: " + saldo);
            System.out.println("Digite el mondo: ");
            saldo = cuentaActual.depositar(scan.nextDouble());
            scan.nextLine();//LImpio enter
            System.out.println("Saldo actual: " + saldo);     
        }
        catch(Exception error){
            System.out.println("No hay cuenta seleccionada\nPor favor seleccione una cuenta antes de insertar un nombre");
            throw error;
        }
        System.out.println("\nDeposito realizado exitosamente\nEnter para regresar...");
        scan.nextLine(); // Espero enter
        return;
    }
    //Opcion 7
    private static void retirar(Scanner scan){
        try{
            double saldoP = cuentaActual.getSaldo(); //Esta linea obtiene saldo y valida que cuentaActual no sea null
            scan.nextLine(); // Limpio
            System.out.println("Saldo previo: " + saldoP);
            System.out.println("Digite el mondo: ");
            double saldoA = cuentaActual.retirar(scan.nextDouble());
            scan.nextLine();//LImpio enter
            if (saldoA == saldoP){
                System.out.println("Fondos insuficientes...");
            }
            else{
                System.out.println("Retiro exitoso");
                System.out.println("Saldo actual: " + saldoA);
            }     
        }
        catch(Exception error){
            System.out.println("No hay cuenta seleccionada\nPor favor seleccione una cuenta antes de insertar un nombre");
            throw error;
        }
    
        System.out.println("\nEnter para regresar...");
        scan.nextLine(); // Espero enter
        return;
    }
    //Opcion 8
    private static void consultarSaldo(Scanner scan){
        try{
            double saldo = cuentaActual.getSaldo(); //Esta linea obtiene saldo y valida que cuentaActual no sea null
            System.out.println("Saldo Actual: " + saldo);
        }
        catch(Exception error){
            System.out.println("No hay cuenta seleccionada\nPor favor seleccione una cuenta antes de insertar un nombre");
            throw error;
        }
        System.out.println("\nEnter para regresar...");
        scan.nextLine(); // Limpio
        scan.nextLine(); // Espero enter
        return;        
    }
    //Opcion 9
    private static void consultarEstadoCuenta(Scanner scan){
        System.out.println("\n===Estado Cuenta===");
        try{
            System.out.println(cuentaActual.toString());
        }
        catch(Exception error){
            System.out.println("No hay cuenta seleccionada\nPor favor seleccione una cuenta antes de insertar un nombre");
            throw error;
        }
        System.out.println("\nEnter para regresar...");
        scan.nextLine(); // Limpio
        scan.nextLine(); // Espero enter
        return;   
    }
}