package bt3;

public class AlphabetThread extends Thread {
    private SharedResource sharedResource;

    public AlphabetThread(SharedResource sharedResource, String name) {
        super(name);
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        sharedResource.printAlphabet();
    }
}
