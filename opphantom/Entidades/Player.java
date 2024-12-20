/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maiocacedo.opphantom.Entidades;

import maiocacedo.opphantom.Principal.Janela;
import maiocacedo.opphantom.Principal.KeyHandler;

/**
 *
 * @author caiom
 */
public class Player extends Entidade{
    Janela j;
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;

    public Player(Janela j, KeyHandler keyH) {
        this.j = j;
        this.keyH = keyH;
        screenX = j.screenWidth/2;
        screenY = j.screenHeight/2;
    }
    
    
}
