package EVentos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseMotionListener;

/**
 * Clase EventosMouseRueda: Combina MouseListener, MouseWheelListener (para el scroll de la rueda)
 * y MouseMotionListener (para rastrear el movimiento y arrastre del cursor en coordenadas X e Y).
 */
public class EventosMouseRueda extends JFrame {

    public EventosMouseRueda() {
        JLabel lblSaludo = new JLabel();
        lblSaludo.setBounds(25, 10, 350, 30);
        
        JLabel lblInstruccion = new JLabel("Ingresa tu nombre: ");
        lblInstruccion.setBounds(25, 165, 200, 30);
        
        JTextField campoSaludo = new JTextField(200);
        campoSaludo.setBounds(25, 200, 200, 30);
        
        JButton boton = new JButton("¡Saludar!");
        boton.setBounds(25, 235, 150, 30);

        // Listener estándar para clics y modificadores
        MouseListener listener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.isAltDown()) {
                    lblSaludo.setText("clic + alt");
                } else if (e.isControlDown()) {
                    lblSaludo.setText("clic + Control");
                } else if (e.isShiftDown()) {
                    lblSaludo.setText("clic + Shift");
                } else if (e.isMetaDown()) {
                    lblSaludo.setText("clic derecho");
                } else {
                    lblSaludo.setText("clic izquierdo");
                }
                if (e.getClickCount() == 2) {
                    lblSaludo.setText("doble clic");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };

        // Listener específico para los eventos de giro de la rueda del mouse[cite: 21]
        MouseWheelListener wheel = new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                System.out.println("mouse wheel");
                // getPreciseWheelRotation() devuelve -1 si gira hacia arriba y 1 si gira hacia abajo[cite: 21]
                if (e.getPreciseWheelRotation() == -1) {
                    System.out.println("rueda hacia arriba");
                }
                if (e.getPreciseWheelRotation() == 1) {
                    System.out.println("rueda hacia abajo");
                }
            }
        };

        // Listener para el movimiento y arrastre del puntero del mouse[cite: 21, 22]
        MouseMotionListener motionListener = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Se ejecuta al mover el mouse manteniendo presionado algún botón
                System.out.println("dragged - x: " + e.getX() + ", y: " + e.getY());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // Se ejecuta al mover libremente el cursor por el componente
                System.out.println("moved - x: " + e.getX() + ", y: " + e.getY());
            }
        };

        // Vincular los listeners a sus componentes correspondientes[cite: 22, 23]
        boton.addMouseListener(listener);
        campoSaludo.addMouseListener(listener);
        campoSaludo.addMouseWheelListener(wheel);
        this.addMouseMotionListener(motionListener); // Escucha el movimiento general en el JFrame

        // Agregar los componentes a la interfaz
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
        EventosMouseRueda objEventoMouse = new EventosMouseRueda();
    }
}