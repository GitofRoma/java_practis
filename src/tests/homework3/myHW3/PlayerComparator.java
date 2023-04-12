package tests.homework3.myHW3;
import java.util.Comparator;

class PlayerComparator implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        return (int) ((p2.score - p1.score)*2);
    }
}