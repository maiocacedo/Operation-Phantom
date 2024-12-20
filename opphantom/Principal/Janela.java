/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maiocacedo.opphantom.Principal;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author caiom
 */
public class Janela extends JPanel{
    final int originalTileSize = 16;
    final int scale = 3;
    
    final int tileSize = originalTileSize*scale;
    final int maxScreenRow = 12;
    final int maxScreenCol = 16;
    public final int screenWidth = tileSize*maxScreenCol;
    public final int screenHeight = tileSize*maxScreenRow;
    public Janela(){
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
         this.setBackground(Color.black);
         this.setDoubleBuffered(true);
    }

    
}
