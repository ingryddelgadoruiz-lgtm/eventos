package EVentos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase EventosMouse: Demuestra cómo implementar MouseListener mediante una clase anónima
 * y utilizar getSource() para diferenciar el origen del evento del mouse.
 */
public class EventosMouse extends JFrame {

    public EventosMouse() {
        // Inicialización y posicionamiento de la etiqueta de saludo
        JLabel lblSaludo = new JLabel();
        lblSaludo.setBounds(25, 10, 350, 30);
        
        // Etiqueta de instrucción visual
        JLabel lblInstruccion = new JLabel("Ingresa tu nombre: ");
        lblInstruccion.setBounds(25, 165, 200, 30);
        
        // Campo de texto donde el usuario puede interactuar
        JTextField campoSaludo = new JTextField(200);
        campoSaludo.setBounds(25, 200, 200, 30);
        
        // Botón principal de acción
        JButton boton = new JButton("¡Saludar!");
        boton.setBounds(25, 235, 150, 30);

        // Creación de una clase anónima para implementar la interfaz MouseListener
        MouseListener listener = new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Se ejecuta cuando se presiona físicamente cualquier botón del mouse
                lblSaludo.setText("mousePressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Se ejecuta cuando se libera el botón del mouse
                lblSaludo.setText("mouseReleased");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // Se ejecuta cuando el cursor del mouse entra en los límites del componente
                lblSaludo.setText("mouseEntered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Se ejecuta cuando el cursor sale de los límites del componente
                lblSaludo.setText("mouseExited");
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // Se ejecuta al completar un clic (presionar y soltar)
                // Usamos e.getSource() para identificar exactamente qué componente originó el evento[cite: 15]
                if (e.getSource() == campoSaludo) {
                    lblSaludo.setText("MouseClicked dentro de campo saludo");
                }
                if (e.getSource() == boton) {
                    lblSaludo.setText("MouseClicked dentro de boton");
                }
            }
        };

        // Agregar el listener creado tanto al botón como al campo de texto[cite: 16]
        boton.addMouseListener(listener);
        campoSaludo.addMouseListener(listener);

        // Agregar los componentes gráficos al contenedor JFrame
        add(lblSaludo);
        add(lblInstruccion);
        add(campoSaludo);
        add(boton);
        
        // Configuración de la ventana principal
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Instanciación de la clase para ejecutar la aplicación
        EventosMouse objEventoMouse = new EventosMouse();
    }
}