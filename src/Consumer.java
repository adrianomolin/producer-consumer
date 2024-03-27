public class Consumer implements Runnable{
    private Shared x;
    private int time;

    public Consumer(Shared x) {
        this.x = x;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((int) (Math.random() * getTime()));
            } catch (InterruptedException e) {
            }

            if (x.getBuffer() < 1) {
                System.out.println("Postponing consume as buffer equals 0");
                continue;
            }

            x.consume();
        }
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
