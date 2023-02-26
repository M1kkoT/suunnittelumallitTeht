package Decorator;


import java.util.Arrays;
import java.util.Random;


public class EncryptionDecorator extends DataHandlerdecorator{

    private String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUWVXYZ";
    private char[] ch = alphabet.toCharArray();

    public EncryptionDecorator(DataHandler dataHandlerToBeDecorated) {
        super(dataHandlerToBeDecorated);
    }

    @Override
    public void writeToFile(String file, String data){
        String encryptedData = encrypt(data);
        super.writeToFile(file, encryptedData);
    }

    @Override
    public String readFromFile(String file){
        String data = super.readFromFile(file);
        String[] lines = data.split("\r\n|\n|\r");
        String decrypted = "";
        for(String line : lines){
            decrypted += (decrypt(line) + "\n");
        }
        return decrypted;
    }

    @Override
    public String getDescription(){
        return super.getDescription() + " also encrypt and decrypt data";
    }

    private String encrypt(String data){

        //super secret and complicated encryption algorithm

        String cryptedData = "";

        //add a random letter to the start
        Random random = new Random();
        cryptedData += (char) (random.nextInt(26) + 'a');

        //change numbers to letters and vice versa
        for(int i = 0; i < data.length(); i++){
            char c = data.charAt(i);
            if(Character.isDigit(c)){
                cryptedData += ch[Integer.parseInt(String.valueOf(c))];
            }else if(Character.isAlphabetic(c)){
                String str = Character.toString(c);
                int num = alphabet.indexOf(str);
                //if the index is two digits put a mark
                if(num > 9){
                    cryptedData += "§" + num;
                }else{
                    cryptedData += num;
                }
            }else {
                cryptedData += c;
            }

        }

        return cryptedData;
    }

    private String decrypt(String data){

        //way too complicated decryption method

        String decrypted = "";
        char lastChar = 'a';
        int firstNum = -1;

        for(int i = 1; i < data.length(); i++){
            char c = data.charAt(i);

            if(lastChar == '§'){
                if(Character.isDigit(c)) {
                    firstNum = Integer.parseInt(String.valueOf(c));
                    if(decrypted.length() > 0){
                        decrypted = decrypted.substring(0, decrypted.length() - 1);
                    }
                }
                lastChar = 'a';
                continue;
            }
            if(firstNum > -1){
                int secondNum = Integer.parseInt(String.valueOf(c));
                String digit = String.format("%d%d", firstNum, secondNum);
                decrypted += ch[Integer.parseInt(digit)];
                firstNum = -1;
            }
            else if(Character.isDigit(c)){
                decrypted += ch[Integer.parseInt(String.valueOf(c))];
            }else if(Character.isAlphabetic(c)){
                String str = Character.toString(c);
                decrypted += alphabet.indexOf(str);
            }else {
                decrypted += c;
            }
            lastChar = c;
        }



        return decrypted;
    }


}
