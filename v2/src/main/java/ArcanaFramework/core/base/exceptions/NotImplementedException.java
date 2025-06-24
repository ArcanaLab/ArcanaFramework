package ArcanaFramework.core.base.exceptions;

/**
 * Excepción lanzada cuando un método no ha sido implementado.
 * 
 * <p>Esta excepción se utiliza para indicar que un método abstracto
 * o una funcionalidad requerida no ha sido implementada aún.</p>
 * 
 * @author ArcanaFramework
 * @version 2.0
 * @since 1.0
 */
public class NotImplementedException extends RuntimeException {
    
    /**
     * Constructor por defecto.
     */
    public NotImplementedException() {
        super("Método no implementado");
    }
    
    /**
     * Constructor con mensaje personalizado.
     * 
     * @param message El mensaje de la excepción
     */
    public NotImplementedException(String message) {
        super(message);
    }
    
    /**
     * Constructor con mensaje y causa.
     * 
     * @param message El mensaje de la excepción
     * @param cause La causa de la excepción
     */
    public NotImplementedException(String message, Throwable cause) {
        super(message, cause);
    }
} 