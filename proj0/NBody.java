public class NBody {
    public static double readRadius(String fileName){
        In in = new In(fileName);
        int numPlanets = in.readInt(); // 读第一个数（不用）
        double radius = in.readDouble(); // 读第二个数（宇宙半径）
        return radius;
    }

    public static Planet[] readPlanets(String fileName){
        In in = new In(fileName);
        int numPlanets = in.readInt(); // 读第一个数（不用）
        double radius = in.readDouble(); // 读第二个数（不用）
        Planet[] planets = new Planet[numPlanets];

        for(int i = 0; i < numPlanets; i++){
            planets[i].xxPos = in.readDouble();
            planets[i].yyPos = in.readDouble();
            planets[i].xxVel = in.readDouble();
            planets[i].yyVel = in.readDouble();
            planets[i].mass= in.readDouble();
            planets[i].imgFileName = in.readString();
        }

        return planets;
    }
}