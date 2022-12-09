public class PlayerEn {
    // Enhanced Player
    private String fullName;
    private int healthPresentage;
    private String weapon;

    public PlayerEn(String fullName) {
        this(fullName, 100,"Rifle");
    }

    public PlayerEn(String fullName, int healthPresentage, String weapon) {
        this.fullName = fullName;
        if(healthPresentage <= 0){
            this.healthPresentage = 1;
        } else if (healthPresentage > 100) {
            this.healthPresentage = 100;
        } else {
            this.healthPresentage = healthPresentage;
        }
        this.weapon = weapon;
    }

    public void looseHealth(int damage){
        healthPresentage = healthPresentage - damage;
        if(healthPresentage <= 0){
            System.out.println("Player knocked out of game");
        }
    }

    public int healthRemaining(){
        return healthPresentage;
    }

    public void restoreHealth (int extraHealth){

        healthPresentage = healthPresentage + extraHealth;
        if(healthPresentage >100){
            System.out.println("Player restored to 100%");
            healthPresentage = 100;
        }
    }
}
