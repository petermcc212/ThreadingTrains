import java.util.Vector;

public class RailRoute extends Thread{
    private final Vector<Railway> theRailRoute;
    public  RailRoute() {
        theRailRoute = new Vector<>();
        // station 1
        Station s1 = new Station("Station1", 3);
        theRailRoute.add(s1);
        Track t1 = new Track();
        theRailRoute.add(t1);
        Station s2 = new Station("Station2", 3);
        theRailRoute.add(s2);
        Track t2 = new Track();
        theRailRoute.add(t2);
        Station s3 = new Station("Station3", 2);
        theRailRoute.add(s3);
        Track t3 = new Track();
        theRailRoute.add(t3);
        Station s4 = new Station("Station4", 2);
        theRailRoute.add(s4);
    }
    public Vector<Railway> getTheRailRoute(){
        return this.theRailRoute;
    }

    public void run(){
        while(true){
            for(Railway railway : this.theRailRoute){
                System.out.print(railway.toString());
            }
            System.out.println();
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){

            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Railway r : this.theRailRoute){
            sb.append(r.toString());
        }
        return sb.toString();
    }
}
