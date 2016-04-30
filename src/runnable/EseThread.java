package runnable;

public class EseThread {

    public static void main(String[] args) {
        Risorsa risorsa = new Risorsa();
        
        Thread uno = new Thread(new Vigenere(0,13,0,13,"1",risorsa));
        Thread due = new Thread(new Vigenere(0,13,13,26,"2",risorsa));
        Thread tre = new Thread(new Vigenere(13,26,0,13,"3",risorsa));
        Thread quattro = new Thread(new Vigenere(13,26,13,26,"4",risorsa));
        
        uno.start();
        System.out.println(uno.getName());
        due.start();
        System.out.println(due.getName());
        tre.start();
        System.out.println(tre.getName());
        quattro.start();
        System.out.println(quattro.getName());
        
        System.out.print("\nMatrice:\n");
        
        try{
            uno.join();
            due.join();
            tre.join();
            quattro.join();
        }
        catch(Exception e){
            System.err.println(e);
        }
        risorsa.print();
    }

}
