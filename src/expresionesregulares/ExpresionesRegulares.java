package expresionesregulares;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpresionesRegulares {
    public static boolean busca_3a(String cadena){
        String expR = ".[aA].[aA].[aA]";
        Pattern pat = Pattern.compile(expR);
        Matcher mat = pat.matcher(cadena);                                                                                   
        return mat.matches();
    }
    public static boolean validaNumeroEnteroPositivo_Exp(String texto){
        return texto.matches("^[0-9]+$");
    }
    public static boolean validaNumeroEnteroNegativo_Exp(String texto){
        return texto.matches("^-[0-9]+$");
    }
    public static boolean validaNumeroEntero_Exp(String texto){
        return texto.matches("^-?[0-9]+$");
    }
    public static boolean validarMatriculaEuropea_Exp(String matricula) {
        return matricula.matches("^[0-9]{4}[A-Z]{3}$");
    }
    public static boolean validarMatriculaUAC_Exp(String matricula) {
        return matricula.matches("^(al0)[0-9]{5}$");
    }
    public static boolean validaBinario_Exp(String binario){
        return binario.matches("^[0-1]+$");
    }
    public static boolean validarUsuarioTwitter_Exp(String usuario_twitter) {
        return usuario_twitter.matches("^@([A-Za-z0-9_]{1,15})$");
    }
    public static boolean validar_Mail_Exp(String email) {
        return email.matches("^([\\w-]+\\.)?[\\w-]+@[\\w-]+\\.([\\w-]+\\.)?[\\w]+$");
    }
    public static boolean validaDNI_Exp(String DNI){
    return DNI.matches("^[0-9]{8}[T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]$");
    }
    
    public static void main(String[] args) {
        System.out.println("1.- Busca_3a");
        System.out.println(busca_3a("mañana"));
        System.out.println(busca_3a("banana"));
        System.out.println(busca_3a("Esto e"));
        System.out.println(busca_3a("CANADA"));
        System.out.println(busca_3a("Baraja"));
        System.out.println(busca_3a("Campeche"));
        System.out.println(busca_3a("camara"));
        
        System.out.println("\n2.- Validar fecha númerica");
        String regexp = "\\d{1,2}/\\d{1,2}/\\d{4}";
        // Lo siguiente devuelve true
        System.out.println(Pattern.matches(regexp, "11/12/2014" ));
        System.out.println(Pattern.matches(regexp, "1/12/2014" ));
        System.out.println(Pattern.matches(regexp, "11/2/2014" ));
        // Los siguientes devuelven false
        System.out.println(Pattern.matches(regexp, "11/12/14")); // El año no tiene cuatro cifras
        System.out.println(Pattern.matches(regexp, "11//2014")); // el mes no tiene una o dos cifras
        System.out.println(Pattern.matches(regexp, "11/12/14perico")); // Sobra "perico"
        
        
        System.out.println("\n3.- Validar fecha con mes tipo caracter");
        String literalMonthRegexp = "\\d{1,2}/(?i)(ene|feb|mar|abr|may|jun|jul|ago|sep|oct|nov|dic)/\\d{4}";
        
        // Lo siguiente devuelve true
        System.out.println(Pattern.matches(literalMonthRegexp, "11/dic/2014"));
        System.out.println(Pattern.matches(literalMonthRegexp, "1/nov/2014"));
        System.out.println(Pattern.matches(literalMonthRegexp, "1/AGO/2014")); // Mes en mayúsculas
        System.out.println(Pattern.matches(literalMonthRegexp, "21/Oct/2014")); // Primera letra del mes en mayúsculas.
        
        // Los siguientes devuelven false
        System.out.println(Pattern.matches(literalMonthRegexp, "11/abc/2014")); // abc no es un mes
        System.out.println(Pattern.matches(literalMonthRegexp, "11//2014")); // falta el mes
        System.out.println(Pattern.matches(literalMonthRegexp, "11/jul/2014perico")); // sobra perico
        
        System.out.println("\n4.- ValidaNumeroEnteroPositivo_Exp");
        System.out.println(validaNumeroEnteroPositivo_Exp("192"));
        
        System.out.println("\n5.- ValidaNumeroEnteroNegativo_Exp");
        System.out.println(validaNumeroEnteroNegativo_Exp("-0"));
        
        System.out.println("\n6.- ValidaNumeroEntero_Exp");
        System.out.println(validaNumeroEntero_Exp("12"));
        
        System.out.println("\n7.- Validar una matrícula europea 9999AAA y la de la UAC al999999");
        System.out.println(validarMatriculaEuropea_Exp("0102AAA"));
        System.out.println(validarMatriculaUAC_Exp("al056448"));
        
        System.out.println("\n8.- Validar un número binario");
        System.out.println(validaBinario_Exp("1"));
        
        System.out.println("\n9.- Valida un nombre de usuario en twitter, empieza por \n"
                + "@ y puede contener letras mayusculas y minusculas, numeros, guiones \n"
                + "y guiones bajos, de 15 caracteres de longitud.");
        System.out.println(validarUsuarioTwitter_Exp("@DyanItaCL_56448"));
        
        System.out.println("\n10.- Expresión regular para DNI");
        //Validar un DNI
        System.out.println(validaDNI_Exp("01022017D"));
        
        System.out.println("\n11.- Expresión regular para email");
        //Validar un Email
        System.out.println(validar_Mail_Exp("dyanita221298@gmail.com"));
        

    }
}