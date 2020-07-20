import java.io.*;
import java.util.*;

public class PetadoptionSystem {
    Scanner in = new Scanner(System.in);
    private final static String newline = System.getProperty("line.separator");

    private Catalog catalog;
    private Sales sales;
    private Orders orders;
    private SalesFormatter salesFormatter;

    public PetadoptionSystem(Catalog catalog) {
        this.catalog = catalog;
        this.sales = new Sales();
        this.salesFormatter = PlainTextSalesFormatter.getPlainTextSalesFormatter();
        this.orders = new Orders();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Catalog catalog = null;

        try {
            catalog = (new FileCatalogLoader()).loadCatalog("animal.dat");
        } catch (FileNotFoundException e) {
            System.out.println("δ�ҵ��ļ�");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("�ļ��д��ڸ�ʽ����");
            e.printStackTrace();
        } catch (DataFormatException e) {

            e.printStackTrace();
        }

        PetadoptionSystem app = new PetadoptionSystem(catalog);
        app.run();

    }

    private void run() throws IOException, ClassNotFoundException {
        int i = getchoice();

        while (i != 0) {
            if (i == 1) {
                displayCatalog();
            } else if (i == 2) {
                displayAnimal();
            } else if (i == 3) {
                displayOrder();
            } else if (i == 4) {
                addAnimal();
            } else if (i == 5) {
                removeAnimal();
            } else if (i == 6) {
                addorder();
            }
            i = getchoice();
        }

    }

    private void addorder() throws FileNotFoundException, IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("orders.dat", true));
        Orders order = new Orders();

        while (true) {

            String code = "";

            while (true) {
                System.out.println("��������׼�������ĳ������");
                code = in.next();
                if (catalog.getanimal(code) == null) {
                    System.out.println("�����ڸñ���ĳ������������������");
                    System.out.println("�Ƿ�鿴���г�����Ϣ(�ǣ�Y����N)");
                    String choice = in.next();
                    if (choice.equalsIgnoreCase("Y")) {
                        displayCatalog();
                    }
                } else {
                    break;
                }
            }

            System.out.println("��������׼������������");
            int number = in.nextInt();
            order.addItem(new OrderItem(catalog.getanimal(code), number));
            String choice;
            System.out.println("���Ƿ��������������ǣ�Y������N��");
            choice = in.next();
            if (choice.equalsIgnoreCase("Y")) {

            } else {
                break;
            }
        }

        oos.writeObject(order);
        oos.close();
    }

    private void displayOrder() throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("orders.dat");
        ObjectInputStream ois = null;
        int i = 1;
        while (fis.available() > 0) {
            ois = new ObjectInputStream(fis);
            Orders order = (Orders) ois.readObject();
            System.out.println("____________________________");
            System.out.println("������   " + i);
            i++;
            for (OrderItem items : order) {
                System.out.println("������-���ࣨè������-��������");
                System.out.println(salesFormatter.formatOrders(order));
            }
        }
    }

    private void removeAnimal() throws IOException {
        String code;
        System.out.println("����������ɾ���ĳ�����");

        code = in.next();
        Animal animal = catalog.getanimal(code);
        catalog.removeAnimal(animal);
        String content = getString(catalog);
        writefile("animal.dat", content);
    }

    private void addAnimal() throws IOException {

        while (true) {
            String code = "";
            while (true) {
                System.out.println("������������");
                code = in.next();
                if (catalog.getanimal(code) != null) {
                    System.out.println("������ĳ�������Ѵ��ڣ�����������");
                    System.out.println("�Ƿ�鿴���г�����Ϣ(�ǣ�Y����N)");
                    String choice = in.next();
                    if (choice.equalsIgnoreCase("Y")) {
                        displayCatalog();
                    }
                } else {
                    break;
                }
            }

            System.out.println("������������ࣨè�͹���");
            String animal = in.next();
            System.out.println("�����������Ա�");
            String gender = in.next();
            System.out.println("������������ɫ");
            String colour = in.next();
            System.out.println("�����뱻�������");
            int year = in.nextInt();
            System.out.println("�������������");
            String name = in.next();
            System.out.println("���������Ʒ��");
            String kind = in.next();

            if (animal.equals("dog")) {
                catalog.addAnimal(new Dog(code, animal, gender, colour, year, name, kind));
                String content = getString(catalog);
                writefile("animal.dat", content);
                break;
            } else if (animal.equals("cat")) {
                catalog.addAnimal(new Cat(code, animal, gender, colour, year, name, kind));
                String content = getString(catalog);
                writefile("animal.dat", content);
                break;
            } else {
                System.out.println("������ĳ������ࣨè�͹�����������������");
            }
        }

    }

    private void writefile(String filename, String content) throws IOException {
        PrintWriter pt = new PrintWriter(new FileWriter(filename));

        pt.write(content);
        pt.close();

    }

    private void displayAnimal() {
        System.out.println("��������鿴�ĳ������");
        String code = in.next();
        int i = 0;
        for (Animal animals : catalog) {
            if (animals.getcode().equals(code)) {
                System.out.println(animals);
                i++;
            }
        }
        if (i == 0) {
            System.out.println("û�������Ϣ");
        }

    }

    private void displayCatalog() {
        System.out.println("����Ļ�����ϢΪ");
        System.out.println("������-��������-�Ա�-��ɫ-���ﱻ�������-��������-����Ʒ��");
        for (Animal animals : catalog) {
            System.out.println(animals);
        }

    }

    private int getchoice() {
        int input;
        while (true) {
            System.out.print("0>�˳�\n" + "1>չʾ����Ŀ¼\n" + "2>չʾ���������ĳ���Ŀ¼\n" + "3>չʾ������Ա��������������Ϣ\n" + "4>��ӳ���\n"
                    + "5>ɾ������\n" + "6>���������Ϣ\n");
            System.out.println("����ѡ����");
            input = in.nextInt();
            if (input >= 0 && input <= 6) {
                break;
            } else {
                System.out.println("�����ѡ�����������");
            }
        }
        return input;
    }

    public String getString(Catalog catalog) {

        String out = "";

        for (Animal animals : catalog) {
            if (animals instanceof Dog) {
                Dog dog = (Dog) animals;
                out += "Dog" + "_" + dog.toString() + newline;
            } else if (animals instanceof Cat) {
                Cat cat = (Cat) animals;
                out += "Cat" + "_" + cat.toString() + newline;
            }
        }

        return out;
    }

}
