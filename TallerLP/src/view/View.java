package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Features;

public class View {

	private Scanner sc = new Scanner(System.in);
    private Features features;
	
	public View() {
		features = new Features();
	}
	
	public int readOptionMenu()  {
		
        showMessage("Bienvenido! \n" +
                "¿Que desea hacer con la cadena? Selecione una opcion. \n"+
                "[1] Convertirla a nombre propio.\n"+
                "[2] Buscar cadena.\n"+
                "[3] Contar Vocales.\n"+
                "[4] Año Nuevo.\n"+
                "[5] Llenar caracteres.\n"+
                "[6] Borrar caracteres.\n"+
                "[7] Interseccion.\n"+
                "[8] Borrar caracteres Izquierda o Derecha\r\n" +
                "[9] Validar direccion de correo.\n"+
                "[10] Salir.");
        int option = Integer.parseInt( sc.nextLine() );
        if ( option < 1 || option > 10 ) {
            showMessageErr("Digito invalido");
        }
        return option;
    }
	
	public void showMessage(String message) {
        System.out.println(message);
    }
	
	public void showMessageErr(String message) {
        System.err.println(message);
    }
	
	public int readInt(String message) {
        System.out.println(message);
        return Integer.parseInt((sc.nextLine()));
    }
	
	public String readString(String message) {
        System.out.println(message);
        return sc.nextLine();
    }
	
	public Character readChar(String message) {
        System.out.println(message);
        return sc.nextLine().charAt(0);
    }
	
	public String selecDirection(String message) {
        int option = 0;
        System.out.println(message);
        System.out.println("[1] Derecha");
        System.out.println("[2] Izquierda");
        option = Integer.parseInt( sc.nextLine() );
        if (option < 1 || option > 2) {
            showMessageErr("Opcion invalida");
        }

        return option == 1 ? "Derecha" : "Izquierda";
    }
	
	public void readArr(ArrayList<String> sentence) {
        sentence.forEach(phrase -> System.out.print(phrase));
        System.out.println();
    }
	
	public void showCheckEmail(boolean isTrue) {
        System.out.println( isTrue ? "Direccion de correo VALIDA" : "Direccion de correo INVALIDA");
    }
	
	public void menu() {
        boolean check = true;

        while ( check ) {
            int option = 0;
            try {
                option = readOptionMenu();
            } catch (Exception e) {
               showMessageErr("Dato no valido");
            }
            switch ( option ) {
                case 1:
                    showMessage( features.convertirNombrePropio(readString("Escriba la cadena")) );
                    break;
                case 2:
                    showMessage("La cadena esta " + features.BuscarCadena( readString("Escriba la cadena principal"), readString("Escriba la cadena a buscar")) + " veces");
                    break;
                case 3:
                    showMessage( features.ContarVocales(readString("Escriba la cadena a buscar")));
                    break;
                case 4:
                    showMessage( features.AñoNuevo() );
                    break;
                case 5:
                    char character = readChar("Digite el caracter que desea añadir");
                    int number = readInt("Digite el numero de veces que se va repetir el caracter");
                    String direction = selecDirection("Selecione la direccion que desea");
                    String ms=readString("Escriba la cadena a buscar");
                    showMessage( features.LLenarCaracteres(ms, character, number, direction) );
                    break;
                case 6:
                    showMessage( features.BorrarCaracter(readString("Escriba la cadena a buscar"), readChar("Digite el caracter que desea borrar")));
                    break;
                case 7:
                    showMessage( features.interseccion(readString("Escriba la cadena a buscar"), readString("Digite la cadena")));
                    break;
                case 8:
                    readArr( features.EliminarCaracteres(readString("Escriba la cadena a buscar"), readString("Digite una cadena"), selecDirection("Seleccione una direccion")) );
                    break;
                case 9:
                    showCheckEmail( features.ValidarCorreo(readString("Digite direccion de correo")));
                    break;
                case 10:
                    showMessage("Cerrando programa...");
                    check = false;
                    break;
            }
        }
	}
	
}
