package Models.Entidades;

import java.awt.image.BufferedImage;

import Views.Janela;

public class Projetil extends Entidade{
    
    Entidade user;
    BufferedImage image;

    public Projetil(Janela j) {
        super(j);   
    }

    public void set(int worldX, int worldY, String direction, boolean alive, Entidade user){
        this.worldX = worldX;
        this.worldY = worldY;
        this.direction = direction;
        this.alive = alive;
        this.user = user;
        this.life = this.maxLife;

    }
    public void update(){

        switch(direction){
            case "up":
                worldY -= speed;
                break;
            case "down":
                worldY += speed;
                break;
            case "left":
                worldX -= speed;
                break;
            case "right":
                worldX += speed;
                break;
        }

        life--;
        if(life <= 0){
            alive = false;
        }

        spriteCounter++;
        if(spriteCounter > 12){
            if(spriteNum ==1){
                spriteNum = 2;
            }
            else if(spriteNum == 2){
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
        
    }

}
