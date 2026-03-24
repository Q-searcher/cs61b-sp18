public class NBody {
    public static double readRadius(String fileName){
        In in = new In(fileName);
        int numPlanets = in.readInt(); // 读第一个数（不用）
        double radius = in.readDouble(); // 读第二个数（宇宙半径）
        return radius;
    }

    public static Planet[] readPlanets(String fileName){
        In in = new In(fileName);
        int numPlanets = in.readInt();
        double radius = in.readDouble();
        Planet[] planets = new Planet[numPlanets];

        double xP, yP, xV, yV, mass;
        String name;

        for(int i = 0; i < numPlanets; i++){
            xP = in.readDouble();
            yP = in.readDouble();
            xV = in.readDouble();
            yV = in.readDouble();
            mass = in.readDouble();
            name = in.readString();

            Planet p = new Planet(xP, yP, xV, yV, mass, name);
            planets[i] = p;
        }

        return planets;
    }

    // main function
    public static void main(String[] args){
        String imageToDraw = "images/starfield.jpg";

        double T, dt, radius;
        String filename;
        Planet[] planets;

        T = Double.parseDouble(args[0]);
        dt = Double.parseDouble(args[1]);
        filename = args[2];

        radius = readRadius(filename);
        planets = readPlanets(filename);

        // 1.draw the background
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0,0, imageToDraw);
        // 2.draw the stars
        for(Planet p: planets){
            p.draw();
        }

        StdDraw.enableDoubleBuffering();

        double initialTime;
        In in = new In(filename);
        int numPlanets = in.readInt();
        for(initialTime = 0; initialTime < T; initialTime += dt){
            double[] xForces = new double[numPlanets];
            double[] yForces = new double[numPlanets];
            for(int i = 0; i < numPlanets; i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for(int j = 0; j < numPlanets; j++){
                planets[j].update(dt, xForces[j], yForces[j]);
            }
            // 1.draw the background

            StdDraw.clear();
            StdDraw.picture(0,0, imageToDraw);
            // 2.draw the stars
            for(Planet p: planets){
                p.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);

            // to check whether it is correct
            StdOut.printf("%d\n", planets.length);
            StdOut.printf("%.2e\n", radius);
            for (int i = 0; i < planets.length; i++) {
                StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
            }

        }
    }
}
