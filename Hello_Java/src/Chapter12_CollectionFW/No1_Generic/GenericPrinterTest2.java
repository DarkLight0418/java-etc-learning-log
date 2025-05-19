package Chapter12_CollectionFW.No1_Generic;

public class GenericPrinterTest2 {
    public static void main(String[] args) {
        GenericPrinter<Powder> powderPrinter = new GenericPrinter<Powder>();
        powderPrinter.setMaterial(new Powder());
        powderPrinter.printing();

        GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<Plastic>();

        plasticPrinter.setMaterial(new Plastic());
        plasticPrinter.printing();
    }
}
