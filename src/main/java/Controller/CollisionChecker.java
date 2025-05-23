package Controller;

import Models.Entidades.Entidade;
import Views.Janela;

public class CollisionChecker {
    Janela j;

    public CollisionChecker(Janela j) {
        this.j = j;
    }

    public void checkTile(Entidade Entidades) {
        int entityLeftWorldX = Entidades.worldX + Entidades.solidArea.x;
        int entityRightWorldX = Entidades.worldX + Entidades.solidArea.x + Entidades.solidArea.width;
        int entityTopWorldY = Entidades.worldY + Entidades.solidArea.y;
        int entityBottomWorldY = Entidades.worldY + Entidades.solidArea.y + Entidades.solidArea.height;

        int entityLeftCol = entityLeftWorldX / j.tileSize;
        int entityRightCol = entityRightWorldX / j.tileSize;
        int entityTopRow = entityTopWorldY / j.tileSize;
        int entityBottomRow = entityBottomWorldY / j.tileSize;

        int tileNum1, tileNum2;

        switch (Entidades.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - Entidades.speed) / j.tileSize;
                tileNum1 = j.tm.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = j.tm.mapTileNum[entityRightCol][entityTopRow];

                if (j.tm.tile[tileNum1].collision == true || j.tm.tile[tileNum2].collision == true) {
                    Entidades.collisionOn = true;
                }
                
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + Entidades.speed) / j.tileSize;
                tileNum1 = j.tm.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = j.tm.mapTileNum[entityRightCol][entityBottomRow];

                if (j.tm.tile[tileNum1].collision == true || j.tm.tile[tileNum2].collision == true) {
                    Entidades.collisionOn = true;
                }
                Entidades.currentTile = tileNum1;   

                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - Entidades.speed) / j.tileSize;
                tileNum1 = j.tm.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = j.tm.mapTileNum[entityLeftCol][entityBottomRow];

                if (j.tm.tile[tileNum1].collision == true || j.tm.tile[tileNum2].collision == true) {
                    Entidades.collisionOn = true;
                }
                Entidades.currentTile = tileNum1;
                break;
            case "right":
                entityRightCol = (entityRightWorldX + Entidades.speed) / j.tileSize;
                tileNum1 = j.tm.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = j.tm.mapTileNum[entityRightCol][entityBottomRow];

                if (j.tm.tile[tileNum1].collision == true || j.tm.tile[tileNum2].collision == true) {
                    Entidades.collisionOn = true;
                }
                Entidades.currentTile = tileNum1;
                break;
        }
    }
    public int checkItem(Entidade entidade, boolean player){

        int index = 999;

        for (int i = 0; i < j.item.length; i++){

            if(j.item[i] != null){

                // area solida entidade
                entidade.solidArea.x = entidade.worldX + entidade.solidAreaDefaultX;
                entidade.solidArea.y = entidade.worldY + entidade.solidAreaDefaultY;
                // area solida item
                j.item[i].solidArea.x = j.item[i].worldX + j.item[i].solidAreaDefaultX;
                j.item[i].solidArea.y = j.item[i].worldY + j.item[i].solidAreaDefaultY;

                switch(entidade.direction){
                    case "up":
                        entidade.solidArea.y -= entidade.speed;
                        
                        break;
                    case "down":
                        entidade.solidArea.y += entidade.speed;
                        
                        break;
                    case "left":
                        entidade.solidArea.x -= entidade.speed;
                        break;
                    case "right":
                        entidade.solidArea.x += entidade.speed;
                        
                        break;
                }
                if(entidade.solidArea.intersects(j.item[i].solidArea)){
                    if(j.item[i].collision == true){
                        entidade.collisionOn = true;
                    }
                    if(player == true){
                    
                        index = i;
                    
                    }
                }
                entidade.solidArea.x = entidade.solidAreaDefaultX;
                entidade.solidArea.y = entidade.solidAreaDefaultY;
                j.item[i].solidArea.x = j.item[i].solidAreaDefaultX;
                j.item[i].solidArea.y = j.item[i].solidAreaDefaultY;
            }
        }

        return index;
    }
    // NPC ou MONSTRO
    public int checkEntidade(Entidade entidade, Entidade[] target){
        
        int index = 999;

        for (int i = 0; i < target.length; i++){

            if(target[i] != null){

                // area solida entidade
                entidade.solidArea.x = entidade.worldX + entidade.solidAreaDefaultX;
                entidade.solidArea.y = entidade.worldY + entidade.solidAreaDefaultY;
                // area solida item
                target[i].solidArea.x = target[i].worldX + target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].worldY + target[i].solidAreaDefaultY;

                switch(entidade.direction){
                    case "up":
                        entidade.solidArea.y -= entidade.speed;
                        
                    
                        break;
                    case "down":
                        entidade.solidArea.y += entidade.speed;
                        
                        break;
                    case "left":
                        entidade.solidArea.x -= entidade.speed;
                        
                        break;
                    case "right":
                        entidade.solidArea.x += entidade.speed;
                        
                        break;
                }
                if(entidade.solidArea.intersects(target[i].solidArea)){
                    if(target[i] != entidade){
                        entidade.collisionOn = true;
                        index = i;
                    }
                }

                entidade.solidArea.x = entidade.solidAreaDefaultX;  
                entidade.solidArea.y = entidade.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;
            }
        }

        return index;
        }

        public boolean checkPlayer(Entidade entidade) {

        boolean contactPlayer = false;

        // area solida entidade
        entidade.solidArea.x = entidade.worldX + entidade.solidAreaDefaultX;
        entidade.solidArea.y = entidade.worldY + entidade.solidAreaDefaultY;
        // area solida item
        j.player[j.playerIndex].solidArea.x = j.player[j.playerIndex].worldX + j.player[j.playerIndex].solidAreaDefaultX;
        j.player[j.playerIndex].solidArea.y = j.player[j.playerIndex].worldY + j.player[j.playerIndex].solidAreaDefaultY;

        switch (entidade.direction) {
            case "up":
            entidade.solidArea.y -= entidade.speed;
            break;
            case "down":
            entidade.solidArea.y += entidade.speed;
            break;
            case "left":
            entidade.solidArea.x -= entidade.speed;
            break;
            case "right":
            entidade.solidArea.x += entidade.speed;
            break;
        }

        if (entidade.solidArea.intersects(j.player[j.playerIndex].solidArea)) {
            entidade.collisionOn = true;
            contactPlayer = true;
        }

        entidade.solidArea.x = entidade.solidAreaDefaultX;
        entidade.solidArea.y = entidade.solidAreaDefaultY;
        j.player[j.playerIndex].solidArea.x = j.player[j.playerIndex].solidAreaDefaultX;
        j.player[j.playerIndex].solidArea.y = j.player[j.playerIndex].solidAreaDefaultY;
        
        return contactPlayer;

        }
    }
