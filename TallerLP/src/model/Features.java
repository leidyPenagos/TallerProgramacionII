package model;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Features {
    
    public String convertirNombrePropio(String ms) {
        Character c = ' ';
        char[] chars = new char[ms.length()];

        for (int i = 0; i < ms.length(); i++) {
            c = ms.charAt(i);
            if ( (i == 0) || (ms.charAt(i-1) == ' ') ) {
                c = Character.toUpperCase(c);
            }

            chars[i] = c;
        }

        return new String(chars);
    }
    
    public int BuscarCadena(String ms, String input) {
        int cont = 0;
        String[] c = ms.toLowerCase().split(" ");
        for (int i = 0; i < c.length; i++) {
            if ( c[i].equals(input.toLowerCase()) ) {
                cont++;
            }
        }

        return cont;
    }
    
    public String ContarVocales(String ms) {
    	String cadena = ms;
    	int a = 0, e = 0, i = 0, o = 0, u = 0;

    	for (int x = 0; x < cadena.length(); x++) {
    	    char actual = cadena.toLowerCase().charAt(x);

    	    switch (actual) {
    	        case 'a':
    	            a++;
    	            break;
    	        case 'e':
    	            e++;
    	            break;
    	        case 'i':
    	            i++;
    	            break;
    	        case 'o':
    	            o++;
    	            break;
    	        case 'u':
    	            u++;
    	            break;
    	        default:
    	            break;
    	    }
    	}

    	int Numvocales =(a+e+i+o+u);
    	String msj="cantidad de vocales"+ Numvocales;
		return msj;
    	
    }
    
    public String AñoNuevo() {
    	
    	return "";
    }
    
    public String LLenarCaracteres(String ms, char character, int number, String direction){
        String chars = "", aux = "";
        for (int i = 0; i < number; i++) {
            chars += character;
        }
        if ( direction.equals("Derecha") ) {
            aux = ms + chars;
        } else {
            aux = chars + ms;
        }

        return aux;
    }
    
    public String BorrarCaracter(String ms,char character) {
        String aux = "";
        String c = "" + character;
        aux = ms.toLowerCase().replaceAll(c, "").replaceAll(c.toLowerCase(), "");
        return aux;
    }
    
    public String interseccion(String ms, String data) {
        String repeated = "";
        char[] dataChars = data.toCharArray();
        char[] msChars = ms.toCharArray();
        for (int i = 0; i < data.length(); i++) {
            for (int j = 0; j < ms.length(); j++) {
                String aux;
                aux = "" + dataChars[i];
                if (Character.toLowerCase(dataChars[i]) == Character.toLowerCase(msChars[j])) {
                    if (repeated.contains(aux)) {

                    } else {
                        repeated = repeated + dataChars[i];
                    }
                }
            }
        }
        return repeated;
    }
    
  
    
    public ArrayList<String> EliminarCaracteres(String ms,String data, String dir) {
        int con = 0;
        boolean direccion;
        String[] word = data.split("");
        con = word.length;
        String sentenceOne[] = ms.split("");
        String sentenceTwo[] = ms.split("");
        ArrayList<String> arr = new ArrayList<>();
        if ( dir.equals("Derecha") ) {
            direccion=false;
        }else {
            direccion=true;
        }
        if (direccion) {
            for (int i = 0; i < sentenceOne.length; i++) {
                for (int j = 0; j < word.length; j++) {
                    con = word.length;
                    if (sentenceOne[i].toLowerCase().contains(word[j])) {
                        sentenceOne[i]="/";
                    }
                }
                if (i>0) {
                    if (sentenceOne[i-1].contains("/")) {
                    }
                }
            }
            for (int k = 0; k < sentenceOne.length; k++) {
                if (!sentenceOne[k].contains("/")) {
                    con = k;
                    break;
                }
            }
            for (int j = con; j < sentenceTwo.length; j++) {
                arr.add(sentenceTwo[j]);
            }
            return arr;
        } else {
            for (int i = 0; i < sentenceOne.length; i++) {
                for (int j = 0; j < word.length; j++) {
                    con = word.length;
                    if (sentenceOne[i].toLowerCase().contains(word[j])|| sentenceOne[i].contains(" ")) {
                        sentenceOne[i]="/";
                    }
                }
                if (i>0) {
                    if (sentenceOne[i-1].contains("/")) {
                    }
                }
            }
            for (int k = sentenceOne.length-1; k >=0; k--) {
                if (!sentenceOne[k].contains("/")) {
                    con = k;
                    break;
                }
            }
            for (int j = 0; j < con + 1; j++) {
                arr.add(sentenceTwo[j]);
            }
            return arr;
        }
    }
    
    public String ContarPalabras(String ms) {
    	String[] words = ms.split("\\s+");
    	String msj= ""+ words.length;
    	return msj;
    }
    
    public boolean ValidarCorreo(String email) {
        Pattern pat = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mat = pat.matcher(email);
        return mat.matches();
    }

    
    
}
