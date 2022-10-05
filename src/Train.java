import java.util.ListIterator;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Train extends Thread{

    // fast or slow train
    String trainType;
    int speed;
    String trainName;
    private  RailRoute railRoute;
    private ReentrantLock lock = new ReentrantLock();
    private Condition c = lock.newCondition();
    private boolean ready = true;

    public Train(String trainType, RailRoute railRoute, String trainName) {
        this.railRoute = railRoute;
        this.trainType = trainType;
        if(this.trainType.equals("fast")){
            this.speed = 500;
        }
        else{this.speed = 10;}

        this.setTrainName(trainName);
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public synchronized void run() {


        // logic for moving train along the route
        try{
            lock.lock();
            ListIterator<Railway> it = railRoute.getTheRailRoute().listIterator();
            while(it.hasNext()){
                Railway current = it.next();
                int canHold = current.getTrainCapacity();
                int trainsThere = current.getCurrentTrains().size();
                while(trainsThere == canHold){
                    c.await();

                }
                c.signalAll();
                current.addTrain(this);
                Thread.sleep(current.calculateSpeed(this));
                it.previous().removeTrain(this);
                if(it.hasNext()){
                    current = it.next();
                }else{
                    current.removeTrain(this);
                }

            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

}