public class Shared {
    private int buffer;
    private int bufferSize;

    public Shared() {
        this(0,5);
    }

    public Shared(int buffer, int bufferSize) {
        this.buffer = buffer;
        this.bufferSize = bufferSize;
    }

    public synchronized void consume() {
        System.out.println("Consumed buffer memory, BufferSize: " + this.bufferSize);
        setBuffer(getBuffer() - 1);
    }

    public synchronized void produce() {
        System.out.println("Produced buffer memory, BufferSize: " + this.bufferSize);
        setBuffer(getBuffer() + 1);
    }

    public int bufferSize() {
        return this.bufferSize;
    }

    public int getBuffer() {
        return this.buffer;
    }

    private void setBuffer(int buffer) {
        this.buffer = buffer;
    }
}
