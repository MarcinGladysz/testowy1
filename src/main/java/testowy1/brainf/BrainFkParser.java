package testowy1.brainf;

public class BrainFkParser {

    public static void main(String[] args) {
        BrainFkProcessor testProcessor = new BrainFkProcessor();
        testProcessor.process("+++[>++<->>+[.-]<<]>+.");
        testProcessor.reset();
        testProcessor.process("++++++++++[>++++++<-]>+++++.");

    }

    }
