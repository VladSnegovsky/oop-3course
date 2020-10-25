package com.company;

public class Shop {
    public Pants[] pants = new Pants[20];
    public int countPants;
    public ChainMail[] chainmail = new ChainMail[20];
    public int countChainMail;
    public Shirt[] shirt = new Shirt[20];
    public int countShirt;
    public Armor[] armor = new Armor[20];
    public int countArmor;
    public Footwear[] footwear = new Footwear[20];
    public int countFootwear;
    public Sword[] sword = new Sword[20];
    public int countSword;

    public void addSword(int size, int cost, int weight){
        Sword newsword = new Sword(size,cost,weight);
        sword[countSword] = newsword;
        countSword++;
    }
    public void sortSword(){
        boolean sorted = false;

        while (!sorted){
            sorted = true;
            for (int i = 0; i < countSword; i++){
                if (sword[i].Weight > sword[i+1].Weight){
                    sword[countSword] = sword[i];
                    sword[i] = sword[i+1];
                    sword[i+1] = sword[countSword];
                    sorted = false;
                }
            }
        }

        showallsword();
    }
    public void showallsword(){
        for (int i = 0; i < countSword; i++){
            System.out.println(sword[i].Size + " " + sword[i].Cost + " " + sword[i].Weight);
        }
    }

    public void addFootwear(int size, int cost, int weight){
        Footwear newfootwear = new Footwear(size,cost,weight);
        footwear[countFootwear] = newfootwear;
        countFootwear++;
    }
    public void sortFootwear(){
        boolean sorted = false;

        while (!sorted){
            sorted = true;
            for (int i = 0; i < countFootwear; i++){
                if (footwear[i].Weight > footwear[i+1].Weight){
                    footwear[countFootwear] = footwear[i];
                    footwear[i] = footwear[i+1];
                    footwear[i+1] = footwear[countFootwear];
                    sorted = false;
                }
            }
        }

        showallfootwear();
    }
    public void showallfootwear(){
        for (int i = 0; i < countFootwear; i++){
            System.out.println(footwear[i].Size + " " + footwear[i].Cost + " " + footwear[i].Weight);
        }
    }

    public void addArmor(String size, int cost, int weight){
        Armor newarmor = new Armor(size,cost,weight);
        armor[countArmor] = newarmor;
        countArmor++;
    }
    public void sortArmor(){
        boolean sorted = false;

        while (!sorted){
            sorted = true;
            for (int i = 0; i < countArmor; i++){
                if (armor[i].Weight > armor[i+1].Weight){
                    armor[countArmor] = armor[i];
                    armor[i] = armor[i+1];
                    armor[i+1] = armor[countArmor];
                    sorted = false;
                }
            }
        }

        showallarmor();
    }
    public void showallarmor(){
        for (int i = 0; i < countArmor; i++){
            System.out.println(armor[i].Size + " " + armor[i].Cost + " " + armor[i].Weight);
        }
    }

    public void addShirt(String size, int cost, int weight){
        Shirt newshirt = new Shirt(size,cost,weight);
        shirt[countShirt] = newshirt;
        countShirt++;
    }
    public void sortShirt(){
        boolean sorted = false;

        while (!sorted){
            sorted = true;
            for (int i = 0; i < countShirt; i++){
                if (shirt[i].Weight > shirt[i+1].Weight){
                    shirt[countShirt] = shirt[i];
                    shirt[i] = shirt[i+1];
                    shirt[i+1] = shirt[countShirt];
                    sorted = false;
                }
            }
        }

        showallshirt();
    }
    public void showallshirt(){
        for (int i = 0; i < countShirt; i++){
            System.out.println(shirt[i].Size + " " + shirt[i].Cost + " " + shirt[i].Weight);
        }
    }

    public void addChainMail(String size, int cost, int weight){
        ChainMail newchainmail = new ChainMail(size,cost,weight);
        chainmail[countChainMail] = newchainmail;
        countChainMail++;
    }
    public void sortChainMail(){
        boolean sorted = false;

        while (!sorted){
            sorted = true;
            for (int i = 0; i < countChainMail; i++){
                if (chainmail[i].Weight > chainmail[i+1].Weight){
                    chainmail[countChainMail] = chainmail[i];
                    chainmail[i] = chainmail[i+1];
                    chainmail[i+1] = chainmail[countChainMail];
                    sorted = false;
                }
            }
        }

        showallchainmail();
    }
    public void showallchainmail(){
        for (int i = 0; i < countChainMail; i++){
            System.out.println(chainmail[i].Size + " " + chainmail[i].Cost + " " + chainmail[i].Weight);
        }
    }

    public void addPants(String size, int cost, int weight){
        Pants newpants = new Pants(size,cost,weight);
        pants[countPants] = newpants;
        countPants++;
    }
    public void sortPants(){
        boolean sorted = false;

        while (!sorted){
            sorted = true;
            for (int i = 0; i < countPants; i++){
                if (pants[i].Weight > pants[i+1].Weight){
                    pants[countPants] = pants[i];
                    pants[i] = pants[i+1];
                    pants[i+1] = pants[countPants];
                    sorted = false;
                }
            }
        }

        showallpants();
    }
    public void showallpants(){
        for (int i = 0; i < countPants; i++){
            System.out.println(pants[i].Size + " " + pants[i].Cost + " " + pants[i].Weight);
        }
    }
}
