package br.com.gfwesllei.library.exceptions;

/**
 * @author weslleiferreira
 * @project library
 */
public class DividePerZeroException extends RuntimeException {

    public DividePerZeroException(String message) {
        super(message);
    }
}
