import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    /**
     * ���� ����� ������. � ������ ���� ���.
     * ���� 3 ����������: ��������, ������ � ������� ������.
     *
     * ����� ������� ����� "������� � ��������", � ������� ����� ������ ������ ������-�� ����.
     * ����� �������� ������� ������. � ��� ����� ��������� ������ � ������� ������ add.
     * � ������� ����� ������ �������� ��� � ������� ������ #getWeight.
     * ���������� ������� ����� ���������� � ������ �������. ��� ���� �������� ������� ���������, � ������ �����������.
     */
    public static void main(String[] args) {
//        Box<String> stringBox = new Box<>(); // �� ������ ���������������

        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange(1));
        orangeBox.add(new Orange(2));
//        orangeBox.add(new Apple(2));       // �� ������ ���������������
//        orangeBox.add(new GoldenApple(2)); // �� ������ ���������������

        System.out.println(orangeBox.getWeight()); // 3

        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple(1));
        appleBox.add(new GoldenApple(2)); // ���������� �������
        System.out.println(appleBox.getWeight()); // 3

        Box<GoldenApple> goldenAppleBox = new Box<>();
        goldenAppleBox.add(new GoldenApple(5)); // ���������� �������
//        goldenAppleBox.add(new Apple(5));       // �� ������ ���������������
        System.out.println(goldenAppleBox.getWeight()); // 5

        goldenAppleBox.moveTo(appleBox); // ���������� �������
//        appleBox.moveTo(goldenAppleBox); // �� ������ ���������������
//        orangeBox.moveTo(appleBox);      // �� ������ ���������������

        Box<Orange> orangeBox2 = new Box<>();
        orangeBox.moveTo(orangeBox2);
        System.out.println(orangeBox.getWeight()); // 0
        System.out.println(orangeBox2.getWeight()); // 3
    }

    // FIXME: 06.07.2023 �������� ������ ��������.
    static class Box<T extends Fruit> {

        public List<T> box = new ArrayList<>();
        void add(T fruit){
            box.add(fruit);
        }

        public int getWeight(){
            int boxWeight = 0;
            for (T frut :box) {
                boxWeight += frut.getWeight();
            }
            return boxWeight;
        }
        // FIXME: 06.07.2023 ����������� ������ �������� �������.
        public void moveTo (Box<? super T> fruts){
            for (T item:box) {
                fruts.add(item);
            }
            box.clear();
        }
    }

    static class Fruit {
        private final int weight;

        public Fruit(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }

    static class Orange extends Fruit {
        public Orange(int weight) {
            super(weight);
        }
    }

    static class Apple extends Fruit {
        public Apple(int weight) {
            super(weight);
        }
    }

    static class GoldenApple extends Apple {
        public GoldenApple(int weight) {
            super(weight);
        }
    }

}