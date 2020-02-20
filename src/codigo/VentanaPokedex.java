/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 *
 * @author xp
 */
public class VentanaPokedex extends javax.swing.JFrame {

    //BufferedImage buffer = null; //DONDE COLOCO EL FONDO
    BufferedImage buffer1 = null; //DONDE SE PINTAN LOS POKEMON

    Image imagen1 = null; //POKEMON
    //Image imagen2 = null; //FONDO

    int contador = 0;
    Statement estado;
    ResultSet resultadoConsulta;
    Connection conexion;

    //ESTRUCTURA PARA GUARDAR TODO EL CONTENIDO DE LA BASE DE DATOS DE GOLPE
    HashMap<String, Pokemon> listaPokemons = new HashMap();

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) imagenPokemon.getGraphics();
        //Graphics2D g3 = (Graphics2D) fondo.getGraphics();
        //g3.drawImage(buffer, 0, 0, fondo.getWidth(), fondo.getHeight(), null);
        g2.drawImage(buffer1, 0, 0, imagenPokemon.getWidth(), imagenPokemon.getHeight(), null);

    }

    /**
     * Creates new form VentanaPokedex
     */
    public VentanaPokedex() {

        initComponents();
        this.setSize(1000, 700);
        fondo.setSize(1000, 700);
        try {
            //imagen2 = ImageIO.read(getClass().getResource("/imagenes/Pokedex.jpg"));
            imagen1 = ImageIO.read(getClass().getResource("/imagenes/black-white.png"));
        } catch (IOException ex) {
            System.out.println("No se pudo cargar la imagen");
        }
        buffer1 = (BufferedImage) imagenPokemon.createImage(imagenPokemon.getWidth(), imagenPokemon.getHeight());
        //buffer = (BufferedImage) fondo.createImage(fondo.getWidth(), fondo.getHeight());
        Graphics2D g2 = buffer1.createGraphics();
        //dibujaFondo();
        dibujaPokemon(contador);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/pokedex", "root", "");
            estado = conexion.createStatement();
            resultadoConsulta = estado.executeQuery("Select * from pokemon");
            //RECORREMOS EL ARRAY DEL RESULTADO UNO A UNO PARA IR CARGANDOLO EN EL HASHMAP
            while (resultadoConsulta.next()) {
                Pokemon p = new Pokemon();
                p.nombre = resultadoConsulta.getString("nombre");
                p.altura = resultadoConsulta.getString("altura");
                p.peso = resultadoConsulta.getString("peso");
                p.habilidad = resultadoConsulta.getString("habilidad");

                p.especie = resultadoConsulta.getString("especie");
                p.habitat = resultadoConsulta.getString("habitat");

                p.tipo1 = resultadoConsulta.getString("tipo1");
                p.tipo2 = resultadoConsulta.getString("tipo2");

                p.movimiento1 = resultadoConsulta.getString("movimiento1");
                p.movimiento2 = resultadoConsulta.getString("movimiento2");
                p.movimiento3 = resultadoConsulta.getString("movimiento3");
                p.movimiento4 = resultadoConsulta.getString("movimiento4");

                p.preEvolucion = resultadoConsulta.getInt("preEvolucion");
                p.posEvolucion = resultadoConsulta.getInt("posEvolucion");

                p.descripcion = resultadoConsulta.getString("descripcion");

                listaPokemons.put(resultadoConsulta.getString("id"), p);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("HAY ERROR");
        }

    }
//PARA PONER EL FONDO
    //private void dibujaFondo() { //TE DIBUJA EL POKEMON QUE ESTA EN ESA POSICION
    //Graphics2D g3 = (Graphics2D) buffer.getGraphics();
    // g3.setColor(Color.WHITE); //PINTA EL FONDO BLANCO
    // g3.drawImage(imagen2, 0,0,fondo.getWidth(),fondo.getHeight(),null);
    // }

    private void dibujaPokemon(int posicion) { //TE DIBUJA EL POKEMON QUE ESTA EN ESA POSICION
        int fila = posicion / 31;
        int columna = posicion % 31;
        Graphics2D g2 = (Graphics2D) buffer1.getGraphics();
        g2.setColor(Color.WHITE); //PINTA EL FONDO BLANCO
        g2.fillRect(0, 0, imagenPokemon.getWidth(), imagenPokemon.getHeight());
        g2.drawImage(imagen1, 0 // POSICION X INICIAL EN EL JPANEL
                ,
                 0 // POSICION Y INICIAL EN EL JPANEL
                ,
                 imagenPokemon.getWidth(), //ANCHO DEL JPANEL
                imagenPokemon.getHeight(), //ALTO DEL JPANEL
                columna * 96, //POSICION INICIAL X DENTRO DE LA IMAGEN DE LOS POKEMON
                fila * 96, //POSICION INICIAL Y DENTRO DE LA IMAGEN DE LOS POKEMON
                columna * 96 + 96, //POSICION FINAL X
                fila * 96 + 96, null); //POSICION FINAL Y
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fondo = new javax.swing.JPanel();
        imagenPokemon = new javax.swing.JPanel();
        derecha = new javax.swing.JButton();
        izquierda = new javax.swing.JButton();
        nombreNombre = new javax.swing.JLabel();
        nombrePokemon = new javax.swing.JLabel();
        alturaNombre = new javax.swing.JLabel();
        altura = new javax.swing.JLabel();
        pesoNombre = new javax.swing.JLabel();
        peso = new javax.swing.JLabel();
        habilidadNombre = new javax.swing.JLabel();
        habilidad = new javax.swing.JLabel();
        especieNombre = new javax.swing.JLabel();
        especie = new javax.swing.JLabel();
        habitatNombre = new javax.swing.JLabel();
        habitat = new javax.swing.JLabel();
        tipoNombre = new javax.swing.JLabel();
        tipo1 = new javax.swing.JLabel();
        tipo2 = new javax.swing.JLabel();
        movimientoNombre = new javax.swing.JLabel();
        movimiento1 = new javax.swing.JLabel();
        movimiento2 = new javax.swing.JLabel();
        movimiento3 = new javax.swing.JLabel();
        movimiento4 = new javax.swing.JLabel();
        PrePosNombre = new javax.swing.JLabel();
        preEvolucion = new javax.swing.JLabel();
        posEvolucion = new javax.swing.JLabel();
        descripcionNombre = new javax.swing.JLabel();
        descripcion = new javax.swing.JLabel();
        fondito = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout imagenPokemonLayout = new javax.swing.GroupLayout(imagenPokemon);
        imagenPokemon.setLayout(imagenPokemonLayout);
        imagenPokemonLayout.setHorizontalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        imagenPokemonLayout.setVerticalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        fondo.add(imagenPokemon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 290, 190));

        derecha.setBackground(new java.awt.Color(255, 255, 0));
        derecha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        derecha.setForeground(new java.awt.Color(255, 0, 0));
        derecha.setText(">");
        derecha.setBorder(null);
        derecha.setOpaque(false);
        derecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derechaActionPerformed(evt);
            }
        });
        fondo.add(derecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 60, 40));

        izquierda.setBackground(new java.awt.Color(255, 255, 0));
        izquierda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        izquierda.setForeground(new java.awt.Color(255, 0, 0));
        izquierda.setText("<");
        izquierda.setBorder(null);
        izquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izquierdaActionPerformed(evt);
            }
        });
        fondo.add(izquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 60, 40));

        nombreNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nombreNombre.setForeground(new java.awt.Color(204, 0, 0));
        nombreNombre.setText("NOMBRE");
        fondo.add(nombreNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 50, -1));

        nombrePokemon.setBackground(new java.awt.Color(255, 255, 255));
        nombrePokemon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombrePokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombrePokemon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        nombrePokemon.setOpaque(true);
        fondo.add(nombrePokemon, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 90, 30));

        alturaNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        alturaNombre.setForeground(new java.awt.Color(204, 0, 0));
        alturaNombre.setText("ALTURA");
        fondo.add(alturaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 50, -1));

        altura.setBackground(new java.awt.Color(255, 255, 255));
        altura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        altura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        altura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        altura.setOpaque(true);
        fondo.add(altura, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 30, 30));

        pesoNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pesoNombre.setForeground(new java.awt.Color(204, 0, 0));
        pesoNombre.setText("PESO");
        fondo.add(pesoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 50, -1));

        peso.setBackground(new java.awt.Color(255, 255, 255));
        peso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        peso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        peso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        peso.setOpaque(true);
        fondo.add(peso, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 30, 30));

        habilidadNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        habilidadNombre.setForeground(new java.awt.Color(204, 0, 0));
        habilidadNombre.setText("HABILIDAD");
        fondo.add(habilidadNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 70, -1));

        habilidad.setBackground(new java.awt.Color(255, 255, 255));
        habilidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        habilidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        habilidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        habilidad.setOpaque(true);
        fondo.add(habilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 80, 30));

        especieNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        especieNombre.setForeground(new java.awt.Color(204, 0, 0));
        especieNombre.setText("ESPECIE");
        fondo.add(especieNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 50, -1));

        especie.setBackground(new java.awt.Color(255, 255, 255));
        especie.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        especie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        especie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        especie.setOpaque(true);
        fondo.add(especie, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, 110, 30));

        habitatNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        habitatNombre.setForeground(new java.awt.Color(204, 0, 0));
        habitatNombre.setText("HABITAT");
        fondo.add(habitatNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 220, 50, -1));

        habitat.setBackground(new java.awt.Color(255, 255, 255));
        habitat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        habitat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        habitat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        habitat.setOpaque(true);
        fondo.add(habitat, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, 140, 30));

        tipoNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tipoNombre.setForeground(new java.awt.Color(204, 0, 0));
        tipoNombre.setText("TIPO");
        fondo.add(tipoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 30, -1));

        tipo1.setBackground(new java.awt.Color(255, 255, 255));
        tipo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tipo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        tipo1.setOpaque(true);
        fondo.add(tipo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 80, 30));

        tipo2.setBackground(new java.awt.Color(255, 255, 255));
        tipo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tipo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipo2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        tipo2.setOpaque(true);
        fondo.add(tipo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 80, 30));

        movimientoNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        movimientoNombre.setForeground(new java.awt.Color(204, 0, 0));
        movimientoNombre.setText("MOVIMIENTOS");
        fondo.add(movimientoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 90, -1));

        movimiento1.setBackground(new java.awt.Color(255, 255, 255));
        movimiento1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        movimiento1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        movimiento1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        movimiento1.setOpaque(true);
        fondo.add(movimiento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 110, 30));

        movimiento2.setBackground(new java.awt.Color(255, 255, 255));
        movimiento2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        movimiento2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        movimiento2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        movimiento2.setOpaque(true);
        fondo.add(movimiento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, 110, 30));

        movimiento3.setBackground(new java.awt.Color(255, 255, 255));
        movimiento3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        movimiento3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        movimiento3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        movimiento3.setOpaque(true);
        fondo.add(movimiento3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, 110, 30));

        movimiento4.setBackground(new java.awt.Color(255, 255, 255));
        movimiento4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        movimiento4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        movimiento4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        movimiento4.setOpaque(true);
        fondo.add(movimiento4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, 110, 30));

        PrePosNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PrePosNombre.setForeground(new java.awt.Color(204, 0, 0));
        PrePosNombre.setText("PREPOS. EVL");
        fondo.add(PrePosNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, 70, -1));

        preEvolucion.setBackground(new java.awt.Color(255, 255, 255));
        preEvolucion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        preEvolucion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        preEvolucion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        preEvolucion.setOpaque(true);
        fondo.add(preEvolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, 30, 30));

        posEvolucion.setBackground(new java.awt.Color(255, 255, 255));
        posEvolucion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        posEvolucion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posEvolucion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        posEvolucion.setOpaque(true);
        fondo.add(posEvolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, 30, 30));

        descripcionNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        descripcionNombre.setForeground(new java.awt.Color(204, 0, 0));
        descripcionNombre.setText("DESCRIPCION");
        fondo.add(descripcionNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 420, 90, -1));

        descripcion.setBackground(new java.awt.Color(255, 255, 255));
        descripcion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        descripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        descripcion.setOpaque(true);
        fondo.add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, 260, 60));

        fondito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pokedex.jpg"))); // NOI18N
        fondito.setOpaque(true);
        fondo.add(fondito, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void derechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derechaActionPerformed

        contador++;
        if (contador >= 649) {
            contador = 649;
        }
        dibujaPokemon(contador - 1);
        Pokemon p = listaPokemons.get(String.valueOf(contador));
        if (p != null) {
            nombrePokemon.setText(p.nombre);
            altura.setText(p.altura);
            peso.setText(p.peso);
            habilidad.setText(p.habilidad);
            especie.setText(p.especie);
            habitat.setText(p.habitat);
            tipo1.setText(p.tipo1);
            tipo2.setText(p.tipo2);
            preEvolucion.setText(String.valueOf(p.preEvolucion));
            posEvolucion.setText(String.valueOf(p.posEvolucion));
            movimiento1.setText(p.movimiento1);
            movimiento2.setText(p.movimiento2);
            movimiento3.setText(p.movimiento3);
            movimiento4.setText(p.movimiento4);
            descripcion.setText(p.descripcion);
        } else {
            nombrePokemon.setText("X");
            altura.setText("X");
            peso.setText("X");
            habilidad.setText("X");
            especie.setText("X");
            habitat.setText("X");
            tipo1.setText("X");
            tipo2.setText("X");
            preEvolucion.setText("X");
            posEvolucion.setText("X");
            movimiento1.setText("X");
            movimiento2.setText("X");
            movimiento3.setText("X");
            movimiento4.setText("X");
            descripcion.setText("X");
        }
    }//GEN-LAST:event_derechaActionPerformed

    private void izquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izquierdaActionPerformed

        contador--;
        if (contador < 0) {
            contador = 0;
        }
        dibujaPokemon(contador - 1);
        Pokemon p = listaPokemons.get(String.valueOf(contador));
        if (p != null) {
            nombrePokemon.setText(p.nombre);
        } else {
            nombrePokemon.setText("X");
        }
        if (p != null) {
            altura.setText(p.altura);
        } else {
            altura.setText("X");
        }
        if (p != null) {
            peso.setText(p.peso);
        } else {
            peso.setText("X");
        }
        if (p != null) {
            habilidad.setText(p.habilidad);
        } else {
            habilidad.setText("X");
        }
        if (p != null) {
            especie.setText(p.especie);
        } else {
            especie.setText("X");
        }
        if (p != null) {
            habitat.setText(p.habitat);
        } else {
            habitat.setText("X");
        }
        if (p != null) {
            tipo1.setText(p.tipo1);
        } else {
            tipo1.setText("X");
        }
        if (p != null) {
            tipo2.setText(p.tipo2);
        } else {
            tipo2.setText("X");
        }
        if (p != null) {
            preEvolucion.setText(String.valueOf(p.preEvolucion));
        } else {
            preEvolucion.setText("X");
        }
        if (p != null) {
            posEvolucion.setText(String.valueOf(p.posEvolucion));
        } else {
            posEvolucion.setText("X");
        }
        if (p != null) {
            movimiento1.setText(p.movimiento1);
        } else {
            movimiento1.setText("X");
        }
        if (p != null) {
            movimiento2.setText(p.movimiento2);
        } else {
            movimiento2.setText("X");
        }
        if (p != null) {
            movimiento3.setText(p.movimiento3);
        } else {
            movimiento3.setText("X");
        }
        if (p != null) {
            movimiento4.setText(p.movimiento4);
        } else {
            movimiento4.setText("X");
        }
        if (p != null) {
            descripcion.setText(p.descripcion);
        } else {
            descripcion.setText("X");
        }
    }//GEN-LAST:event_izquierdaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPokedex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PrePosNombre;
    private javax.swing.JLabel altura;
    private javax.swing.JLabel alturaNombre;
    private javax.swing.JButton derecha;
    private javax.swing.JLabel descripcion;
    private javax.swing.JLabel descripcionNombre;
    private javax.swing.JLabel especie;
    private javax.swing.JLabel especieNombre;
    private javax.swing.JLabel fondito;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel habilidad;
    private javax.swing.JLabel habilidadNombre;
    private javax.swing.JLabel habitat;
    private javax.swing.JLabel habitatNombre;
    private javax.swing.JPanel imagenPokemon;
    private javax.swing.JButton izquierda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel movimiento1;
    private javax.swing.JLabel movimiento2;
    private javax.swing.JLabel movimiento3;
    private javax.swing.JLabel movimiento4;
    private javax.swing.JLabel movimientoNombre;
    private javax.swing.JLabel nombreNombre;
    private javax.swing.JLabel nombrePokemon;
    private javax.swing.JLabel peso;
    private javax.swing.JLabel pesoNombre;
    private javax.swing.JLabel posEvolucion;
    private javax.swing.JLabel preEvolucion;
    private javax.swing.JLabel tipo1;
    private javax.swing.JLabel tipo2;
    private javax.swing.JLabel tipoNombre;
    // End of variables declaration//GEN-END:variables
}
