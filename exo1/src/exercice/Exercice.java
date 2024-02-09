/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercice;

/**
 *
 * @author EMPEREUR STORE
 */
public class Exercice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Robot d2r2 = new Robot("D2R2");
        Robot data = new Robot("Data");

        Robot vainqueur = Arena.fight(d2r2, data);

        System.out.println("Le vainqueur est : " + vainqueur);
    // TODO code application logic here
    }
    
}
class Robot {
    private String nom;
    private int pointsDeVie;

    public Robot(String nom) {
        this.nom = nom;
        this.pointsDeVie = 10;
    }

    public void fire(Robot cible) {
        cible.perdreVie(2);
        System.out.println("Robot " + cible.getNom() + " a été touché par le Robot " + this.nom + " !");
    }

    public boolean isDead() {
        return pointsDeVie <= 0;
    }

    public void perdreVie(int points) {
        pointsDeVie -= points;
        if (pointsDeVie < 0) {
            pointsDeVie = 0;
        }
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Robot " + nom;
    }
}

class Arena {
    public static Robot fight(Robot robot1, Robot robot2) {
        while (!robot1.isDead() && !robot2.isDead()) {
            robot1.fire(robot2);
            if (!robot2.isDead()) {
                robot2.fire(robot1);
            }
        }
        if (robot1.isDead()) {
            return robot2;
        } else {
            return robot1;
        }
    }
}

