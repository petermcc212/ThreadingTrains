import java.util.Vector;

public abstract class Railway {

    private final String name;
    private final int trainCapacity;
    private final int length;
    private Vector<Train> currentTrains;

    public Railway(String name, int trainCapacity, int length) {
        this.name = name;
        this.trainCapacity = trainCapacity;
        this.length = length;
        currentTrains = new Vector<>();
    }

    public void addTrain(Train t){
        this.currentTrains.add(t);
    }

    public void removeTrain(Train t){
        this.currentTrains.remove(t);
    }
    public int calculateSpeed(Train train){
        int distance = this.getLength();
        int speed = train.getSpeed();
        int time = 0;
        time += distance / speed;
        // if it's a station then we add 5 seconds
        // to allow people to get on and off
        if(!this.name.contains("track")){
            time += 5000;
        }
        return time ;
    }

    public Vector<Train> getCurrentTrains() {
        return currentTrains;
    }


    public int getTrainCapacity() {
        return trainCapacity;
    }
    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String leftSegment = "|----";
        sb.append(leftSegment).append(" ").append(this.name).append(" ");
        for(Train t : this.currentTrains){
            sb.append(t.getTrainName());
            sb.append(',');
        }
        String rightSegment = "----|";
        sb.append(" ").append(rightSegment);
        return sb.toString();
    }
}