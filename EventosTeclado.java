package EVentos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * Clase EventosTeclado: Implementa KeyListener para capturar interacciones del teclado
 * y comprobar códigos de teclas específicos (como KeyEvent.VK_ENTER o KeyEvent.VK_F1).
 */
public class EventosTeclado extends JFrame {

    public EventosTeclado() {
        JLabel lblSaludo = new JLabel();
        lblSaludo.setBounds(25, 10, 350, 30);
        
        JLabel lblInstruccion = new JLabel("Ingresa tu nombre: ");
        lblInstruccion.setBounds(25, 165, 200, 30);
        
        JTextField campoSaludo = new JTextField(200);
        campoSaludo.setBounds(25, 200, 200, 30);
        
        JButton boton = new JButton("¡Saludar!");
        boton.setBounds(25, 235, 150, 30);

        // Generamos el objeto listener para detectar eventos del teclado con una clase anónima[cite: 24]
        KeyListener keyL = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent event) {
                // Se dispara cuando se introduce un carácter válido de texto (Unicode)
                System.out.println("keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent event) {
                // Se dispara al presionar físicamente cualquier tecla del teclado[cite: 24]
                System.out.println("keyPressed");

                // Evaluamos códigos estáticos de la clase KeyEvent para teclas especiales o de función
                if (event.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("Has presionado enter");
                }
                if (event.getKeyCode() == KeyEvent.VK_F1) {
                    System.out.println("Has presionado la tecla F1");
                }
                
                // Las teclas alfanuméricas también se pueden comprobar en keyPressed mediante su VK correspondiente[cite: 25]
                if (event.getKeyCode() == KeyEvent.VK_A) {
                    System.out.println("Has presionado la tecla a");
                }
            }

            @Override
            public void keyReleased(KeyEvent event) {
                // Se dispara cuando el usuario suelta la tecla presionada
                System.out.println("keyReleased");
            }
        };

        // Agregar el KeyListener exclusivamente al componente campoSaludo[cite: 25]
        campoSaludo.addKeyListener(keyL);

        // Agregar los elementos gráficos a la ventana principal
        add(lblSaludo);
        add(lblInstruccion);
        add(campoSaludo);
        add(boton);
        
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        EventosTeclado objEventosTeclado = new EventosTeclado();
    }
}