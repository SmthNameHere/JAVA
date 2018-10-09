package lab3;
//Напишите программу, которая бы определяла, является ли введённая буква
//гласной или согласной.
public class Word {
    public static void solve(char letter){
        char[] vowels={'а', 'о', 'и', 'е', 'ё', 'э', 'ы', 'у', 'ю', 'я',
                       'А', 'О', 'И', 'Е', 'Ё', 'Э', 'Ы', 'У', 'Ю', 'Я' };
        boolean flag=false;
        for(char c:vowels){
            if(letter==c){
                flag=true;
            }
        }
        if(flag){
            System.out.println("Letter "+letter+" glasnaya");
        }
        else
            System.out.println("Letter "+letter+" soglasnaya");
    }

    }
