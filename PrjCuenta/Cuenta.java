import java.time.LocalDateTime;

public class Cuenta{
    private String codCuenta = "cta-";
    private double saldo;
    private String nombreCuentaHabiente;
    
    private String fechaCreacion; //Particular
    
    private int cantDepositosRealizados;
    private int cantRetirosExitososRealizados;
    private static int cantCuentasCreadas;
    
    public Cuenta(String nombreCuentaHabiente, double pSaldo){
        this(pSaldo);
        setNombreCuentaHabiente(nombreCuentaHabiente);
    }
    public Cuenta(double pSaldo){
        saldo = pSaldo;
        cantDepositosRealizados = 0;
        cantRetirosExitososRealizados = 0;
        
        //Creacion y asignacion de fecha de creacion
        LocalDateTime fecha = LocalDateTime.now();
        String fechaString = fecha.toString();
        
        fechaCreacion = fechaString;
        cantCuentasCreadas ++;
    }
    public void setNombreCuentaHabiente(String pNombreCuentaHabiente){
        nombreCuentaHabiente = pNombreCuentaHabiente;
    }
    public String getCodCuenta(){
        return codCuenta;
    }
    public double getSaldo(){
        return saldo;
    }
    public double depositar(double monto){
        //Validacion para evitar que el monto genere reducciones en el monto
        if (monto > 0){
            saldo += monto;
            cantDepositosRealizados ++;
        }
        return saldo;
    }
    public double retirar(double monto){
        if (validarRetiro(monto)){
            saldo -= monto;
            cantRetirosExitososRealizados ++;
        }
        return saldo;
    }
    public static int getCantCuentasCreadas(){
        return cantCuentasCreadas;
    }
    public String toString(){
        String estado = "";
        estado += "Nombre cuenta habiente: " + nombreCuentaHabiente + "\n";
        estado += "Codigo cuenta: " + codCuenta + "\n";
        estado += "Depositos Realizados: " + cantDepositosRealizados + "\n";
        estado += "Retiros Exitosos: " + cantRetirosExitososRealizados + "\n";
        estado += "Fecha de creacion: " + fechaCreacion + "\n\n";
        estado += "Saldo Actual: " + saldo + "\n";
        
        return estado;
    }
    
    private boolean validarRetiro(double monto){
        return (monto > 0) && (monto <= saldo);
    }
    
}