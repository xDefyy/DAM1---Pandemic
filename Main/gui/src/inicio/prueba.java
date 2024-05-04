package inicio;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.BasicButtonUI;

import CargaDatos.controlDatos;
import controladores.controlPartida;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Flow;


public class prueba {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	JFrame iniciarPartida = new JFrame();
        	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            JPanel panelgeneral = new JPanel(new FlowLayout(10,10,10)) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // Dibuja la imagen de fondo
                    ImageIcon iconoFondo = new ImageIcon("src\\img\\nuevaPartida\\fondo.jpg");
                    Image imagenFondo = iconoFondo.getImage();
                    g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
                }
            };
            
            Border EmptyBorder = new EmptyBorder(25,25,25,25);
            
            ImageIcon mundoFacil = new ImageIcon("src\\img\\nuevaPartida\\facil.gif");  //115 px y 300fps
            Image mundoFaciles = mundoFacil.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
            ImageIcon facil = new ImageIcon(mundoFaciles);
            
            ImageIcon mundoNormal = new ImageIcon("src\\img\\nuevaPartida\\normal.gif");
            Image mundoNormales = mundoNormal.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
            ImageIcon normal = new ImageIcon(mundoNormales);
            
            ImageIcon mundoDificil = new ImageIcon("src\\img\\nuevaPartida\\dificil.gif");
            Image mundoDificiles = mundoDificil.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
            ImageIcon dificil = new ImageIcon(mundoDificiles);
            
            ImageIcon imgFacil = new ImageIcon("src\\img\\nuevaPartida\\imgFacil.png");  //115 px y 300fps
            Image imgEs = imgFacil.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            ImageIcon mundoimgFacil = new ImageIcon(imgEs);
            
            ImageIcon imgNormal = new ImageIcon("src\\img\\nuevaPartida\\imgNormal.png");  //115 px y 300fps
            Image imgNormales = imgNormal.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            ImageIcon mundoimgNormal = new ImageIcon(imgNormales);
            
            ImageIcon imgDificil = new ImageIcon("src\\img\\nuevaPartida\\imgDificil.png");  //115 px y 300fps
            Image imgdificiles = imgDificil.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            ImageIcon mundoimgdificil = new ImageIcon(imgdificiles);
            
            ImageIcon imgNormalOP = new ImageIcon("src\\img\\nuevaPartida\\imgNormalOP.png");  //115 px y 300fps
            Image imgNormalesOP = imgNormalOP.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            ImageIcon mundoimgNormalOP = new ImageIcon(imgNormalesOP);
            
            ImageIcon imgDificilOP = new ImageIcon("src\\img\\nuevaPartida\\imgDificilOP.png");  //115 px y 300fps
            Image imgdificilesOP = imgDificilOP.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            ImageIcon mundoimgdificilOP = new ImageIcon(imgdificilesOP);
            
            ImageIcon iconoIcono = new ImageIcon("src\\img\\main\\icono.png");
            Image imagenIcono = iconoIcono.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
            ImageIcon imgFinalIcono = new ImageIcon(imagenIcono);
            
            JPanel easyGeneral = new JPanel(new GridBagLayout()){
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // Dibuja la imagen de fondo
                    ImageIcon iconoFondo = new ImageIcon("src\\img\\nuevaPartida\\marcoFacil.jpg");
                    Image imagenFondo = iconoFondo.getImage();
                    g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
                }
            }; 
            easyGeneral.setBorder(new LineBorder(Color.LIGHT_GRAY, 10, false));
            easyGeneral.setPreferredSize(new Dimension (screen.width/3, screen.height-70));
            easyGeneral.setOpaque(false);
            
            GridBagConstraints gbcEasy = new GridBagConstraints();
            
            gbcEasy.gridx = 0;
            gbcEasy.gridy = 0;
            
            Dimension mundo = new Dimension(450,450);
            //agregar mundo
            JPanel mundoEz = new JPanel();
            mundoEz.setOpaque(false);
            mundoEz.setPreferredSize(mundo);
            JLabel mundoIcon = new JLabel(facil);
            mundoEz.add(mundoIcon);
            	
            easyGeneral.add(mundoEz,gbcEasy);
            
            //agregar layout de dificultad
            gbcEasy.gridy = 1;
            
            JPanel dificultadEz =  new JPanel(new GridBagLayout());
            
            GridBagConstraints gbcEasyAbajo = new GridBagConstraints();
            
            gbcEasyAbajo.gridx = 0;
            gbcEasyAbajo.gridy = 0;
            
            dificultadEz.setPreferredSize(new Dimension(screen.width/3-20, 450));
            dificultadEz.setOpaque(true);
            dificultadEz.setBackground(new Color(0,0,0,128));
            dificultadEz.setBorder(new EtchedBorder(EtchedBorder.RAISED));
            
            JPanel dificultad = new JPanel(new FlowLayout());
            dificultad.setOpaque(false);
            
            
            JLabel dificultadIm = new JLabel("Dificultad - ");
            dificultadIm.setFont(fuente());
            dificultadIm.setForeground(new Color(79,164,184));
            dificultad.add(dificultadIm);

            JLabel mundoF = new JLabel(mundoimgFacil);
            dificultad.add(mundoF);
            
            JLabel mundoN = new JLabel(mundoimgNormalOP);
            dificultad.add(mundoN);
            
            JLabel mundoD = new JLabel(mundoimgdificilOP);
            dificultad.add(mundoD);
            
            dificultadEz.add(dificultad, gbcEasyAbajo);
            
            gbcEasyAbajo.gridy = 1;
            
            JPanel descFacil = new JPanel(new FlowLayout());
            descFacil.setOpaque(false);
            
            JLabel textofacil = new JLabel();
            textofacil.setForeground(Color.white);
            textofacil.setFont(fuenteTexto());
            textofacil.setText("Bienvenido al modo");
            descFacil.add(textofacil);
            
            JLabel textofacil2 = new JLabel();
            textofacil2.setForeground(new Color(79,164,184));
            textofacil2.setFont(fuenteTexto());
            textofacil2.setText("Chupete");
            
            
            descFacil.add(textofacil2);
            
            dificultadEz.add(descFacil, gbcEasyAbajo);

            gbcEasyAbajo.gridy = 2;
            gbcEasyAbajo.fill = GridBagConstraints.BOTH; // Expande vertical y horizontalmente
            gbcEasyAbajo.weightx = 1.0; // Peso horizontal (para expandirse horizontalmente)
            gbcEasyAbajo.weighty = 1.0; // Peso vertical (para expandirse verticalmente)
            
           
            
            JLabel desc = new JLabel();
            FontMetrics metrics = desc.getFontMetrics(fuenteTextoDesc());
            int textocupado = metrics.getHeight() + screen.height/6;
            String pixel = textocupado + "px";
            desc.setPreferredSize(mundo);
            desc.setText("<html><div style='text-align: center; margin-left: 32px; margin-right: 10px; padding-bottom:" + pixel + ";'><br><br>Aquí, las epidemias se manejan con<br><br> facilidad y los desafíos son<br><br> prácticamente inexistentes. ¡Relájate<br><br> mientras te paseas por el jardín de<br><br> infancia del juego salvando vidas...");
            desc.setForeground(Color.white);
            desc.setOpaque(false);
            desc.setFont(fuenteTextoDesc());
            
            
            dificultadEz.add(desc, gbcEasyAbajo);
            
            easyGeneral.add(dificultadEz, gbcEasy);
            
            JButton bFacil = new JButton("JUGAR");
            bFacil.setPreferredSize(new Dimension(screen.width/3-20, 90));
            bFacil.setOpaque(true);
            bFacil.setBorder(new LineBorder(Color.white));
            bFacil.setBackground(Color.gray);
            bFacil.setFont(fuente());
            bFacil.setContentAreaFilled(true);
            bFacil.setBorderPainted(true);
            bFacil.setFocusPainted(false);
            bFacil.setForeground(new Color(79,164,184));
            bFacil.setUI(new BasicButtonUI() {
                @Override
                protected void paintButtonPressed(Graphics g, AbstractButton b) {
                    // No hace nada para evitar el cambio de color al presionar
                }
            });
            
            bFacil.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                	bFacil.setForeground(new Color(79,164,255));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                	bFacil.setForeground(new Color(79,164,184));
                }
            });
            gbcEasy.gridy++;
            easyGeneral.add(bFacil,gbcEasy);
            
            panelgeneral.add(easyGeneral);
            
            JPanel normalGeneral = new JPanel(new GridBagLayout()){
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // Dibuja la imagen de fondo
                    ImageIcon iconoFondo = new ImageIcon("src\\img\\nuevaPartida\\marcoNormal.jpeg");
                    Image imagenFondo = iconoFondo.getImage();
                    g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
                }
            }; 
            normalGeneral.setBorder(new LineBorder(Color.LIGHT_GRAY, 10, false));
            normalGeneral.setPreferredSize(new Dimension (screen.width/3, screen.height-70));
            normalGeneral.setOpaque(false);
            
            GridBagConstraints gbcNormal = new GridBagConstraints();
            
            gbcNormal.gridx = 0;
            gbcNormal.gridy = 0;
            
            Dimension mundo2 = new Dimension(450,450);
            //agregar mundo
            JPanel mundoNor = new JPanel();
            mundoNor.setOpaque(false);
            mundoNor.setPreferredSize(mundo2);
            JLabel normalIcon = new JLabel(normal);
            mundoNor.add(normalIcon);
            	
            normalGeneral.add(mundoNor,gbcNormal);
            
            //agregar layout de dificultad
            gbcNormal.gridy = 1;
            
            JPanel dificultadNormal =  new JPanel(new GridBagLayout());
            
            GridBagConstraints gbcNormalAbajo = new GridBagConstraints();
            
            gbcNormalAbajo.gridx = 0;
            gbcNormalAbajo.gridy = 0;
            
            dificultadNormal.setPreferredSize(new Dimension(screen.width/3-20, 450));
            dificultadNormal.setOpaque(true);
            dificultadNormal.setBackground(new Color(0,0,0,128));
            dificultadNormal.setBorder(new EtchedBorder(EtchedBorder.RAISED));
            
            JPanel dificultad2 = new JPanel(new FlowLayout());
            dificultad2.setOpaque(false);
            
            
            JLabel dificultadIm2 = new JLabel("Dificultad - ");
            dificultadIm2.setFont(fuente());
            dificultadIm2.setForeground(new Color(79,164,184));
            dificultad2.add(dificultadIm2);

            JLabel mundoF2 = new JLabel(mundoimgFacil);
            dificultad2.add(mundoF2);
            
            JLabel mundoN2 = new JLabel(mundoimgNormal);
            dificultad2.add(mundoN2);
            
            JLabel mundoD2 = new JLabel(mundoimgdificilOP);
            dificultad2.add(mundoD2);
            
            dificultadNormal.add(dificultad2, gbcNormalAbajo);
            
            gbcNormalAbajo.gridy = 1;
            
            JPanel descNormal = new JPanel(new FlowLayout());
            descNormal.setOpaque(false);
            
            JLabel textonormal = new JLabel();
            textonormal.setForeground(Color.white);
            textonormal.setFont(fuenteTexto());
            textonormal.setText("Bienvenido al modo");
            descNormal.add(textonormal);
            
            JLabel textonormal2 = new JLabel();
            textonormal2.setForeground(new Color(79,164,184));
            textonormal2.setFont(fuenteTexto());
            textonormal2.setText("Chupete");
            
            
            descNormal.add(textonormal2);
            
            dificultadNormal.add(descNormal, gbcNormalAbajo);

            gbcNormalAbajo.gridy = 2;
            gbcNormalAbajo.fill = GridBagConstraints.BOTH; // Expande vertical y horizontalmente
            gbcNormalAbajo.weightx = 1.0; // Peso horizontal (para expandirse horizontalmente)
            gbcNormalAbajo.weighty = 1.0; // Peso vertical (para expandirse verticalmente)
            
           
            
            JLabel desc2 = new JLabel();
            FontMetrics metrics2 = desc2.getFontMetrics(fuenteTextoDesc());
            int textocupado2 = metrics2.getHeight() + screen.height/6;
            String pixel2 = textocupado2 + "px";
            desc2.setPreferredSize(mundo2);
            desc2.setText("<html><div style='text-align: center; margin-left: 32px; margin-right: 10px; padding-bottom:" + pixel2 + ";'><br><br>Aquí, las epidemias se manejan con<br><br> facilidad y los desafíos son<br><br> prácticamente inexistentes. ¡Relájate<br><br> mientras te paseas por el jardín de<br><br> infancia del juego salvando vidas...");
            desc2.setForeground(Color.white);
            desc2.setOpaque(false);
            desc2.setFont(fuenteTextoDesc());
            
            
            dificultadNormal.add(desc2, gbcNormalAbajo);
            
            normalGeneral.add(dificultadNormal, gbcNormal);
            
            JButton bNormal = new JButton("JUGAR");
            bNormal.setPreferredSize(new Dimension(screen.width/3-20, 90));
            bNormal.setOpaque(true);
            bNormal.setBorder(new LineBorder(Color.white));
            bNormal.setBackground(Color.gray);
            bNormal.setFont(fuente());
            bNormal.setContentAreaFilled(true);
            bNormal.setBorderPainted(true);
            bNormal.setFocusPainted(false);
            bNormal.setForeground(new Color(79,164,184));
            bNormal.setUI(new BasicButtonUI() {
                @Override
                protected void paintButtonPressed(Graphics g, AbstractButton b) {
                    // No hace nada para evitar el cambio de color al presionar
                }
            });
            
            bNormal.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                	bNormal.setForeground(new Color(79,164,255));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                	bNormal.setForeground(new Color(79,164,184));
                }
            });
            gbcNormal.gridy++;
            normalGeneral.add(bNormal,gbcNormal);
            
            panelgeneral.add(normalGeneral);
            

            
            
            JButton volver = new JButton("VOLVER");
    	      volver.setPreferredSize(new Dimension(150,50));
    	      volver.setBackground(new Color(0,0,0,0));
    	      volver.setOpaque(false);
    	      volver.setContentAreaFilled(false);
    	      volver.setBorderPainted(false);
    	      volver.setFocusPainted(false);
    	      volver.setFont(new Font("Arial", Font.BOLD, 20));
    	      volver.setForeground(new Color(137,5,78));
    	      volver.setPreferredSize(new Dimension(screen.width,50));
    	      volver.addMouseListener(new MouseAdapter() {
    	            @Override
    	            public void mouseEntered(MouseEvent e) {
    	            	volver.setForeground(new Color(200,5,78));
    	            }

    	            @Override
    	            public void mouseExited(MouseEvent e) {
    	            	volver.setForeground(new Color(137,5,78));
    	            }
    	        });
    	      volver.addActionListener(new ActionListener() {
    	    	    public void actionPerformed(ActionEvent e) {
    	    	    	Main.cargarPrincipal.setVisible(true);
    	    	        Timer timer = new Timer(300, new ActionListener() {
    	    	            public void actionPerformed(ActionEvent e) {
    	    	                Main.cargarParty.setVisible(false);
    	    	            }
    	    	        });
    	    	        timer.setRepeats(false);
    	    	        timer.start();
    	    	    }
    	    	});	
    	      
    	      JPanel botonVolver = new JPanel();
    	      botonVolver.setBackground(Color.black);
    	      botonVolver.add(volver);
    	      
    	    iniciarPartida.add(botonVolver, BorderLayout.SOUTH);
            
    	    iniciarPartida.getContentPane().add(panelgeneral, BorderLayout.CENTER);

    	    iniciarPartida.setSize(screen.width, screen.height);
    	    iniciarPartida.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    iniciarPartida.setLocationRelativeTo(null); // siempre centro
    	    iniciarPartida.setResizable(false); // no se puede ajustar
    	    iniciarPartida.setExtendedState(JFrame.MAXIMIZED_BOTH); // pantalla completa
    	    iniciarPartida.setUndecorated(true); // quita la barra de arriba
    	    iniciarPartida.setVisible(true);
    	    iniciarPartida.setTitle("Pandemic @Kader, @Liqi");
    	    iniciarPartida.setIconImage(imgFinalIcono.getImage());
        });
    }
    private static Font fuente() {
		try {
        	File fuente = new File("src\\fuente\\fuenteTitulo.ttf");
            
            Font font = Font.createFont(Font.TRUETYPE_FONT, fuente);
            
            // Tamaño de la fuente (en puntos)
            float fontSize = 25;
            
            font = font.deriveFont(fontSize);
            return font;

        } catch (IOException | FontFormatException e) {
        	Font defaultFont = new Font("Arial", Font.PLAIN, 30);
            e.printStackTrace();
            return defaultFont;
        }
	}
    private static Font fuenteTexto() {
		try {
        	File fuente = new File("src\\fuente\\fuenteTexto.ttf");
            
            Font font = Font.createFont(Font.TRUETYPE_FONT, fuente);
            
            // Tamaño de la fuente (en puntos)
            float fontSize = 15;
            
            font = font.deriveFont(fontSize);
            return font;

        } catch (IOException | FontFormatException e) {
        	Font defaultFont = new Font("Arial", Font.PLAIN, 15);
            e.printStackTrace();
            return defaultFont;
        }
	}
    private static Font fuenteTextoDesc() {
		try {
        	File fuente = new File("src\\fuente\\fuenteTexto.ttf");
            
            Font font = Font.createFont(Font.TRUETYPE_FONT, fuente);
            
            // Tamaño de la fuente (en puntos)
            float fontSize = 13.5f;
            
            font = font.deriveFont(fontSize);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
            return font;

        } catch (IOException | FontFormatException e) {
        	Font defaultFont = new Font("Arial", Font.PLAIN, 15);
            e.printStackTrace();
            return defaultFont;
        }
	}
    
    
    public static void lol () {
    	JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBorder(new LineBorder(Color.white, 5, true));
        JLabel label1 = new JLabel("<html><div style='text-align: center; padding-top: 20px; font-size: 18px;'>¡");
        label1.setForeground(new Color(137,5,78));
        
        panel1.setOpaque(false);
        panel1.add(label1, BorderLayout.NORTH); // Cambié panel1 a label1

        label1.setHorizontalAlignment(SwingConstants.CENTER); // Establezco la alineación en label1

        
        
        
        
        JPanel panel2 = new JPanel(new BorderLayout());
        JLabel label2 = new JLabel("<html><div style='text-align: center; padding-top: 20px; font-size: 18px;'>Enfréntate a la pandemia como un adulto decente. Este modo es para aquellos que necesitan un poco de emoción en sus vidas, pero aún así no quieren demasiado estrés. Vamos, ¡ponte los pantalones grandes y afronta el desafío!");
        label2.setForeground(new Color(137,5,78));
        JButton button2 = new JButton("JUGAR");
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.setBorderPainted(false);
        button2.setFocusPainted(false);
        button2.setForeground(new Color(137,5,78));
        panel2.setOpaque(false);
        panel2.add(label2, BorderLayout.NORTH);
        panel2.add(button2, BorderLayout.CENTER);

        
        JPanel panel3 = new JPanel(new BorderLayout());
        JLabel label3 = new JLabel("<html><div style='text-align: center; padding-top: 20px; font-size: 18px;'>¿Crees que eres lo suficientemente rudo para este juego? Bienvenido al modo Patea-Traseros, donde cada decisión puede ser tu última. Si quieres jugar con los grandes, prepárate para sufrir, ¡porque aquí solo los más duros sobreviven!");
        label3.setForeground(new Color(137,5,78));
        JButton button3 = new JButton("JUGAR");
        button3.setOpaque(false);
        button3.setContentAreaFilled(false);
        button3.setBorderPainted(false);
        button3.setFocusPainted(false);
        button3.setForeground(new Color(137,5,78));
        panel3.add(label3, BorderLayout.NORTH);
        panel3.add(button3, BorderLayout.CENTER);
        panel3.setOpaque(false);
        label3.setHorizontalAlignment(JLabel.CENTER);

        
    }
}