import java.util.*;
import java.io.*;

public class AdvanceBot {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        HashMap<String,String>memory = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("chats.txt"));

        String line;
        while((line = br.readLine())!= null){
            String[] parts = line.split("\\|");
            if(parts.length == 2){
                memory.put(parts[0].trim().toLowerCase(),parts[1].trim());
            }

        }
        br.close();

        System.out.println("Bot Ready!"+memory.size()+"chats yaad hai. 'bye' likho band karne ke liye");

        while(true){
            System.out.print("\nTum: ");
            String msg = sc.nextLine().toLowerCase().trim();
            if(msg.equals("bye")) break;


            String jawab = memory.getOrDefault(msg,"mujhe ye nhi pta hain, mujhe sikhawo!");
            System.out.println("bot: "+jawab);

            if(jawab.startsWith("Mujhe")){
                System.out.println("Sikhawo");
                String newJawab = sc.nextLine();
                memory.put(msg,newJawab);


                FileWriter fw = new FileWriter("chats.txt",true);
                fw.write("\n"+msg+"|"+newJawab);
                fw.close();
                System.out.println("Bot:Yaad kar liya");
            }
        }
        sc.close();

    }
}