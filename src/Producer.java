public class Producer implements Runnable {

    private Shared x;
    private int time;

    public Producer(Shared x) {
        this.x = x;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((int) (Math.random() * getTime()));
            } catch (InterruptedException e) {
            }

            if (x.getBuffer() == x.bufferSize()) {
                System.out.println("Postponing produce as it reach the buffer size limit");
                continue;
            }

            x.produce();
        }
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
