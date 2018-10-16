package testowy1.brainf;

public class BrainFkProcessor {

    public static final char increment = '+';
    public static final char decrement = '-';
    public static final char moveNext = '>';
    public static final char moveBack = '<';
    public static final char print = '.';
    public static final char StartLoop = '[';
    public static final char EndLoop = ']';


    private Integer[] tab;
    private int pointer = 0;

    public BrainFkProcessor() {
        tab = new Integer[30];
        for(int i=0; i< tab.length;i++){
            tab[i] = 0;
        }

    }
    public void process(String input){
        int i = 0;
        while(i<input.length()){
            char c = input.charAt(i);
            System.out.println("kontorla c = "+c);


            if(c == StartLoop){
                int levelOfLoop= 1;
                int j = i+1;
                char inerloopChar;
                while(j!= EndLoop && levelOfLoop != 0 && j< input.length()){
                    inerloopChar = input.charAt(j);
                    if(inerloopChar == StartLoop){
                        levelOfLoop++;
                    }
                    if(inerloopChar == EndLoop){
                        levelOfLoop--;
                    }
                    j++;
                }
                loop(input.substring(i+1,j-1));
                i=j-1;

            }else if(c == print){
                System.out.println(tab[pointer]);
            }
            else if(c == increment){
                tab[pointer]++;
            }
            else if(c == decrement){
                tab[pointer]--;
            }
            else if(c == moveNext){
                pointer++;
            }
            else if(c == moveBack){
                pointer--;
            }



            i++;
        }



    }


    private void loop(String inputInLoop){
        int j = pointer;
        while(tab[j]!= 0){
            System.out.println("kontorla w pentli srodka = " + inputInLoop+ "  "+ tab[j]);
            process(inputInLoop);
        }
    }
}
