public class Planet {

    private static final double GRAVITATIONAL_CONSTANT = 6.67e-11;

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    // to calculate the distances between two planets
    // remember to use the non-static method
    public double calcDistance(Planet p){
        double dx, dy, distance;
        dx = this.xxPos - p.xxPos;
        dy = this.yyPos - p.yyPos;
        distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        return distance;
    }

    // takes in a planet, and returns a double describing the force exerted on this planet by the given planet
    public double calcForceExertedBy(Planet p){
        double force;
        double distance = calcDistance(p);
        force = GRAVITATIONAL_CONSTANT * this.mass * p.mass / Math.pow(distance, 2);
        return force;
    }

    //describe the force exerted in the X and Y directions
    public double calcForceExertedByX(Planet p){
        double force = calcForceExertedBy(p);
        double distance = calcDistance(p);
        double dx = p.xxPos - this.xxPos;
        double xForce;
        xForce = force * (dx/distance);
        return xForce;
    }
    public double calcForceExertedByY(Planet p){
        double force = calcForceExertedBy(p);
        double distance = calcDistance(p);
        double dy = p.yyPos - this.yyPos;
        double yForce;
        yForce = force * (dy/distance);
        return yForce;
    }

    // calculate the net force
    public double calcNetForceExertedByX(Planet[] allPlanets){
        int numPlanets = allPlanets.length;
        double netForce = 0;
        for(int i = 0; i < numPlanets; i++){
            if(!this.equals(allPlanets[i])){
                netForce = netForce + calcForceExertedByX(allPlanets[i]);
            }
        }
        return netForce;
    }
    public double calcNetForceExertedByY(Planet[] allPlanets){
        int numPlanets = allPlanets.length;
        double netForce = 0;
        for(int i = 0; i < numPlanets; i++){
            if(!this.equals(allPlanets[i])){
                netForce = netForce + calcForceExertedByY(allPlanets[i]);
            }
        }
        return netForce;
    }

    public void update(double dt, double fx, double fy){
        double xAcceleration, yAcceleration;
        // 1.calculate the xAcceleration and yAcceleration
        xAcceleration = fx / this.mass;
        yAcceleration = fy / this.mass;

        // 2.calculate the new velocity
        this.xxVel = dt * xAcceleration + this.xxVel;
        this.yyVel = dt * yAcceleration + this.yyVel;

        // 3.calculate the new position
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}

