package bt6;
public class TestMoveablePoint {
    public static void main(String[] args) {
        MoveablePoint mp = new MoveablePoint(1, 1, 2, 3);
        System.out.println(mp);

        mp.move();
        System.out.println(mp);

        mp.setxSpeed(5);
        System.out.println(mp);
    }
}
