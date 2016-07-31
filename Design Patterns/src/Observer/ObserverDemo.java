package Observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by bsoimu on 7/30/2016.
 */
public class ObserverDemo {

    public static void main(String[] args) {

        TwitterStream messageStream = new TwitterStream();
        TinderStream tinderStream = new TinderStream();

        TwitterClient client1 = new TwitterClient("Andra");
        TwitterClient client2 = new TwitterClient("Razvan");

        messageStream.addObserver(client1);
        messageStream.addObserver(client2);

        TinderClient client3 = new TinderClient("Adam");
        TinderClient client4 = new TinderClient("Ana");

        tinderStream.addObserver(client3);
        tinderStream.addObserver(client4);

        tinderStream.someoneLiked();

        messageStream.deleteObserver(client2);

        messageStream.someoneTweeted();
    }
}

//concrete subject
class TwitterStream extends Observable {

    public void someoneTweeted() {
        setChanged();
        notifyObservers();
    }
}

class TinderStream extends Observable {

    public void someoneLiked() {
        setChanged();
        notifyObservers();
    }
}

//concrete observer
class TwitterClient implements Observer {

    public String name;

    public TwitterClient(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Update " + name + "'s stream, someone tweeted something.");
    }
}

class TinderClient implements Observer {

    public String name;

    public TinderClient(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Update " + name + "'s stream, someone liked you.");
    }

}
