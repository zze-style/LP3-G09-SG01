package Ejercicio1;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class LeerEntrada {
	private Reader stream;
	
	public LeerEntrada(InputStream fuente) {
		stream = new InputStreamReader(fuente);
	}
	
	public void procesar(char c)
            throws VocalException, NumException, WhiteException, OutputException {

        if ("aeiouAEIOU".indexOf(c) >= 0)
            throw new VocalException(c);
        else if (Character.isDigit(c))
            throw new NumException(c);
        else if (Character.isWhitespace(c))
            throw new WhiteException();
        else if (c == 'x' || c == 'X')
            throw new OutputException();
    }
	
	public char getChar() throws IOException{
		return (char) this.stream.read();
	}
}
